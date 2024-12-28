package com.javacorefour.javacorefour.controller;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.service.api.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/print")
    public List<Employee> print() {
        return (List<Employee>) employeeService.allEmployee();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee + " добавлен.";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.findEmployee(firstName, lastName);
        return employee + " найден.";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestBody Employee employee) {
        employeeService.removeEmployee(employee);
        return employee + " удален.";
    }
}
