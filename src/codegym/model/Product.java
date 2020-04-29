package codegym.model;

import codegym.impl.ProductStatic;

public abstract class Product implements ProductStatic {
    private String id;
    private String name;
    private int price;
    private int status;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id =id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    protected Product(){}

    protected Product(String id, String name, int price,int status,String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status=status;
        this.description=description;
    }
}
