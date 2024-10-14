package com.javacorefour.javacorefour.controller;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.service.EmployeeInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeInterface employeeService;

    public EmployeeController(@Qualifier("employeeService") EmployeeInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/print")
    public Map<String, Employee> print() {
        return (Map<String, Employee>) employeeService.printEmployee();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.addEmployee(firstName, lastName);
        return employee + " добавлен.";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.removeEmployee(firstName, lastName);
        return employee + " удален.";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.findEmployee(firstName, lastName);
        return employee + " найден.";
    }
}
