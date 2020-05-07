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
    static Scanner scn = new Scanner(System.in);
    static ProductManager admin = ProductManager.getInstance();
    static ProductList list = new ProductList();
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
                    case 1: { //Show product list
                        admin.showProductList();
                        break;
                    }
                    case 4: {  //Add product
                        if(isAdmin){
                            System.out.println("Enter id,name,price,status,description space between any static");
                            scn.nextLine();
                            String id = scn.next();
                            String name = scn.next();
                            int price = Integer.parseInt(scn.next());
                            int status = Integer.parseInt(scn.next());
                            String description = scn.next();
                            admin.addProduct(id, name, price, status, description);
                        }else {
                            System.out.println("Valid choose!");
                        }
                        break;
                    }
                    case 2: { //Find product
                        System.out.print("Enter product name: ");
                        scn.nextLine();
                        String findName = scn.nextLine();
                        boolean result = admin.findProduct(findName);
                        if(result){

                        }else {
                            System.out.println("Product "+findName+" not found, try again.");
                        }
                        break;
                    }
                    case 5: { //Delete method
                        if(isAdmin){
                            System.out.print("Enter product name: ");
                            scn.nextLine();
                            String deleteName = scn.nextLine();
                            boolean result = admin.deleteProduct(deleteName);
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
                    case 3: { //Sort by price
                        System.out.println("Choose type of sort:");
                        System.out.println("1. Increasing");
                        System.out.println("2. Decreasing");
                        scn.nextLine();
                        int choosen = scn.nextInt();
                        if (choosen == 1) {
                            admin.sortProductList(INCREASING);
                        } else admin.sortProductList(DECREASING);
                        break;
                    }
                    case 6: {  //Edit product static by ID
                        if(isAdmin){
                            System.out.print("Enter product ID you want to edit: ");
                            scn.nextLine();
                            String editId = scn.nextLine();
                            boolean result = admin.editProductStatic(editId);
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
                    case 9: { //Return
                        chooseAccount();
                        break;
                    }
                    case 0: { //Synchronize and Log out
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
            System.err.println("Giá trị nhập vào là chữ:");
            start();
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
        showWelcome();
        accType = scn.nextInt();
        scn.nextLine();
        if(accType==1){
            System.out.print("Enter password: ");
            String uncheckPass = scn.nextLine();
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