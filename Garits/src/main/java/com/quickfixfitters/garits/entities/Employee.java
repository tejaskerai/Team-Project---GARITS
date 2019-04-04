package com.quickfixfitters.garits.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "EmployeeNo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNo;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "Role")
    private String role;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;


    /*
    * Hibernate Constructor
    * */
    public Employee() {
    }

    public Employee(String firstname, String lastname, String role, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    /*
    * Gets Employee Number
    * */
    public int getEmployeeNo() {
        return employeeNo;
    }
    /*
    * Sets Employee Number
    * */
    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }
    /*
    * Gets Firstname
    * */
    public String getFirstname() {
        return firstname;
    }
    /*
    * Sets Firstname
    * */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /*
    * Gets Lastname
    * */
    public String getLastname() {
        return lastname;
    }
    /*
    * Sets Lastname
    * */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /*
    * Gets Role
    * */
    public String getRole() {
        return role;
    }
    /*
    * Sets Role
    * */
    public void setRole(String role) {
        this.role = role;
    }
    /*
    * Gets Username
    * */
    public String getUsername() {
        return username;
    }
    /*
    * Sets Username
    * */
    public void setUsername(String username) {
        this.username = username;
    }
    /*
    * Gets Password
    * */
    public String getPassword() {
        return password;
    }
    /*
    * Sets Password
    * */
    public void setPassword(String password) {
        this.password = password;
    }

}
