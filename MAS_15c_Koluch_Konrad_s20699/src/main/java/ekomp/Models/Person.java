package ekomp.Models;

import ekomp.Helpers.ObjectPlus;
import ekomp.Helpers.PersonType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Person extends ObjectPlus {
    private String firstName;
    private String lastName;
    private Client client;
    private Employee employee;
    private Boss boss;

    public Person(String firstName, String lastName, ArrayList<PersonType> types) throws Exception {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        if(types.contains(PersonType.BOSS)) {
            this.boss = Boss.createBoss(this);
        }
        if(types.contains(PersonType.CLIENT)) {
            this.client = Client.createClient(this);
        }
    }

    public Person(String firstName, String lastName, LocalDate dateOfEmployment, float salary, ArrayList<PersonType> types) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        if(types.contains(PersonType.BOSS)) {
            this.boss = Boss.createBoss(this);
        }
        if(types.contains(PersonType.CLIENT)) {
            this.client = Client.createClient(this);
        }
        if(types.contains(PersonType.VENDOR)) {
            this.employee = Vendor.createVendor(dateOfEmployment, salary,this);
        }
        if(types.contains(PersonType.SERVICETECHNICIAN)) {
            this.employee = ServiceTechnician.createServiceTechnician(dateOfEmployment,salary, this);
        }
    }

    public void createAccount() {}

    public void login() {}

    public void checkPassword() {}

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    // Getery i setery


    public Client getClient() {
        return client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Boss getBoss() {
        return boss;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
