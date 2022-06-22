package ekomp.Models;

import ekomp.Helpers.ObjectPlus;

import java.util.ArrayList;
import java.util.List;

public class Client extends ObjectPlus {
    private int phoneNumber;
    private Adress adress;
    private Person person;
    private List<Order> orders = new ArrayList<>();

    private Client(Person person) {
        this.person = person;
    }

    public static Client createClient(Person person) throws Exception {
        if (person == null)
            throw new Exception("Podana osoba nie istnieje!");
        Client client = new Client(person);
        return client;
    }

    public void createOrder() {}

    // Getery i setery


    public List<Order> getOrders() {
        return orders;
    }

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
