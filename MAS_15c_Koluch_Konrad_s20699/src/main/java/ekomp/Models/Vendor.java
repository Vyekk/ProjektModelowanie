package ekomp.Models;

import java.time.LocalDate;

public class Vendor extends Employee {
    private int nrOfSoldComputers;

    public Vendor(LocalDate dateOfEmployment, float salary) {
        super(dateOfEmployment, salary);
    }

    @Override
    public String toString() {
        return super.toString() + "sprzedawca\nSprzedał: " + this.nrOfSoldComputers + " komputerów";
    }

    // Getery i setery


    public int getNrOfSoldComputers() {
        return nrOfSoldComputers;
    }

    public void setNrOfSoldComputers(int nrOfSoldComputers) {
        this.nrOfSoldComputers = nrOfSoldComputers;
    }
}
