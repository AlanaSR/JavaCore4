package com.javacorefour.javacorefour.controller;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.service.EmployeeSalaryDepServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeSalaryDepController {

    private final EmployeeSalaryDepServiceImpl employeeSalaryDepService;

    public EmployeeSalaryDepController(EmployeeSalaryDepServiceImpl employeeSalaryDepService) {
        this.employeeSalaryDepService = employeeSalaryDepService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryDepartment(@RequestParam ("departmentId") Integer departmentId) {
        return employeeSalaryDepService.maxSalaryDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryDepartment(@RequestParam ("departmentId") Integer departmentId) {
        return employeeSalaryDepService.minSalaryDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> allEmployeesInDepartment(@RequestParam ("departmentId") Integer departmentId) {
        return employeeSalaryDepService.allEmployeesInDepartment(departmentId);
    }

    @GetMapping
    public Map<Integer, List<Employee>> allDepartmentsWithEmployees() {
        return employeeSalaryDepService.allDepartmentsWithEmployees();
    }
}
