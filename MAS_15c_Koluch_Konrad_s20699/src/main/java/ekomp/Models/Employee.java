package ekomp.Models;

import java.time.LocalDate;

public abstract class Employee {
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
    public void showEmployees() {}


}
