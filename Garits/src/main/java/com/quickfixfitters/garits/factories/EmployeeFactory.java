package com.quickfixfitters.garits.factories;

import com.quickfixfitters.garits.entities.Employee;

import java.util.List;

public class EmployeeFactory implements FactoryInterface<Employee> {
    @Override
    /*
    * creates default Admin
    * */
    public Employee Produce() {
        return new Employee(
                "test", "user", "admin", "test", "test123"
        );
    }
}
