package ekomp.Models;

import java.util.ArrayList;
import java.util.List;

public class Boss extends ObjectPlus{
    private int id;
    private List<Shop> shops = new ArrayList<>();

    public Boss(int id) {
        this.id = id;
    }

    // Getery i seter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addShop(Shop shop) {
        if (!shops.contains(shop)) {
            shops.add(shop);
            shop.addBossQualif(this);
        }
    }
}
