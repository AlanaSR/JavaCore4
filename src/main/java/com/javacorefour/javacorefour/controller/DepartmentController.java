package com.javacorefour.javacorefour.controller;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.service.api.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/employees")
    public Map<Integer, List<Employee>> allDepartmentsWithEmployees() {
        return departmentService.allDepartmentsWithEmployees();
    }

    @GetMapping("/{id}/employees")
    public List<Employee> allEmployeesInDepartment(@PathVariable Integer id) {
        return departmentService.allEmployeesInDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public Double maxSalaryDepartment(@PathVariable Integer id) {
        return departmentService.maxSalaryDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public Double minSalaryDepartment(@PathVariable Integer id) {
        return departmentService.minSalaryDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public Double sumSalaryInDepartment (@PathVariable Integer id) {
        return departmentService.sumSalaryInDepartment(id);
    }
}
