package codegym.controller;

import codegym.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @BeforeEach
    void setupArrayList(){
        ProductManager productManager = ProductManager.getInstance();
        productManager.addProduct("001","phone1",100,1,"none");
        productManager.addProduct("002","phone2",100,1,"none");
        productManager.addProduct("003","phone3",100,2,"none");
        productManager.addProduct("004","phone4",100,3,"none");
        productManager.addProduct("005","phone5",100,4,"none");
    }

    @Test
    void showProductList() {
        boolean result = ProductManager.getInstance().showProductList();
        assertTrue(result);
    }

    @Test
    void addProduct() {
        boolean result = ProductManager.getInstance().addProduct("test","name",200,1,"test");
        assertTrue(result);
    }

    @Test
    void editProductStatic() {
        boolean resultFalse1 = ProductManager.getInstance().editProductStatic("falseName");
        assertFalse(resultFalse1);

    }

    @Test
    void deleteProduct() {
        boolean resultTrue1 = ProductManager.getInstance().deleteProduct("phone5");
        boolean resultTrue2 = ProductManager.getInstance().deleteProduct("phone4");
        boolean resultTrue3 = ProductManager.getInstance().deleteProduct("phone3");
        boolean resultFalse1 = ProductManager.getInstance().deleteProduct("falseName");
        assertTrue(resultTrue1);
        assertTrue(resultTrue2);
        assertTrue(resultTrue3);
        assertFalse(resultFalse1);
    }

    @Test
    void findProduct() {
        boolean resultTrue1 = ProductManager.getInstance().findProduct("phone5");
        boolean resultTrue2 = ProductManager.getInstance().findProduct("phone4");
        boolean resultTrue3 = ProductManager.getInstance().findProduct("phone3");
        boolean resultFalse1 = ProductManager.getInstance().findProduct("falseName");
        assertTrue(resultTrue1);
        assertTrue(resultTrue2);
        assertTrue(resultTrue3);
        assertFalse(resultFalse1);
    }

    @Test
    void sortProductList() {
    }
}