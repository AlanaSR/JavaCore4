package com.javacorefour.javacorefour.controller;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.service.EmployeeInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeInterface employeeInterface;

    public EmployeeController(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    @GetMapping(path = "/print")
    public List<Employee> print() {
        return (List<Employee>) employeeInterface.AllEmployee();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeInterface.addEmployee(firstName, lastName);
//        employeeInterface.changeFirstCharacterUp(firstName,lastName);
        return employeeInterface.changeFirstCharacterUp(firstName, lastName) + " добавлен.";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeInterface.removeEmployee(firstName, lastName);
        return employee + " удален.";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeInterface.findEmployee(firstName, lastName);
        return employee + " найден.";
    }
}
