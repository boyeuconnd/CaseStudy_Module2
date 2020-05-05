package codegym.storage;

import codegym.model.Product;

import java.io.File;
import java.util.ArrayList;

public class ProductList extends Product  {
    public static ArrayList<Product> productsList = new ArrayList<Product>();
    public File productFile = new File("D:\\CodeGym\\MiddleTest_M2\\src\\codegym\\storage\\productFile.txt");
}
