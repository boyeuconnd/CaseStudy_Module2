package codegym.model.impl;

public interface ProductStatic {
     int NEW =1;
     int OLD_99 =2;
     int OLD_95 = 3;
     int UNLOAD = 4;
     boolean INCREASING =true;
     boolean DECREASING = false;
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
