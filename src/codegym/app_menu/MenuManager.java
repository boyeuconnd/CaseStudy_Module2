package codegym.app_menu;

import codegym.controller.CrawlerFacade;
import codegym.controller.ProductManager;
import codegym.passwordManager.PasswordField;
import codegym.storage.ProductList;
import codegym.synchronization.Synchronize;

import java.util.InputMismatchException;
import java.util.Scanner;

import static codegym.model.impl.ProductStatic.DECREASING;
import static codegym.model.impl.ProductStatic.INCREASING;

public class MenuManager {
    static Scanner scn = new Scanner(System.in);
    static ProductManager productManager = ProductManager.getInstance();
    static ProductList list = ProductList.getInstance();
    static Synchronize sync = new Synchronize();
    int accType;

    int layer = 1;
    public void start() {
        if(list.getArrayList().isEmpty()){
            sync.syncPull(list.getProductFile());
        }
        int choice;
        if(layer == 1){
            accType =chooseAccount();
        }else {
            if(accType == 1 ){
                showMenuAdmin();
            }else {
                showMenuCustomer();
            }
        }
        choice = scn.nextInt();
        this.choiceAction(choice);


    }
    private void choiceAction(int choice){
        boolean isAdmin = accType == 1;
        try {

            switch (choice) {
                case MenuChoose.SHOW_PRODUCT_LIST: {
                    if(!productManager.showProductList()){
                        System.out.println("List empty.");
                    }
                    start();
                    break;
                }
                case MenuChoose.ADD_PRODUCT: {
                    if(isAdmin){
                        System.out.println("Enter id,name,price,status,description space between any static");
                        scn.nextLine();
                        String id = scn.next();
                        String name = scn.next();
                        int price = Integer.parseInt(scn.next());
                        int status = Integer.parseInt(scn.next());
                        String description = scn.next();
                        productManager.addProduct(id, name, price, status, description);
                    }else {
                        System.out.println("Valid choose!");
                    }
                    start();
                    break;
                }
                case MenuChoose.FIND_PRODUCT: {
                    System.out.print("Enter product name: ");
                    scn.nextLine();
                    String findName = scn.nextLine();
                    boolean result = productManager.regexSearchProduct(findName);
                    if(!result){
                        System.out.println("Product "+findName+" not found, try again.");
                    }
                    start();
                    break;
                }
                case MenuChoose.DELETE_PRODUCT: {
                    if(isAdmin){
                        System.out.print("Enter product name: ");
                        scn.nextLine();
                        String deleteName = scn.nextLine();
                        boolean result = productManager.deleteProduct(deleteName);
                        if(result){
                            System.out.println("Product deleted.");
                        }else {
                            System.out.println("Product "+deleteName+" not found, try again.");
                        }
                    }else {
                        System.out.println("Valid choose!");
                    }
                    start();
                    break;
                }
                case MenuChoose.SORT_BY_PRICE: {
                    System.out.println("Choose type of sort:");
                    System.out.println("1. Increasing");
                    System.out.println("2. Decreasing");
                    scn.nextLine();
                    int choosen = scn.nextInt();
                    if (choosen == 1) {
                        productManager.sortProductList(INCREASING);
                    } else productManager.sortProductList(DECREASING);
                    start();
                    break;
                }
                case MenuChoose.EDIT_PRODUCT: {
                    if(isAdmin){
                        System.out.print("Enter product ID you want to edit: ");
                        scn.nextLine();
                        String editId = scn.nextLine();
                        boolean result = productManager.editProductStatic(editId);
                        if(result){
                            System.out.println("Product ID: "+editId+" had edited.");
                        }else {
                            System.out.println("Product ID: "+editId+ " not found!");
                        }
                    }else {
                        System.out.println("Valid choose!");
                    }
                    start();
                    break;
                }
                case MenuChoose.CRAWLER:{
                    if(isAdmin){
                        System.out.println("Crawled, please reset the app");
                        CrawlerFacade crawlerFacade = CrawlerFacade.getInstance();
                        crawlerFacade.startCrawler();
                        System.exit(-1);
                    }
                    start();
                    break;
                }
                case MenuChoose.FILTER_PRICE:{
                    System.out.print("Enter min price:");
                    int min = scn.nextInt();
                    System.out.print("Enter max price:");
                    int max = scn.nextInt();
                    boolean result = productManager.filterByPrice(min,max);
                    if(!result) System.out.println("Valid price or no product with this price range");
                    start();
                    break;
                }
                case MenuChoose.RETURN: {
                    layer =1;
                    break;
                }
                case MenuChoose.EXIT: {
                    System.out.println("Logging out...");
                    if(isAdmin){
                        sync.syncPushCommand();
                    }
                    System.exit(-1);
                    break;
                }
                default: {
                    System.out.println("Valid choose!");
                }

            }
//            }
        } catch (InputMismatchException e) {
            System.err.println("Enter values is words:");
        } catch (NumberFormatException nfe) {
            System.err.println("Enter numbers instead of words:");
        } finally {
            start();
        }

    }

    private void showMenuAdmin() {
        System.out.println("============Menu============");
        System.out.println("|1. Show products list     |");
        System.out.println("|2. Find product by name   |");
        System.out.println("|3. Sort by price          |");
        System.out.println("|4. Add product            |");
        System.out.println("|5. Delete product by name |");
        System.out.println("|6. Edit product static    |");
        System.out.println("|7. Crawler                |");
        System.out.println("|8. Filter by price        |");
        System.out.println("|9. Return                 |");
        System.out.println("|0. Synchronize and Exit   |");
        System.out.println("============================");
        System.out.print("Enter your choice: ");
    }

    private void showMenuCustomer() {
        System.out.println("============Menu============");
        System.out.println("|1. Show products list     |");
        System.out.println("|2. Find product by name   |");
        System.out.println("|3. Sort by price          |");
        System.out.println("|8. Filter by price        |");
        System.out.println("|9. Return                 |");
        System.out.println("|0. Exit                   |");
        System.out.println("============================");
        System.out.print("Enter your choice: ");
    }
    public void showWelcome(){
        System.out.println("Welcome to LuxuryPhoneStore: Who are you?");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    private int chooseAccount(){
        PasswordField password = PasswordField.getInstance();
        showWelcome();
        accType = scn.nextInt();
        scn.nextLine();
        if(accType==1){
            String uncheckPass = password.enterPassword();
            if(!uncheckPass.equals(PasswordField.getInstance().getPASSWORD())){
                System.out.println("Wrong password!!!");
                layer =1;
            }else {
                layer++;
                this.start();
            }

        }else if(accType ==2){
            layer++;
            this.start();
        }
        if(accType!=1&&accType!=2){
            System.out.print("Exit system!");
            System.exit(-1);
        }
        return accType;
    }
}
