package codegym.impl;

public interface ProductStatic {
    final int NEW =1;
    final int OLD_99 =2;
    final int OLD_95 = 3;
    final int UNLOAD = 4;
    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    int getPrice();

    void setPrice(int price);

    int getStatus();

    void setStatus(int status);

    String getDescription();

    void setDescription(String description);
}
