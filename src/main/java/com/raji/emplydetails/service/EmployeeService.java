package com.raji.emplydetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raji.emplydetails.entity.Employee;

@Service
public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee>getAllEmployees();
    Employee updateEmployee(Employee employee, int id);
    String deleteEmployee(int id);
    Employee getEmployeeById(int id);
}
