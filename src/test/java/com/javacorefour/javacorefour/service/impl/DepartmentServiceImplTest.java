package com.javacorefour.javacorefour.service.impl;

import com.javacorefour.javacorefour.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Mock
    private EmployeeMapServiceImpl employeeService;

    private final Employee pavel = new Employee("Pavel", "Pavlov", 4000, 1);
    private final Employee lisa = new Employee("Lisa", "Koza", 2000, 1);
    private final Employee maxon = new Employee("Maxon", "Patison", 1000, 2);
    private final Employee nika = new Employee("Nika", "Kostyanika", 3000, 2);

    @BeforeEach
    void setUp() {
        when(employeeService.allEmployee()).thenReturn(Arrays.asList(pavel, maxon, lisa, nika));
    }

    @Test
    void allDepartmentsWithEmployees() {
        Map<Integer, List<Employee>> employeesInDep = departmentService.allDepartmentsWithEmployees();
        assertEquals(2, employeesInDep.size());
        assertTrue(employeesInDep.get(2).containsAll(Arrays.asList(maxon, nika)));
    }

    @Test
    void allEmployeesInDepartment() {
        List<Employee> employees = departmentService.allEmployeesInDepartment(1);
        assertEquals(2, employees.size());
        assertTrue(employees.containsAll(Arrays.asList(pavel, lisa)));
    }

    @Test
    void maxSalaryDepartment() {
        assertEquals(4000, departmentService.maxSalaryDepartment(1));
    }

    @Test
    void minSalaryDepartment() {
        assertEquals(2000, departmentService.minSalaryDepartment(1));
    }

    @Test
    void sumSalaryInDepartment() {
        assertEquals(6000, departmentService.sumSalaryInDepartment(1));
    }
}