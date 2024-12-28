package com.javacorefour.javacorefour.service.api;

import com.javacorefour.javacorefour.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> allEmployee();

    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(String firstName, String lastName);


}
