package com.facturas.facture.project.services;

import com.facturas.facture.project.model.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class cucumber {

    @Autowired
    private EmployeeService employeeService;
    private List<Employee> employees;

    /*@Given("there are employees in the system")
    public void givenThereAreEmployees() {
        employeeService.saveEmployee(new Employee(null, "Jenny", "dataciense"));
    }*/

    @When("I request all employees")
    public void whenIRequestAllEmployees() {
        employees = employeeService.getAllEmployees();
    }
}
