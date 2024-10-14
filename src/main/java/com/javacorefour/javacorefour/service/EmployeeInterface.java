package com.javacorefour.javacorefour.service;

import com.javacorefour.javacorefour.Employee;

import java.util.Collection;

public interface EmployeeInterface {
    Collection<Employee> printEmployee();

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}