package com.javacorefour.javacorefour.service;

import com.javacorefour.javacorefour.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee maxSalaryDepartment(Integer departmentId);

    Employee minSalaryDepartment(Integer departmentId);

    List<Employee> allEmployeesInDepartment(Integer departmentId);

    Map<Integer, List<Employee>> allDepartmentsWithEmployees();
}
