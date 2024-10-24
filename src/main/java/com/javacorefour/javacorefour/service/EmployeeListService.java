package com.javacorefour.javacorefour.service;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.exception.EmployeeAlreadyAddedException;
import com.javacorefour.javacorefour.exception.EmployeeNotFoundException;
import com.javacorefour.javacorefour.exception.EmployeeStorageIsFullException;
import com.javacorefour.javacorefour.exception.InvalidInputException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class EmployeeListService implements EmployeeInterface {
    private final List<Employee> employees;

    public EmployeeListService(List<Employee> employees) {
        this.employees = employees;
    }

    private final static int maxListSize = 10;

    List<Employee> employee = List.of(
            new Employee("Владимир", "Скрягин", 56153, 1),
            new Employee("Максим", "Чистоплюев", 84665, 1),
            new Employee("Алина", "Незнайкина", 65432, 2),
            new Employee("Светлана", "Счастливина", 84614, 2),
            new Employee("Никандра", "Капризулькина", 56448, 3),
            new Employee("Павел", "Вреднюкин", 35464, 5),
            new Employee("Артем", "Хулиганкин", 95145, 4),
            new Employee("Софья", "Засыпалкина", 95156, 4),
            new Employee("Андрей", "Приставалкин", 86785, 5)
    );

    @Override
    public List<Employee> AllEmployee() {
        return employee;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        checkEmployees(firstName, lastName);
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= maxListSize) {
            throw new EmployeeStorageIsFullException("Мест в организации нет");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
       checkEmployees(firstName, lastName);
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
     checkEmployees(firstName,lastName);
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
