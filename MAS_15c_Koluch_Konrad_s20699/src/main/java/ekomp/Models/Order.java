package ekomp.Models;

import ekomp.Helpers.ObjectPlus;
import ekomp.Helpers.Status;
import javafx.scene.control.ListView;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


public class Order extends ObjectPlus {
    private int number;
    private Status status;
    private LocalDate dateOfOrder;
    private LocalDate dateOfEnd;
    private Float shippingCost;
    private float fullCost;
    private Client client;
    private Computer computer;
    private Vendor vendor;

    public Order(int number, Status status, LocalDate dateOfOrder, Float shippingCost, float fullCost, Client client, Computer computer) {
        setComputer(computer);
        setClient(client);
        this.number = number;
        this.status = status;
        this.dateOfOrder = dateOfOrder;
        this.shippingCost = shippingCost;
        this.fullCost = fullCost;
    }
    public Order(int number, Status status, LocalDate dateOfOrder, float fullCost, Client client, Computer computer) {
        setComputer(computer);
        setClient(client);
        this.number = number;
        this.status = status;
        this.dateOfOrder = dateOfOrder;
        this.fullCost = fullCost;
    }

    @Override
    public String toString() {
        try {
            return this.number + " | " + this.status + " | " + this.shippingCost +" | "+ this.fullCost +" | "+ this.computer.getTestScore();
        } catch (Exception e) {
            return "Wystąpił błąd przy ładowaniu zamówienia";
        }
    }

    // Getery i Setery

    public long getLeadTime() throws Exception {
        if (this.dateOfEnd == null)
            throw new Exception("Zamówienie jeszcze się nie skończyło!");
        return DAYS.between(dateOfOrder,dateOfEnd);
    }

    public Computer getComputer() {
        return computer;
    }

    public Vendor getVendor() throws Exception {
        if(vendor == null)
            throw new Exception("Zamówienie nie zostało złożone przez sprzedawce");
        return vendor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public LocalDate getDateOfEnd() throws Exception {
        if(this.dateOfEnd == null)
            throw new Exception("Zamówienie jeszcze się nie skończyło!");
        return dateOfEnd;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public Float getShippingCost() throws Exception {
        if(this.shippingCost == null)
            throw new Exception("Zamówienie ma darmową przesyłkę!");
        return shippingCost;
    }

    public void setShippingCost(Float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public float getFullCost() {
        return fullCost;
    }

    public void setFullCost(float fullCost) {
        this.fullCost = fullCost;
    }

    public Client getClient() {
        return client;
    }

    // Realizacja asocjacji

    public void setClient(Client client) {
        if(this.client != client) {
            if (this.client != null) {
                this.client.removeOrder(this);
            }
            this.client = client;
            this.client.addOrder(this);
        }
    }

    public void setComputer(Computer computer) {
        if(this.computer != computer) {
            if (this.computer != null) {
                this.computer.removeOrder(this);
            }
            this.computer = computer;
            this.computer.addOrder(this);
        }
    }

    public void setVendor(Vendor vendor) {
        if(this.vendor != vendor) {
            if (this.vendor != null) {
                this.vendor.removeOrder(this);
            }
            this.vendor = vendor;
            this.vendor.addOrder(this);
        }
    }

    // Metody biznesowe
    public static void showOrders(ListView listView) throws ClassNotFoundException {
        Iterable<Order> extent = ObjectPlus.getExtent(Order.class);
        for(var order : extent) {
            listView.getItems().add(order);
        }
    }

}
