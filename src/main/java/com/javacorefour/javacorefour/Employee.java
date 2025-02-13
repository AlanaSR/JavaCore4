package com.javacorefour.javacorefour;

import com.javacorefour.javacorefour.exception.InvalidInputException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private final String firstName;
    private final String lastName;
    private double salary;
    private int department;

    public Employee(String firstName, String lastName, double salary, int department) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }

    @Override
    public String toString() {
        return "Сотрудник: имя - " + firstName +
                ", фамилия - " + lastName +
                ", зарплата = " + salary +
                ", отдел - " + department;
    }
}
