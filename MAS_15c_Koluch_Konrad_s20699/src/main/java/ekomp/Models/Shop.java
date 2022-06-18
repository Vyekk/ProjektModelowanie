package ekomp.Models;

public class Shop extends ObjectPlusPlus {
    private String shopName;
    private Adress adress;

    public Shop(String shopName, Adress adress) {
        this.shopName = shopName;
        this.adress = adress;
    }
}
