package codegym.user;

import codegym.controller.ProductManager;
import codegym.passwordManager.PassWordField;
import codegym.storage.ProductList;
import codegym.synchronization.Synchronizer;

import java.util.InputMismatchException;
import java.util.Scanner;

import static codegym.impl.ProductStatic.DECREASING;
import static codegym.impl.ProductStatic.INCREASING;

public class UserDisplay {
    private static final int SHOW_PRODUCT_LIST = 1;
    private static final int ADD_PRODUCT = 4;
    private static final int FIND_PRODUCT = 2;
    private static final int DELETE_PRODUCT = 5;
    private static final int SORT_BY_PRICE = 3;
    private static final int EDIT_PRODUCT = 6;
    private static final int RETURN = 9;
    private static final int EXIT = 0;
    static Scanner scn = new Scanner(System.in);
    static ProductManager productManager = ProductManager.getInstance();
    static ProductList list = ProductList.getInstance();
    static int accType =-1;
    public static void start() {

        int choice = -1;
        Synchronizer sync = new Synchronizer();
        sync.syncPull(list.getProductFile());
        try {
            chooseAccount();
            while (choice != 0) {
                boolean isAdmin = accType == 1;
                if(isAdmin){
                    showMenuAdmin();
                }else {
                    showMenuCustomer();
                }
                choice = scn.nextInt();
                switch (choice) {
                    case SHOW_PRODUCT_LIST: { //Show product list
                        productManager.showProductList();
                        break;
                    }
                    case ADD_PRODUCT: {  //Add product
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
                        break;
                    }
                    case FIND_PRODUCT: { //Find product
                        System.out.print("Enter product name: ");
                        scn.nextLine();
                        String findName = scn.nextLine();
                        boolean result = productManager.findProduct(findName);
                        if(result){

                        }else {
                            System.out.println("Product "+findName+" not found, try again.");
                        }
                        break;
                    }
                    case DELETE_PRODUCT: { //Delete method
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
                        break;
                    }
                    case SORT_BY_PRICE: { //Sort by price
                        System.out.println("Choose type of sort:");
                        System.out.println("1. Increasing");
                        System.out.println("2. Decreasing");
                        scn.nextLine();
                        int choosen = scn.nextInt();
                        if (choosen == 1) {
                            productManager.sortProductList(INCREASING);
                        } else productManager.sortProductList(DECREASING);
                        break;
                    }
                    case EDIT_PRODUCT: {  //Edit product static by ID
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
                        break;
                    }
                    case RETURN: { //Return
                        chooseAccount();
                        break;
                    }
                    case EXIT: { //Synchronize and Log out
                        System.out.println("Logging out...");
                        if(isAdmin){
                            sync.syncPush();
                        }
                        System.exit(-1);
                        break;
                    }
                    default: {
                        System.out.println("Valid choose!");
                    }

                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Enter values is words:");
            start();
        } catch (NumberFormatException nfe) {
            System.err.println("Enter numbers instead of words:");

        }

    }

    private static void showMenuAdmin() {
        System.out.println("=====Menu=====");
        System.out.println("1. Show products list");
        System.out.println("2. Find product by name");
        System.out.println("3. Sort by price");
        System.out.println("4. Add product");
        System.out.println("5. Delete product by name");
        System.out.println("6. Edit product static");
        System.out.println("9. Return");
        System.out.println("0. Synchronize and Exit");
        System.out.print("Enter your choice: ");
    }

    private static void showMenuCustomer() {
        System.out.println("=====Menu=====");
        System.out.println("1. Show products list");
        System.out.println("2. Find product by name");
        System.out.println("3. Sort by price");
        System.out.println("9. Return");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void showWelcome(){
        System.out.println("Welcome to LuxuryPhoneStore: Who are you?");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void chooseAccount(){
        PassWordField password = PassWordField.getInstance();
        showWelcome();
        accType = scn.nextInt();
        scn.nextLine();
        if(accType==1){
            String uncheckPass = password.enterPassword();
            if(!uncheckPass.equals(PassWordField.getInstance().getPASSWORD())){
                System.out.println("Wrong password!!!");
                chooseAccount();
            }
        }
        if(accType!=1&&accType!=2){
            System.out.print("Exit system!");
            System.exit(-1);
        }
    }
}
