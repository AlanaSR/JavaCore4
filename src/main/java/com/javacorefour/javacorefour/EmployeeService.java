package com.javacorefour.javacorefour;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService implements EmployeeInterface {
    private final static int maxListSize = 10;

    List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Владимир", "Скрягин"),
            new Employee("Максим", "Чистоплюев"),
            new Employee("Алина", "Незнайкина"),
            new Employee("Светлана", "Страдалкина"),
            new Employee("Никандра", "Капризулькина"),
            new Employee("Павел", "Вреднюкин"),
            new Employee("Артем", "Хулиганкин"),
            new Employee("Софья", "Засыпалкина"),
            new Employee("Андрей", "Приставалкин")
    ));

    @Override
    public void addEmployee(Employee employee) {
        if (employees.size() >= maxListSize) {
            throw new EmployeeStorageIsFullException("Мест в организации нет");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(employee);
    }


    @Override
    public void findEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.toString();
    }
}
