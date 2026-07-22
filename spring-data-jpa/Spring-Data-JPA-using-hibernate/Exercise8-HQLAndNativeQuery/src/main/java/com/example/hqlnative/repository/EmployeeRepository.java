package com.example.hqlnative.repository;

import com.example.hqlnative.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee")
    List<Employee> getEmployeesUsingHQL();


    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getEmployeesUsingNativeQuery();

}