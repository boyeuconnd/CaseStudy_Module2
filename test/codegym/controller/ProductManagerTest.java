package codegym.controller;

import codegym.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @BeforeEach
    void setupArrayList(){
        ProductManager productManager = ProductManager.getInstance();
        productManager.addProduct("001","phone 1",10,1,"none");
        productManager.addProduct("002","phone 2",200,1,"none");
        productManager.addProduct("003","phone 3",150,2,"none");
        productManager.addProduct("004","phone 4",100,3,"none");
        productManager.addProduct("005","phone 5",370,4,"none");
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
        boolean resultTrue1 = ProductManager.getInstance().deleteProduct("phone 5");
        boolean resultTrue2 = ProductManager.getInstance().deleteProduct("phone 4");
        boolean resultTrue3 = ProductManager.getInstance().deleteProduct("phone 3");
        boolean resultFalse1 = ProductManager.getInstance().deleteProduct("falseName");
        assertTrue(resultTrue1);
        assertTrue(resultTrue2);
        assertTrue(resultTrue3);
        assertFalse(resultFalse1);
    }

    @Test
    void findProduct() {
        boolean resultTrue1 = ProductManager.getInstance().findProduct("phone 5");
        boolean resultTrue2 = ProductManager.getInstance().findProduct("phone 4");
        boolean resultTrue3 = ProductManager.getInstance().findProduct("phone 3");
        boolean resultFalse1 = ProductManager.getInstance().findProduct("falseName");
        assertTrue(resultTrue1);
        assertTrue(resultTrue2);
        assertTrue(resultTrue3);
        assertFalse(resultFalse1);
    }

    @Test
    void sortProductList() {
        System.out.println("Increasingly sort");
        ProductManager.getInstance().sortProductList(true);
        System.out.println("Decreasingly sort");
        ProductManager.getInstance().sortProductList(false);


    }

    @Test
    void filterByPrice() {
        boolean resultFalse1 = ProductManager.getInstance().filterByPrice(90,80);
        boolean resultFalse2 = ProductManager.getInstance().filterByPrice(-1,80);
        boolean resultFalse3 = ProductManager.getInstance().filterByPrice(400,480);
        boolean resultTrue = ProductManager.getInstance().filterByPrice(100,210);
        assertFalse(resultFalse1);
        assertFalse(resultFalse2);
        assertFalse(resultFalse3);
        assertTrue(resultTrue);
    }

    @Test
    void regexSearchProduct() {
        boolean resultTrue1 = ProductManager.getInstance().regexSearchProduct("Ph");
        boolean resultTrue2 = ProductManager.getInstance().regexSearchProduct("Ph");
        boolean resultTrue3 = ProductManager.getInstance().regexSearchProduct("pHone");
        boolean resultTrue4 = ProductManager.getInstance().regexSearchProduct("Phone    4");
        boolean resultFalse1 = ProductManager.getInstance().regexSearchProduct("test   ");
        boolean resultFalse2 = ProductManager.getInstance().regexSearchProduct("pHoNe 9   ");
        assertTrue(resultTrue1);
        assertTrue(resultTrue2);
        assertTrue(resultTrue3);
        assertTrue(resultTrue4);
        assertFalse(resultFalse1);
        assertFalse(resultFalse2);
    }
}