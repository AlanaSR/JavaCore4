package com.javacorefour.javacorefour.service.impl;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.service.api.EmployeeService;
import com.javacorefour.javacorefour.exception.EmployeeAlreadyAddedException;
import com.javacorefour.javacorefour.exception.EmployeeNotFoundException;
import com.javacorefour.javacorefour.exception.EmployeeStorageIsFullException;
import com.javacorefour.javacorefour.exception.InvalidInputException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class EmployeeListServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final static int maxListSize = 10;

    @Override
    public List<Employee> allEmployee() {
        return  employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        checkEmployees(employee.getFirstName(), employee.getLastName());
        if (employees.size() >= maxListSize) {
            throw new EmployeeStorageIsFullException("Мест в организации нет");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        checkEmployees(employee.getFirstName(), employee.getLastName());
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        checkEmployees(firstName, lastName);
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    private void checkEmployees(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new InvalidInputException("400 Bad Request");
        }
    }
}
