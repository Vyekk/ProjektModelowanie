package ekomp.Models;

import java.time.LocalDate;

public abstract class Employee extends ObjectPlus {
    private LocalDate dateOfEmployment;
    private float salary;
    private Shop shop;
    private Person person;
    public static float minSalary=2800;

    public Employee(LocalDate dateOfEmployment, float salary, Person person) {
        this.dateOfEmployment = dateOfEmployment;
        this.salary = salary;
        this.person = person;
    }

    public static void setMinSalary(float newMinSalary) {
        minSalary = newMinSalary;
    }

    @Override
    public String toString() {
        return "==Pracownik==\nzatrudniony: " +dateOfEmployment+"\nzarabiajacy: " + salary+ "\nz kategorii: ";
    }

    // Metody biznesowe
    public static void showEmployees() {

        try {
            Iterable<Vendor> extentOfVendors = ObjectPlus.getExtent(Vendor.class);
            for(var employee : extentOfVendors) {
                System.out.println(employee.toString());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Nie znaleziono sprzedawców");
        }

        try {
            Iterable<ServiceTechnician> extentOfService = ObjectPlus.getExtent(ServiceTechnician.class);
            for(var employee : extentOfService) {
                System.out.println(employee.toString());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Nie znaleziono serwisantów");
        }

    }


    public void setShop(Shop shop) {
        if(this.shop != shop) {
            if(this.shop != null) {
                this.shop.removeEmployee(this);
            }
            this.shop = shop;
            this.shop.addEmployee(this);
        }
    }
}
