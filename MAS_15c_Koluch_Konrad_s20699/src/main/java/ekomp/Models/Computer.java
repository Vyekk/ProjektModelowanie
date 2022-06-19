package ekomp.Models;

import ekomp.Helpers.ObjectPlus;

import java.util.ArrayList;
import java.util.List;

public class Computer extends ObjectPlus {
    private float computerCost;
    private float serviceCost;
    private Integer testScore;
    private Team team;
    private List<Order> orders = new ArrayList<>();
    private List<PartComputer> partComputerList = new ArrayList<>();

    public Computer(float serviceCost) {
        this.serviceCost = serviceCost;
    }

    // Getery i setery


    public float getComputerCost() {
        return computerCost;
    }

    public void setComputerCost(float computerCost) {
        this.computerCost = computerCost;
    }

    public float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getTestScore() throws Exception {
        if (this.testScore == null)
            throw new Exception("Test nie został jeszcze wykonany");
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }

    // Metody biznesowe
    public void testingComputer() {}

    public static void showOfferts() throws ClassNotFoundException {
        Iterable<Computer> extent = ObjectPlus.getExtent(Computer.class);
        for(var offert : extent) {
            System.out.println(offert.toString());
        }
    }

    // Realizacja asocjacji

    public void addOrder(Order order) {
        if(!orders.contains(order)) {
            orders.add(order);
            order.setComputer(this);
        }
    }
    public void removeOrder(Order order) {
        if(orders.contains(order)) {
            orders.remove(order);
        }
    }

    public void setTeam(Team team) {
        if(this.team != team) {
            if (team != null) {
                this.team.removeComputer(this);
            }
            this.team = team;
            this.team.addComputer(this);
        }
    }

    public void removePartComputer(PartComputer partComputer) {
        if(partComputerList.contains(partComputer)) {
            partComputerList.remove(partComputer);
        }
    }

    public void addPartComputer(PartComputer partComputer) {
        if(!partComputerList.contains(partComputer)) {
            partComputerList.add(partComputer);
            partComputer.setComputer(this);
        }
    }
}
