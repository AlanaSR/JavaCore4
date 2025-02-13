package com.javacorefour.javacorefour.service.impl;

import com.javacorefour.javacorefour.Employee;
import com.javacorefour.javacorefour.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapServiceImplTest {
    private EmployeeListServiceImpl employeeService;
    private final Employee pavel = new Employee("Pavel", "Pavlov");
    private final Employee maxon = new Employee("Maxon", "Patison", 11233.2, 2);

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeListServiceImpl();
    }

    @Test
    void allEmployeeTest() {
        employeeService.addEmployee(pavel);
        employeeService.addEmployee(maxon);
        assertEquals(2, employeeService.allEmployee().size());
    }

    @Test
    void addEmployeeTest() {
        assertEquals(0, employeeService.allEmployee().size());
        employeeService.addEmployee(pavel);
        assertEquals(1, employeeService.allEmployee().size());
        assertEquals(pavel, employeeService.findEmployee(pavel.getFirstName(), pavel.getLastName()));
    }

    @Test
    void removeEmployeeTest() {
        employeeService.addEmployee(maxon);
        assertFalse(employeeService.allEmployee().isEmpty());
        employeeService.removeEmployee(maxon);
        assertTrue(employeeService.allEmployee().isEmpty());
    }

    @Test
    void findEmployeeTest() {
        employeeService.addEmployee(pavel);
        assertEquals(pavel, employeeService.findEmployee("Pavel", "Pavlov"));
    }
}