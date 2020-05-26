package codegym.storage;

import codegym.model.Product;

import java.io.File;
import java.util.ArrayList;

public class ProductList extends Product  {
    private   ArrayList<Product> productsList = new ArrayList<>();
    private ProductList (){};
    private static volatile ProductList instance;
    public synchronized static ProductList getInstance(){
        if(instance == null){
           instance= new ProductList();
        }
        return instance;
    }
    public ArrayList<Product> getArrayList() {
        return productsList;
    }
    public File getProductFile() {
        return productFile;
    }

    public File getBack_up() {
        return back_up;
    }

    private File productFile = new File("D:\\CodeGym\\CaseStudy_Module2\\src\\codegym\\storage\\productFile.txt");
    private File back_up = new File("D:\\CodeGym\\CaseStudy_Module2\\src\\codegym\\storage\\back_up.txt");
}
