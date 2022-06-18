package ekomp.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Shop extends ObjectPlus {
    private String shopName;
    private Adress adress;
    private List<Employee> employees = new ArrayList<>();
    private Map<Integer,Boss> bossQualif = new TreeMap<>();

    public Shop(String shopName, Adress adress) {
        this.shopName = shopName;
        this.adress = adress;
    }

    public Boss findBossQualif(int id) throws Exception {
        if (!bossQualif.containsKey(id))
            throw new Exception("Nie znaleziono Szefa o takim id");
        return bossQualif.get(id);
    }

    // Realizacja asocjacji

    public void addEmployee(Employee employee) {
        if(!employees.contains(employee)) {
            employees.add(employee);
            employee.setShop(this);
        }
    }
    public void removeEmployee(Employee employee) {
        if(employees.contains(employee)) {
            employees.remove(employee);
        }
    }
    public void addBossQualif(Boss boss) {
        if (!bossQualif.containsKey(boss.getId())) {
            bossQualif.put(boss.getId(), boss);
            boss.addShop(this);
        }
    }
}
