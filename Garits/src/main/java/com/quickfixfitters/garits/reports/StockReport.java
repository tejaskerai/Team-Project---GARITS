package com.quickfixfitters.garits.reports;


import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Part;
import com.quickfixfitters.garits.entities.StockLevel;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.loader.custom.sql.SQLQueryParser;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Tadai
 */
public class StockReport extends Report {


    private Map<Integer, Object[]> mappedSReport;

    private List stockLevelReport;


    private static StockReport sReport = null;


    public void generateReport() {


        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();
            //  Criteria partCriteria = session.createCriteria(Part.class,"part");
            //  partCriteria.createCriteria("StockLevel","OrderNo");

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Object> cq = cb.createQuery();
            Root<Part> from = cq.from(Part.class);

            //Select Records
            System.out.println("Select Records");
            CriteriaQuery<Object> select = cq.select(from);
            TypedQuery<Object> q = entitymanager.createQuery(cq);
            List<Object> allitems = q.getResultList();


            Map<Integer, Object[]> data = new TreeMap<>();
            for (Object o : allitems) {
                Part p = (Part) o;
                data.put(p.getId(), new Object[]{p.getId(), p.getPartName(), p.getPartCode(),
                        p.getManufacturer(), p.getVehicleType(), p.getStockLevel(), p.getLowLevelThreshold(),
                        p.getUnitPrice()});
            }
            setMappedSReport(data);

        } catch (Exception e) {
            System.out.println("Stock Report generation Error.");
        }

    }

    public List getStockLevelReport() {
        return stockLevelReport;
    }

    private void setStockLevelReport(List stockLevelReport) {
        this.stockLevelReport = stockLevelReport;
    }


    public Map<Integer, Object[]> getMappedSReport() {
        return mappedSReport;
    }

    public void setMappedSReport(Map<Integer, Object[]> mappedSReport) {
        this.mappedSReport = mappedSReport;
    }
}
