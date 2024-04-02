package com.ceetech.mycoolapp.service.impl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ceetech.mycoolapp.entity.Employee;
import com.ceetech.mycoolapp.repository.EmployeeRepository;
import com.ceetech.mycoolapp.service.EmployeeService;


@Service
public class EmployeeServiceImp implements EmployeeService {

    // private EmployeeDao employeeDao;

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        // return employeeDao.findAll();
        return employeeRepository.findAll();

    }

    @Override
    public Employee findById(int id) {
        // return employeeDao.findById(id);
        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee = null;

        if (result.isPresent()) {

            theEmployee = result.get();
        }else{
            throw new RuntimeException("Did not find employee");
        }
        return theEmployee;
    }

    @SuppressWarnings("null")
    // @Transactional
    @Override
    public Employee saveUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    // @Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}
