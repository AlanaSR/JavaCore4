package com.javacorefour.javacorefour;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService implements EmployeeInterface {
    private final static int listSize = 10;

    List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Владимир", "Скрягин"),
            new Employee("Алиса", "Засранкина"),
            new Employee("Максим", "Чистоплюев"),
            new Employee("Алина", "Незнайкина"),
            new Employee("Светлана", "Страдалкина"),
            new Employee("Никандра", "Капризулькина"),
            new Employee("Павел", "Вреднюкин"),
            new Employee("Артем", "Хулиганкин"),
            new Employee("Софья", "Засыпалкина"),
            new Employee("Андрей", "Приставалкин")
    ));
    Integer sizeEmployeeList = employees.size();

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void foundEmployee(Employee employee) {
        employees.toString();
    }
}
