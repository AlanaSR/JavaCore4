package com.javacorefour.javacorefour.controller;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.service.DepartmentService;
import com.javacorefour.javacorefour.service.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Employee maxSalaryDepartment(@RequestParam ("departmentId") Integer departmentId) {
        return departmentService.maxSalaryDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryDepartment(@RequestParam ("departmentId") Integer departmentId) {
        return departmentService.minSalaryDepartment(departmentId);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public List<Employee> allEmployeesInDepartment(@RequestParam ("departmentId") Integer departmentId) {
        return departmentService.allEmployeesInDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> allDepartmentsWithEmployees() {
        return departmentService.allDepartmentsWithEmployees();
    }
}
