package com.raji.emplydetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raji.emplydetails.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
