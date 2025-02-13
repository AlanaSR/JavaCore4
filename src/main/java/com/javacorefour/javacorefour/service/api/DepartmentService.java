package com.javacorefour.javacorefour.service.api;

import com.javacorefour.javacorefour.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Double maxSalaryDepartment(Integer departmentId);

    Double minSalaryDepartment(Integer departmentId);

    List<Employee> allEmployeesInDepartment(Integer departmentId);

    Map<Integer, List<Employee>> allDepartmentsWithEmployees();

    Double sumSalaryInDepartment(Integer departmentId);
}
