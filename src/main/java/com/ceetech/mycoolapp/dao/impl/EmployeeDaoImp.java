package com.ceetech.mycoolapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceetech.mycoolapp.dao.EmployeeDao;
import com.ceetech.mycoolapp.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

    // entity manager field
    private EntityManager em;

    @Autowired
    public EmployeeDaoImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> findAllQuery = em.createQuery("from Employee", Employee.class);

        // execute query and get list
        List<Employee> employees = findAllQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee saveUpdate(Employee employee) {
        Employee newEmployee = em.merge(employee);
        return newEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

}
