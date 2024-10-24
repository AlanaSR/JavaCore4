package com.javacorefour.javacorefour.service;

import com.javacorefour.javacorefour.Employee;
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

    private final EmployeeInterface employeeInterface;

    public DepartmentServiceImpl(@Qualifier("employeeListService") EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    @Override
    public Employee maxSalaryDepartment(Integer departmentId) {
        return employeeInterface.AllEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден."));
    }

    @Override
    public Employee minSalaryDepartment(Integer departmentId) {
        return employeeInterface.AllEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден."));
    }

    @Override
    public List<Employee> allEmployeesInDepartment(Integer departmentId) {
        return employeeInterface.AllEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> allDepartmentsWithEmployees() {
        return employeeInterface.AllEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
