package ekomp.Models;

public class Computer extends ObjectPlusPlus{
    private float computerCost;
    private float serviceCost;
    private Integer testScore;

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
}
