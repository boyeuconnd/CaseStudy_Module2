package codegym.user;

import codegym.controller.ProductManager;
import codegym.model.Product;

import java.util.Scanner;

public class Main extends ProductManager {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ProductManager admin = new ProductManager();
        int choice =-1;
        admin.Synchronization();

        while (choice!=0){
            ShowMenu();
            choice = scn.nextInt();
            switch (choice){
                case 1:{
                    admin.showProductList();
                    break;
                }
                case 2:{
                    System.out.println("Enter id,name,price,status,description space between any static");
                    scn.nextLine();
                    String id = scn.next();
                    String name = scn.next();
                    int price = Integer.parseInt(scn.next());
                    int status = Integer.parseInt(scn.next());
                    String description = scn.next();
                    admin.addProduct(id,name,price,status,description);
                    break;
                }
                case 3:{
                    System.out.print("Enter product name: ");
                    scn.nextLine();
                    String findName = scn.nextLine();
                    admin.findProduct(findName);
                    break;
                }
                case 4:{
                    System.out.print("Enter product name: ");
                    scn.nextLine();
                    String deleteName = scn.nextLine();
                    admin.deleteProduct(deleteName);
                    break;
                }
                case 5:{
                    admin.sortProductList(INCREASING);
                    break;
                }

            }
        }
        if(choice==0){
            System.out.println("Logging out...");
            System.exit(-1);
        }


    }

    private static void ShowMenu() {
        System.out.println("=====Menu=====");
        System.out.println("1. Show products list");
        System.out.println("2. Add product");
        System.out.println("3. Find product by name");
        System.out.println("4. Delete product by name");
        System.out.println("5. Sort price by increase");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}
