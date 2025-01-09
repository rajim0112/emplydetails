package com.raji.emplydetails.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

@Entity
@Table(name="employee_details")
// @NoArgsConstructor
// @AllArgsConstructor
// @Data

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int employeeId;
    private String name;
    private long phoneNo;
    private String location;

    //getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    //constructor
    public Employee(int employeeId, String name, int phoneNo, String location) {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.location = location;
    }
    public Employee() {
        super();
    }
    
    @Override
    public String toString() {
        return "Employee [id=" + id + ", employeeId=" + employeeId + ", name=" + name + ", phoneNo=" + phoneNo
                + ", location=" + location + "]";
    }
     
}
