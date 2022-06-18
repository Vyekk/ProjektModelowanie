package ekomp.Models;

import java.util.ArrayList;
import java.util.List;

public class Client extends ObjectPlus{
    private int phoneNumber;
    private Adress adress;
    private List<Order> orders = new ArrayList<>();

    public void createOrder() {}

    // Realizacja asocjacji
    public void addOrder(Order order) {
        if(!orders.contains(order)) {
            orders.add(order);
            order.setClient(this);
        }
    }
    public void removeOrder(Order order) {
        if(orders.contains(order)) {
            orders.remove(order);
        }
    }
}
