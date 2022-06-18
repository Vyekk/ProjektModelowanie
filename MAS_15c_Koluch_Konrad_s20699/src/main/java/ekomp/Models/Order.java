package ekomp.Models;

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

    public Order(int number, Status status, LocalDate dateOfOrder, Float shippingCost, float fullCost) {
        this.number = number;
        this.status = status;
        this.dateOfOrder = dateOfOrder;
        this.shippingCost = shippingCost;
        this.fullCost = fullCost;
    }
    public Order(int number, Status status, LocalDate dateOfOrder, float fullCost) {
        this.number = number;
        this.status = status;
        this.dateOfOrder = dateOfOrder;
        this.fullCost = fullCost;
    }


    // Getery i Setery

    public long getLeadTime() throws Exception {
        if (this.dateOfEnd == null)
            throw new Exception("Zamówienie jeszcze się nie skończyło!");
        return DAYS.between(dateOfOrder,dateOfEnd);
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

    public void setClient(Client client) {
        if(this.client != client) {
            if (client != null) {
                this.client.removeOrder(this);
            }
            this.client = client;
            this.client.addOrder(this);
        }
    }

    public Client getClient() {
        return client;
    }

    // Metody biznesowe
    public static void showOrders() throws ClassNotFoundException {
        Iterable<Order> extent = ObjectPlus.getExtent(Order.class);
        for(var order : extent) {
            System.out.println(order.toString());
        }
    }

}
