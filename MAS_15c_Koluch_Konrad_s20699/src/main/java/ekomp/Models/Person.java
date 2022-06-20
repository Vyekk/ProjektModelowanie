package ekomp.Models;

import ekomp.Helpers.ObjectPlus;
import ekomp.Helpers.PersonType;

import java.time.LocalDate;
import java.util.EnumSet;

public class Person extends ObjectPlus {
    private String firstName;
    private String lastName;
    private Client client;
    private Employee employee;
    private Boss boss;

    public Person(String firstName, String lastName, EnumSet<PersonType> types) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        if(types.contains(PersonType.BOSS)) {
            this.boss = Boss.createBoss(this);
        }
        if(types.contains(PersonType.CLIENT)) {
            this.client = Client.createClient(this);
        }
    }

    public Person(String firstName, String lastName, LocalDate dateOfEmployment, float salary, EnumSet<PersonType> types) throws Exception {
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

    // Getery i setery


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
