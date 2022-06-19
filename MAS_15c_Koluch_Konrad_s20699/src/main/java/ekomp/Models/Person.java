package ekomp.Models;

import ekomp.Helpers.ObjectPlus;
import ekomp.Helpers.PersonType;

import java.time.LocalDate;

public class Person extends ObjectPlus {
    private String firstName;
    private String lastName;
    private Client client;
    private Employee employee;
    private Boss boss;

    public Person(String firstName, String lastName, PersonType personType) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        switch (personType) {
            case BOSS:
                this.boss = Boss.createBoss(this);
                break;
            case CLIENT:
                this.client = Client.createClient(this);
                break;
            case BOSS_CLIENT:
                this.boss = Boss.createBoss(this);
                this.client = Client.createClient(this);
                break;
        }
    }

    public Person(String firstName, String lastName, LocalDate dateOfEmployment, float salary, PersonType personType) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        switch (personType) {
            case VENDOR:
                this.employee = Vendor.createVendor(dateOfEmployment, salary,this);
                break;
            case SERVICETECHNICIAN:
                this.employee = ServiceTechnician.createServiceTechnician(dateOfEmployment,salary, this);
                break;
            case BOSS_VENDOR:
                this.boss = Boss.createBoss(this);
                this.employee = Vendor.createVendor(dateOfEmployment, salary,this);
                break;
            case BOSS_SERVICETECHNICIAN:
                this.boss = Boss.createBoss(this);
                this.employee = ServiceTechnician.createServiceTechnician(dateOfEmployment,salary, this);
                break;
            case VENDOR_CLIENT:
                this.client = Client.createClient(this);
                this.employee = Vendor.createVendor(dateOfEmployment, salary,this);
                break;
            case SERVICETECHNICIAN_CLIENT:
                this.client = Client.createClient(this);
                this.employee = ServiceTechnician.createServiceTechnician(dateOfEmployment,salary, this);
                break;
            case BOSS_VENDOR_CLIENT:
                this.boss = Boss.createBoss(this);
                this.client = Client.createClient(this);
                this.employee = Vendor.createVendor(dateOfEmployment, salary,this);
                break;
            case BOSS_SERVICETECHNICIAN_CLIENT:
                this.boss = Boss.createBoss(this);
                this.client = Client.createClient(this);
                this.employee = ServiceTechnician.createServiceTechnician(dateOfEmployment,salary, this);
                break;
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
