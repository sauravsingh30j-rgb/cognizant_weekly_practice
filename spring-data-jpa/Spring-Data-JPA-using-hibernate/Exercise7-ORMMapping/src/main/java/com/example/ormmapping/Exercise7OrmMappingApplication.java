package com.example.ormmapping;

import com.example.ormmapping.entity.Employee;
import com.example.ormmapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise7OrmMappingApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(Exercise7OrmMappingApplication.class, args);
    }

    @Override
    public void run(String... args) {

        employeeService.addEmployee(new Employee(101, "Ankit", "IT"));
        employeeService.addEmployee(new Employee(102, "Rahul", "HR"));

        System.out.println("Employee Records");

        for (Employee employee : employeeService.getEmployees()) {
            System.out.println(employee);
        }
    }
}