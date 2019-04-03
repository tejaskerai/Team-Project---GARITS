package com.quickfixfitters.garits.actors;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.JobSheet;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Mechanic{
    
    private static Mechanic mechanic = null;
    
    public static Mechanic getMechanic(){
        
        if(mechanic == null){
            mechanic = new Mechanic();
            System.out.println("New mechanic object created");
            return mechanic;
        }
        System.out.println("Mechanic object already exists");
        return mechanic;
        
    }
    
    // Returns a list of all jobs in the system.
    public List<JobSheet> getJobs() {
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(JobSheet.class);
            return (List<JobSheet>) criteria.list();
        }
    }
    
    
    public void claimJob(String userName,int jobId){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();
            JobSheet jobSheet = session.get(JobSheet.class, jobId);
            jobSheet.setRMechanic(userName);
           
            session.update(jobSheet);
            session.getTransaction().commit();     
            
        }
        catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }
    
    
}