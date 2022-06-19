package ekomp.Models;

import ekomp.Helpers.ObjectPlus;

import java.util.ArrayList;
import java.util.List;

public class Boss extends ObjectPlus {
    private int id;
    private Person person;
    private List<Shop> shops = new ArrayList<>();

    private Boss(Person person) {
        this.person = person;
    }

    public static Boss createBoss(Person person) throws Exception {
        if (person == null)
            throw new Exception("Podana osoba nie istnieje!");
        Boss boss = new Boss(person);
        return boss;
    }

    // Getery i setery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // Realizacja asocjacji

    public void addShop(Shop shop) {
        if (!shops.contains(shop)) {
            shops.add(shop);
            shop.addBossQualif(this);
        }
    }
}
