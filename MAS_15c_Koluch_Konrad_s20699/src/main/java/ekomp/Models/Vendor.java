package ekomp.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendor extends Employee {
    private int nrOfSoldComputers;
    private List<Order> orders = new ArrayList<>();

    private Vendor(LocalDate dateOfEmployment, float salary, Person person) {
        super(dateOfEmployment, salary, person);
    }

    public static Vendor createVendor(LocalDate dateOfEmployment, float salary,Person person) throws Exception {
        if (person == null)
            throw new Exception("Podana osoba nie istnieje!");
        Vendor vendor = new Vendor(dateOfEmployment, salary, person);
        return vendor;
    }

    @Override
    public String toString() {
        return super.toString() + "sprzedawca\nSprzedal: " + this.nrOfSoldComputers + " komputerow";
    }

    // Getery i setery


    public int getNrOfSoldComputers() {
        return nrOfSoldComputers;
    }

    public void setNrOfSoldComputers(int nrOfSoldComputers) {
        this.nrOfSoldComputers = nrOfSoldComputers;
    }

    public void addOrder(Order order) {
        if(!orders.contains(order)) {
            orders.add(order);
            order.setVendor(this);
        }
    }

    public void removeOrder(Order order) {
        if(orders.contains(order)) {
            orders.remove(order);
        }
    }
}
