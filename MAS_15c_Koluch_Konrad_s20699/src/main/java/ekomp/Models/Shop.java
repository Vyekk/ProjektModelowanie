package ekomp.Models;

import java.util.ArrayList;
import java.util.List;

public class Shop extends ObjectPlus {
    private String shopName;
    private Adress adress;
    private List<Employee> employees = new ArrayList<>();

    public Shop(String shopName, Adress adress) {
        this.shopName = shopName;
        this.adress = adress;
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
}
