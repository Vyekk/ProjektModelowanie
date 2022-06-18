package ekomp.Models;

public class Part extends ObjectPlus {
    private String name;
    private float price;
    private String category;

    public Part(String name, float price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Geterry i setery


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
