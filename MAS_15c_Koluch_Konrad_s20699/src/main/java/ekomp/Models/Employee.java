package ekomp.Models;

import java.time.LocalDate;

public abstract class Employee extends ObjectPlus {
    private LocalDate dateOfEmployment;
    private float salary;
    public static float minSalary=2800;

    public Employee(LocalDate dateOfEmployment, float salary) {
        this.dateOfEmployment = dateOfEmployment;
        this.salary = salary;
    }

    public static void setMinSalary(float newMinSalary) {
        minSalary = newMinSalary;
    }

    @Override
    public String toString() {
        return "==Pracownik==\nzatrudniony: " +dateOfEmployment+"\nzarabiajacy: " + salary+ "\nz kategorii: ";
    }

    // Metody biznesowe
    public static void showEmployees() throws ClassNotFoundException {
        Iterable<Vendor> extentOfVendors = ObjectPlus.getExtent(Vendor.class);
        Iterable<ServiceTechnician> extentOfService = ObjectPlus.getExtent(ServiceTechnician.class);
        for(var employee : extentOfVendors) {
            System.out.println(employee.toString());
        }
        for(var employee : extentOfService) {
            System.out.println(employee.toString());
        }
    }


}
