package com.ceetech.mycoolapp.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceetech.mycoolapp.entity.Employee;
import com.ceetech.mycoolapp.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employees/{id}")
    public Employee getSingle(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("No student with te id");
        }
        return employee;
    }

    @PostMapping("employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);

        Employee newEmployee = employeeService.saveUpdate(employee);

        return newEmployee;
    }

    @PutMapping("employees")
    public Employee update(@RequestBody Employee employee) {

        Employee newEmployee = employeeService.saveUpdate(employee);

        return newEmployee;
    }

    @DeleteMapping("employees/{id}")
    public String delete(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("No student with te id");
        }
        employeeService.deleteById(id);

        return "Deleted successfully!";
    }

}
