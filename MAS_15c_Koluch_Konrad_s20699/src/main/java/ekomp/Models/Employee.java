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

    // Metody biznesowe
    public static void showEmployees() throws ClassNotFoundException {
        Iterable<Employee> extent = ObjectPlus.getExtent(Employee.class);
        for(var employee : extent) {
            System.out.println(employee.toString());
        }
    }


}
