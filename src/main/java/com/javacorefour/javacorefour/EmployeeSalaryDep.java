package com.javacorefour.javacorefour;

import java.util.List;
import java.util.Map;

public interface EmployeeSalaryDep {
    Employee maxSalaryDepartment(Integer departmentId);

    Employee minSalaryDepartment(Integer departmentId);

    List<Employee> allEmployeesInDepartment(Integer departmentId);

    Map<Integer, List<Employee>> allDepartmentsWithEmployees();
}
