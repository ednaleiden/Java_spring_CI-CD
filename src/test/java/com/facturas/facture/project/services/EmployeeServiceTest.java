package com.example.demo.service;


import com.facturas.facture.project.model.Employee;
import com.facturas.facture.project.repository.EmployeeRepository;
import com.facturas.facture.project.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee1 = new Employee(1L, "Jenny", "Analityc");
        employee2 = new Employee(2L, "Edna", "Developer");
    }

    @Test
    void getAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));
        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(2, employees.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void getEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee1));
        Optional<Employee> employee = employeeService.getEmployeeById(1L);
        assertEquals("John Doe", employee.get().getName());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void saveEmployee() {
        when(employeeRepository.save(employee1)).thenReturn(employee1);
        Employee savedEmployee = employeeService.saveEmployee(employee1);
        assertEquals("John Doe", savedEmployee.getName());
        verify(employeeRepository, times(1)).save(employee1);
    }

    @Test
    void deleteEmployee() {
        employeeService.deleteEmployee(1L);
        verify(employeeRepository, times(1)).deleteById(1L);
    }
}
