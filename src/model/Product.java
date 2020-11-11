package model;

public class Product {
    int pId;
    String pName;
    Float price;
    int quantity;
    String color;
    String description;
    String category;


    public Product() {
    }

    public Product(int pId, String pName, Float price, int quantity, String color, String description) {
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
    }

    public Product(int pId, String pName, Float price, int quantity, String color, String description, String category) {
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public Product(String pName, Float price, int quantity, String color, String description, String category) {
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
