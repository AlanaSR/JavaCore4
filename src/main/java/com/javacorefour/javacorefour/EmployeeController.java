package com.javacorefour.javacorefour;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeInterface employeeService;

    public EmployeeController(EmployeeInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/print")
    public List<Employee> print() {
        return employeeService.printEmployee();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.addEmployee(employee);
        return employee + " добавлен.";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.removeEmployee(employee);
        return employee + " удален.";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.findEmployee(employee);
        return employee + " найден.";
    }
}
