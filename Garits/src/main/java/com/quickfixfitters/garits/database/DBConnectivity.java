package com.quickfixfitters.garits.database;

import com.quickfixfitters.garits.entities.Customer;
import com.quickfixfitters.garits.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DBConnectivity{
    
    
    public static SessionFactory factory;
    
    public static synchronized SessionFactory getSessionFactory(){
        if (factory == null){
            factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Customer.class).buildSessionFactory();
        }
        return factory;
    }
}