package com.javacorefour.javacorefour;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Service
public class EmployeeSalaryDepServiceImpl implements EmployeeSalaryDep {

    private final EmployeeService employeeService;

    public EmployeeSalaryDepServiceImpl(@Qualifier("employeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryDepartment(Integer departmentId) {
        return employeeService.printEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getsalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден."));
    }

    @Override
    public Employee minSalaryDepartment(Integer departmentId) {
        return employeeService.printEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getsalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден."));
    }

    @Override
    public List<Employee> allEmployeesInDepartment(Integer departmentId) {
        return employeeService.printEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allDepartmentsWithEmployees() {
        return employeeService.printEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
