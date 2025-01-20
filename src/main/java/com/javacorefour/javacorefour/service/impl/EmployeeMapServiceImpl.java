package com.javacorefour.javacorefour.service.impl;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.exception.InvalidInputException;
import com.javacorefour.javacorefour.service.api.EmployeeService;
import com.javacorefour.javacorefour.exception.EmployeeAlreadyAddedException;
import com.javacorefour.javacorefour.exception.EmployeeNotFoundException;
import com.javacorefour.javacorefour.exception.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeMapServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private final static int maxMapSize = 10;

    @Override
    public List<Employee> allEmployee() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.size() >= maxMapSize) {
            throw new EmployeeStorageIsFullException("Мест в организации нет");
        } else if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        checkEmployees(employee.getFirstName(), employee.getLastName());
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    private void checkEmployees(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new InvalidInputException("400 Bad Request");
        }
    }
}
