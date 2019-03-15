package com.quickfixfitters.garits1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Employee")
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "EmployeeNo")
    private int employeeNo;

    @Column(name = "Role")
    private String role;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    public Employee(String role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public Employee() {
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeNo=" + employeeNo + ", role=" + role + ", username=" + username + ", password=" + password + '}';
    }

}
