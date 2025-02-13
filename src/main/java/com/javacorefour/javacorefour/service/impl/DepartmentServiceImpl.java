package com.javacorefour.javacorefour.service.impl;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.service.api.DepartmentService;
import com.javacorefour.javacorefour.service.api.EmployeeService;
import com.javacorefour.javacorefour.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(@Qualifier("employeeListService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Map<Integer, List<Employee>> allDepartmentsWithEmployees() {
        return employeeService.allEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public List<Employee> allEmployeesInDepartment(Integer id) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == id)
                .toList();
    }

    @Override
    public Double maxSalaryDepartment(Integer id) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == id)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден.")).getSalary();
    }

    @Override
    public Double minSalaryDepartment(Integer id) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == id)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден.")).getSalary();
    }

    @Override
    public Double sumSalaryInDepartment(Integer id) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == id)
                .mapToDouble(it->it.getSalary()).sum();
    }
}
