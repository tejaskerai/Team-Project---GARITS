package com.quickfixfitters.garits.reports;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.JobSheet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VehiclesBookedReport {

    private int avgTimeTaken;
    private float avgPrice;
    private int MOTCount;
    private int annualService;
    private int repair;

    private static VehiclesBookedReport vBReport = null;

    public void generateReport(
            String jobNo,
            String dateBookedIn,
            String customerType,
            String jobType,
            Date dateStart,
            Date dateEnd

    )

    {
        /*
        * Set date standard
        * */
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");

        try {
             dateStart = formatter.parse(dateBookedIn);
             dateEnd = new Date(dateStart.getTime() + Calendar.MONTH);

        } catch (ParseException e) {
            System.out.println("VB Report Date Error");
            e.printStackTrace();
        }

        /*
        * Establishes connection to database
        * */
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            /*
            * creates a Vehicles booked report
            * */
            List vBR = session.createCriteria(JobSheet.class).
                    setProjection(Projections.projectionList()
                    .add(Projections.groupProperty(jobType))
                    .add(Projections.count(jobNo)))
                    .list();


            Conjunction and = Restrictions.conjunction();
            and.add( Restrictions.ge("dateBookedIn", dateStart) );
            and.add( Restrictions.lt("dateBookedIn", dateEnd) );

        } catch (Exception e) {
            System.out.println("Stock Report generation Error.");
        }
    }
}
