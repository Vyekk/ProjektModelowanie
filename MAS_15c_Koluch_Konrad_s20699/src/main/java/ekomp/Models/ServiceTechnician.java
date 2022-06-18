package ekomp.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceTechnician extends Employee{
    private int nrOfCreatedComputers;
    private List<Allocation> allocations = new ArrayList<>();

    public ServiceTechnician(LocalDate dateOfEmployment, float salary) {
        super(dateOfEmployment, salary);
    }

    @Override
    public String toString() {
        return super.toString() + "serwisant\nZlozyl: " + this.nrOfCreatedComputers + " komputerow";
    }

    // Getery i Setery


    public int getNrOfCreatedComputers() {
        return nrOfCreatedComputers;
    }

    public void setNrOfCreatedComputers(int nrOfCreatedComputers) {
        this.nrOfCreatedComputers = nrOfCreatedComputers;
    }

    public void removeAllocation(Allocation allocation) {
        if(allocations.contains(allocation)) {
            allocations.remove(allocation);
        }
    }

    public void addAllocation(Allocation allocation) {
        if(!allocations.contains(allocation)) {
            allocations.add(allocation);
            allocation.setServiceTechnician(this);
        }
    }
}
