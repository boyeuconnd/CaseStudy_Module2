package codegym.controller;

import codegym.controller.impl.ProductManagerActs;
import codegym.model.Product;
import codegym.storage.ProductList;


import java.util.*;

public class ProductManager implements ProductManagerActs {
    Scanner scn = new Scanner(System.in);
    ProductList listInstance = ProductList.getInstance();
    ArrayList<Product> productsList = listInstance.getArrayList();
    private ProductManager(){
    }
    private static volatile ProductManager instance;
    public synchronized static ProductManager getInstance(){
        if(instance ==null){
            instance = new ProductManager();
        }
        return instance;
    }
    @Override
    public boolean showProductList() {

        if(productsList.isEmpty()){
            return false;
        }else {
            ShowArray();
        }
        return true;

    }


    @Override
    public boolean addProduct(String id,String name,int price,int status,String description){
        Product addProduct = new Product(id, name, price,status,description) {};
        productsList.add(addProduct);
        if(productsList.contains(addProduct)) {
            return true;
        }
        return false;
    }



    @Override
    public boolean editProductStatic(String id) {
        for (Product product: productsList) {
            if(product.getId().equalsIgnoreCase(id)){
                EditProductStatic(product);
                return true;
            }
        }
        return false;
    }



    @Override
    public boolean deleteProduct(String name) {

        for (Product product: productsList) {
            if(product.getName().equalsIgnoreCase(name)){
                productsList.remove(product);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean findProduct(String name) {

        for (Product product: productsList) {
            if(product.getName().equalsIgnoreCase(name)){
                ShowElement(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public void sortProductList(boolean keyword) {
        TreeMap<Integer,Product> sortList = new TreeMap<Integer,Product>();
        for (Product element: productsList) {
            sortList.put(element.getPrice(),element);
        }
        if(keyword){
            Set<Integer> keys = sortList.keySet();
            for (Integer key: keys){
                PrintArray(sortList.get(key));
            }
        }else {
            Set<Integer> keys = sortList.descendingMap().keySet();
            for (Integer key: keys){
                PrintArray(sortList.get(key));
            }
        }


    }
    private void ShowArray() {
        Iterator<Product> iterator = productsList.iterator();
        while (iterator.hasNext()){
            Product thisProduct = iterator.next();
            PrintArray(thisProduct);

        }
    }
    private void PrintArray(Product product){
        System.out.printf("ID: %-5s |Name: %-32s |Price: %-9d |Status: %d |Description: %s \n",
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStatus(),
                product.getDescription());

    }
    private void ShowElement(Product product) {
        System.out.println("Product found.");
        PrintArray(product);
    }
    private void EditProductStatic(Product product) {
        System.out.print("Enter new Name:");
        String newName = scn.nextLine();
        System.out.print("Enter new price: ");
        int newPrice = scn.nextInt();
        while (newPrice<0){
            System.out.print("Valid price, reEnter: ");
            newPrice=scn.nextInt();
            if(newPrice>=0)break;
        }

        System.out.print("Enter new status:");
        int newStatus = scn.nextInt();
        while (newStatus<1 || newStatus>4){
            System.out.print("Valid status, reEnter: ");
            newStatus=scn.nextInt();
            if(newStatus>=1&&newStatus<=4)break;
        }
        System.out.println("Enter new description:");
        scn.nextLine();
        String newDescription= scn.nextLine();
        product.setName(newName);
        product.setPrice(newPrice);
        product.setStatus(newStatus);
        product.setDescription(newDescription);
    }

}
