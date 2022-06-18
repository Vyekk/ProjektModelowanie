package ekomp.Models;

import java.time.LocalDate;

public class ServiceTechnician extends Employee{
    private int nrOfCreatedComputers;

    public ServiceTechnician(LocalDate dateOfEmployment, float salary) {
        super(dateOfEmployment, salary);
    }

    // Getery i Setery


    public int getNrOfCreatedComputers() {
        return nrOfCreatedComputers;
    }

    public void setNrOfCreatedComputers(int nrOfCreatedComputers) {
        this.nrOfCreatedComputers = nrOfCreatedComputers;
    }
}
