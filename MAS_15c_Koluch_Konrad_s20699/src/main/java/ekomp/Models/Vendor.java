package ekomp.Models;

import java.time.LocalDate;

public class Vendor extends Employee {
    private int nrOfSoldComputers;

    public Vendor(LocalDate dateOfEmployment, float salary) {
        super(dateOfEmployment, salary);
    }
}
