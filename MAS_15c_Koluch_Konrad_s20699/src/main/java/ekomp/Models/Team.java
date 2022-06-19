package ekomp.Models;

import ekomp.Helpers.ObjectPlus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Team extends ObjectPlus {
    private LocalDate dateOfTeamCreated;
    private LocalDate dateOfTeamEnded;
    private List<Computer> computers = new ArrayList<>();
    private List<Allocation> allocations = new ArrayList<>();

    public Team(LocalDate dateOfTeamCreated) {
        this.dateOfTeamCreated = dateOfTeamCreated;
    }

    // Getery i Setery

    public LocalDate getDateOfTeamCreated() {
        return dateOfTeamCreated;
    }

    public void setDateOfTeamCreated(LocalDate dateOfTeamCreated) {
        this.dateOfTeamCreated = dateOfTeamCreated;
    }

    public LocalDate getDateOfTeamEnded() throws Exception {
        if(this.dateOfTeamEnded == null)
            throw new Exception("Zespół jeszcze się nie zakończył");
        return dateOfTeamEnded;
    }

    public void setDateOfTeamEnded(LocalDate dateOfTeamEnded) {
        this.dateOfTeamEnded = dateOfTeamEnded;
    }

    // Realizacja asocjacji

    public void addComputer(Computer computer) {
        if(!computers.contains(computer)) {
            computers.add(computer);
            computer.setTeam(this);
        }
    }

    public void removeComputer(Computer computer) {
        if(computers.contains(computer)) {
            computers.remove(computer);
        }
    }

    public void removeAllocation(Allocation allocation) {
        if(allocations.contains(allocation)) {
            allocations.remove(allocation);
        }
    }

    public void addAllocation(Allocation allocation) {
        if(!allocations.contains(allocation)) {
            allocations.add(allocation);
            allocation.setTeam(this);
        }
    }
}
