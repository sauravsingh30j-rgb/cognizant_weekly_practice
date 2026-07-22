package com.example.hqlnative;

import com.example.hqlnative.entity.Employee;
import com.example.hqlnative.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise8HqlAndNativeQueryApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(Exercise8HqlAndNativeQueryApplication.class, args);
    }

    @Override
    public void run(String... args) {

        employeeService.saveEmployee(new Employee(101, "Ankit", "IT"));
        employeeService.saveEmployee(new Employee(102, "Rahul", "HR"));

        System.out.println("HQL Result");

        for (Employee employee : employeeService.showEmployeesUsingHQL()) {
            System.out.println(employee);
        }

        System.out.println();

        System.out.println("Native Query Result");

        for (Employee employee : employeeService.showEmployeesUsingNativeQuery()) {
            System.out.println(employee);
        }
    }
}