package com.ceetech.mycoolapp.dao;

import java.util.List;

import com.ceetech.mycoolapp.entity.Employee;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    Employee saveUpdate(Employee employee);

    void deleteById(int id);
}
