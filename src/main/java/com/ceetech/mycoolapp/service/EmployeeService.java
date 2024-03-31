package com.ceetech.mycoolapp.service;

import java.util.List;

import com.ceetech.mycoolapp.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee saveUpdate(Employee employee);

    void deleteById(int id);
}
