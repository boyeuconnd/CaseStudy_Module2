package codegym.user;

import codegym.controller.ProductManager;
import codegym.model.Product;

public class Main extends ProductManager {
    public static void main(String[] args) {
        ProductManager admin = new ProductManager();
        admin.showProductList();
        admin.addProduct("AP1","IphoneSE2",12600,NEW,"128G Storage");
        admin.addProduct("AP2","IphoneX",18600,NEW,"256G Storage");
        admin.addProduct("SS1","GalaxyS20",17900,NEW,"256G Storage");
        admin.addProduct("SS2","GalaxyNote10",20300,NEW,"256G Storage,S-pen");
        admin.deleteProduct("iphonese3"); //not found
        admin.deleteProduct("galaxys20");
        admin.showProductList();



    }
}
