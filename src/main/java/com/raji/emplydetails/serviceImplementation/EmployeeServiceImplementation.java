// package com.raji.emplydetails.serviceImplementation;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.raji.emplydetails.entity.Employee;
// import com.raji.emplydetails.exception.EmployeeException;
// import com.raji.emplydetails.repository.EmployeeRepository;
// import com.raji.emplydetails.service.EmployeeService;

// @Service
// public class EmployeeServiceImplementation implements EmployeeService {

//     @Autowired
//     private EmployeeRepository repository;

//     @Override
//     public Employee createEmployee(Employee employee) {
//         return repository.save(employee);
//     }

//     @Override
//     public List<Employee> getAllEmployees() {
//         return repository.findAll();
//     }

//     @Override
//     public Employee updateEmployee(Employee employee, int id) {
//         Optional<Employee> existingEmployee = repository.findById(id);
//         if (existingEmployee.isEmpty()) {
//             throw new EmployeeException("Employee details not found with id: " + id);
//         }
//         Employee updatedEmployee = existingEmployee.get();
//         updatedEmployee.setEmployeeId(employee.getEmployeeId());
//         updatedEmployee.setName(employee.getName());
//         updatedEmployee.setPhoneNo(employee.getPhoneNo());
//         updatedEmployee.setLocation(employee.getLocation());
//         return repository.save(updatedEmployee);
//     }

//     @Override
//     public String deleteEmployee(int id) {
//         if (!repository.existsById(id)) {
//             throw new EmployeeException("Employee details not found with id: " + id);
//         }
//         repository.deleteById(id);
//         return "Employee details deleted with id: " + id;
//     }

//     @Override
//     public Employee getEmployeeById(int id) {
//         return repository.findById(id).orElseThrow(() -> new EmployeeException("Employee details not found with id: " + id));
//     }
// }


