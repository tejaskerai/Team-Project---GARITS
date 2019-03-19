package com.quickfixfitters.garits.seeder;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Employee;
import com.quickfixfitters.garits.factories.EmployeeFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EmployeeSeeder implements SeederInterface {

    @Override
    public void seed() {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee = employeeFactory.Produce();

        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            
            
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> employeeCriteriaQuery = builder.createQuery(Employee.class);
            
            
            Root<Employee> root = employeeCriteriaQuery.from(Employee.class);
            employeeCriteriaQuery
                    .where(builder.equal(root.get("username"), employee.getUsername()));

            Query<Employee> employeeQuery = session.createQuery(employeeCriteriaQuery);

            try {
                Employee employeeFound = employeeQuery.getSingleResult();
            }
            catch (NoResultException e) {
                createEmployee(employee, session);
            }
            transaction.commit();
        }
    }

    private void createEmployee(Employee employee, Session session) {
        session.save(employee);
    }
}
