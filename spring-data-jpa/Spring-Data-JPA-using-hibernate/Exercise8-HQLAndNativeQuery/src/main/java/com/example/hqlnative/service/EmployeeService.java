package com.example.hqlnative.service;

import com.example.hqlnative.entity.Employee;
import com.example.hqlnative.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> showEmployeesUsingHQL() {
        return employeeRepository.getEmployeesUsingHQL();
    }

    public List<Employee> showEmployeesUsingNativeQuery() {
        return employeeRepository.getEmployeesUsingNativeQuery();
    }
}