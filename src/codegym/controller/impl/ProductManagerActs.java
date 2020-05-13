package codegym.controller.impl;

public interface ProductManagerActs {
    boolean showProductList();
    boolean addProduct(String id,String name,int price,int status,String description);
    boolean editProductStatic(String id);
    boolean deleteProduct(String name);
    boolean findProduct(String name);
    void sortProductList(boolean keyword);
}
