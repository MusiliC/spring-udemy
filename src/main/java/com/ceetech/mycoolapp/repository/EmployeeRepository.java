package com.ceetech.mycoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceetech.mycoolapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
     
}
