package com.javacorefour.javacorefour;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeInterface {
    private final Map<String, Employee> employees;

    public EmployeeService(Map<String, Employee> employees) {
        this.employees = employees;
    }

    private final static int maxMapSize = 10;

    Map<String, Employee> employee = new HashMap(Map.of(
            "Владимир Скрягин",
            new Employee("Владимир", "Скрягин",56153,1),
            "Максим Чистоплюев",
            new Employee("Максим", "Чистоплюев",84665,1),
            "Алина Незнайкина",
            new Employee("Алина", "Незнайкина",65432,2),
            "Светлана Счастливина",
            new Employee("Светлана", "Счастливина",84614,2),
            "Никандра Капризулина",
            new Employee("Никандра", "Капризулькина",56448,3),
            "Павел Вреднюкин",
            new Employee("Павел", "Вреднюкин",35464,5),
            "Артем Хулиганкин",
            new Employee("Артем", "Хулиганкин",95145,4),
            "Софья Засыпалкина",
            new Employee("Софья", "Засыпалкина",95156,4),
            "Андрей Приставалкин",
            new Employee("Андрей", "Приставалкин",86785,5)
    ));

    @Override
    public List<Employee> printEmployee() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= maxMapSize) {
            throw new EmployeeStorageIsFullException("Мест в организации нет");
        } else if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
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
}
