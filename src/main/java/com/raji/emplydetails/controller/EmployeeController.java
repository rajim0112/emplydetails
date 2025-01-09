package com.raji.emplydetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raji.emplydetails.entity.Employee;
import com.raji.emplydetails.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    System.out.println("Received Employee Data: " + employee);
    return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
}

    
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployee(){
        return new ResponseEntity<>(employeeRepository.findAll(),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable int id,@RequestBody Employee emp){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employee.get().setEmployeeId(emp.getEmployeeId());
            employee.get().setName(emp.getName());
            employee.get().setPhoneNo(emp.getPhoneNo());
            employee.get().setLocation(emp.getLocation());
            return new ResponseEntity<>(employeeRepository.save(employee.get()),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteEmployee(@PathVariable int id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

// *********************using service,service implementation,exception********************************
// package com.raji.emplydetails.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.raji.emplydetails.entity.Employee;
// import com.raji.emplydetails.service.EmployeeService;

// @CrossOrigin(origins = "http://localhost:3000")
// @RestController
// @RequestMapping("/api/emp")
// public class EmployeeController {

//     @Autowired
//     private EmployeeService employeeService;

//     @PostMapping("/create")
//     public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//         return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
//     }

//     @GetMapping("/get")
//     public ResponseEntity<List<Employee>> getEmployees() {
//         return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
//     }

//     @PutMapping("/update/{id}")
//     public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
//         return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
//     }

//     @DeleteMapping("/delete/{id}")
//     public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
//         return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.NO_CONTENT);
//     }

//     @GetMapping("/get/{id}")
//     public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
//         return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
//     }
// }

