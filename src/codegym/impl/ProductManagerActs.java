package codegym.impl;

public interface ProductManagerActs {
    void showProductList();
    void addProduct(String id,String name,int price,int status,String description);
    boolean editProductStatic();
    boolean deleteProduct(String name);
    boolean findProduct(String name);
    void sortProductList(boolean keyword);
}
