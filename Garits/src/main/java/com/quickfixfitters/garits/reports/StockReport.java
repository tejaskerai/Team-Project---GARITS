package com.quickfixfitters.garits.reports;


import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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


    /*
    * Generates stock report
    * */
    public void generateReport() {

        /*
        * creates connection with a db
        * */
        System.out.println("Gen Start");
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        try {
            /*
             * creates a projected hibernate list and puts it into java.util.list
             * */
            System.out.println("Gen Try");
            session.beginTransaction();


            /*
             * creates Entity Manager
             * */
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            /*
            *  creates Criteria Builder
            * */
            CriteriaBuilder cb = session.getCriteriaBuilder();

            /*
             * creates queries
             * */
            CriteriaQuery<Object> cq = cb.createQuery();
            Root<Part> from = cq.from(Part.class);

            //Select Records

            CriteriaQuery<Object> select = cq.select(from);
            TypedQuery<Object> q = entitymanager.createQuery(select);
            List<Object> allitems = q.getResultList();
            System.out.println(q.getResultList());

            /*
             * Maps the list so it would be accepted be ExcelExport class
             * */
            Map<Integer, Object[]> data = new TreeMap<>();
            System.out.println("mapping Start");
            data.put(1,new Object[]{"ID","Part Name","Part Code","Manufacturer","Vehicle Type","StockLevel","Low Level Threshold","Unit Price","StockPrice"});
            for (Object o : allitems) {

                Part p = (Part) o;
                data.put(p.getId()+1, new Object[]{p.getId(), p.getPartName(), p.getPartCode(),
                        p.getManufacturer(), p.getVehicleType(), p.getStockLevel(), p.getLowLevelThreshold(),
                        Float.toString(p.getUnitPrice()),Float.toString(p.getUnitPrice()*p.getStockLevel())});
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
