package codegym.storage;

import codegym.model.Product;

import java.io.File;
import java.util.ArrayList;

public class ProductList extends Product  {
    public  ArrayList<Product> productsList = new ArrayList<Product>();
    private ProductList (){};
    private static volatile ProductList instance;
    public synchronized static ProductList getInstance(){
        if(instance == null){
           instance= new ProductList();
        }
        return instance;
    }

    public File getProductFile() {
        return productFile;
    }

    public File getBack_up() {
        return back_up;
    }

    private File productFile = new File("D:\\CodeGym\\MiddleTest_M2\\src\\codegym\\storage\\productFile.txt");
    private File back_up = new File("D:\\CodeGym\\MiddleTest_M2\\src\\codegym\\storage\\back_up.txt");
}
