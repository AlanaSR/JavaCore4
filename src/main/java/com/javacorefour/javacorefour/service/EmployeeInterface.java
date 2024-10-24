package com.javacorefour.javacorefour.service;

import com.javacorefour.javacorefour.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeInterface {

    List<Employee> AllEmployee();

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Employee changeFirstCharacterUp(String firstName, String lastName);

}
