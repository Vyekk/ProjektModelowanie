package ekomp.Models;

import ekomp.Helpers.ObjectPlus;

import java.util.ArrayList;
import java.util.List;

public class Allocation extends ObjectPlus {
    private List<String> roles = new ArrayList<>();
    private ServiceTechnician serviceTechnician;
    private Team team;

    public Allocation(ServiceTechnician serviceTechnician, Team team) {
        setServiceTechnician(serviceTechnician);
        setTeam(team);
    }

    // Getery i setery

    public List<String> getRoles() throws Exception {
        if(roles == null)
            throw new Exception("Serwisant ten nie pełni konkretnej roli");
        return roles;
    }

    public void addRole(String role) {
        this.roles.add(role);
    }

    public ServiceTechnician getServiceTechnician() {
        return serviceTechnician;
    }


    public Team getTeam() {
        return team;
    }

    // Realizacja asocjacji

    public void setServiceTechnician(ServiceTechnician serviceTechnician) {
        if(this.serviceTechnician != serviceTechnician) {
            if (this.serviceTechnician != null) {
                this.serviceTechnician.removeAllocation(this);
            }
            this.serviceTechnician = serviceTechnician;
            this.serviceTechnician.addAllocation(this);
        }
    }

    public void setTeam(Team team) {
        if(this.team != team) {
            if (this.team != null) {
                this.team.removeAllocation(this);
            }
            this.team = team;
            this.team.addAllocation(this);
        }
    }
}
