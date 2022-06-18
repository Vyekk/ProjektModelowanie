package ekomp.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendor extends Employee {
    private int nrOfSoldComputers;
    private List<Order> orders = new ArrayList<>();

    public Vendor(LocalDate dateOfEmployment, float salary) {
        super(dateOfEmployment, salary);
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
