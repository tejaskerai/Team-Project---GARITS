/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickfixfitters.garits.reports;


import com.quickfixfitters.garits.actors.Mechanic;
import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.DiscountPlan;
import com.quickfixfitters.garits.entities.Invoice;
import com.quickfixfitters.garits.entities.JobSheet;
import com.quickfixfitters.garits.entities.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Tadai
 */
public class Report {

    private StockReport sReport;
    private Date endDate;
    private Date startDate;
    private Date dateOfReport;
    private ExportExcel exportExcel;
    private Invoice invoice;
    private JobSheet jobSheet;
    private Mechanic mechanic;
    private Vehicle vehicle;
    private DiscountPlan dPlan;



//    private SimpleDateFormat dateFormat
//            = new SimpleDateFormat("ddMMyy-hhmmss.SSS.pdf");


    private static Report report = null;

    private List invToList;

    public static Report getReport(){

        if(report == null){
            report = new Report();
            System.out.println("New Report generated");
            return report;
        }
        System.out.println("Report already exists");
        return report;
    }

    public Report(Date endDate, Date startDate, Date dateOfReport) {
        this.endDate = endDate;
        this.startDate = startDate;
        this.dateOfReport = dateOfReport;
    }
    public Report(){
    }

    public void archiveReport(){
    }

    public void createReport(List reportList, int colNo) {

        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();


        exportExcel.exportReport(sReport.getMappedSReport());
    }
    public void createInvoice(int JobID){
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();


// Create an instance of SimpleDateFormat used for formatting
// the string representation of date according to the chosen pattern
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");


        try{
            session.beginTransaction();
            Criteria partCriteria = session.createCriteria(Invoice.class,"invoice");
            partCriteria.createCriteria("JobSheet","JobSheet");

            ProjectionList newInvoice = Projections.projectionList();
            newInvoice.add(Projections.property(invoice.getCustomerForename()));
            newInvoice.add(Projections.property(invoice.getCustomerForename()));
            newInvoice.add(Projections.property(invoice.getCustomerAddress()));
            newInvoice.add(Projections.property(df.format(jobSheet.getDateCompleted())));
            newInvoice.add(Projections.property(jobSheet.getPart().toString()));
            newInvoice.add(Projections.property(vehicle.getRegNo()));
            newInvoice.add(Projections.property(vehicle.getMake()));
            newInvoice.add(Projections.property(vehicle.getModel()));
            newInvoice.add(Projections.property(jobSheet.getDescriptionOfWork()));
            newInvoice.add(Projections.property(calcSum(jobSheet.getPart(),dPlan.getDiscountPlanId())));
            newInvoice.add(Projections.property(calcVAT(calcSum(jobSheet.getPart(),dPlan.getDiscountPlanId()))));
            newInvoice.add(Projections.property(calcGrandTotal
                    (calcSum(jobSheet.getPart(), dPlan.getDiscountPlanId()),
                            calcVAT(calcSum(jobSheet.getPart(),dPlan.getDiscountPlanId())))));


            partCriteria.setProjection(newInvoice);

            invoiceToList(partCriteria.list());


        }
        catch (Exception e) {
            System.out.println("Stock Report generation Error.");
        }

    }

    private void invoiceToList(List invToList) {
        this.invToList = invToList;
    }


    private String calcVAT(String total){

        float VAT = Float.parseFloat(total) *0.2f;


        return String.valueOf(VAT);
    }

    private String calcSum(List partCost, int discountType){

        if (mechanic.getJobs().contains(jobSheet.getJobNo())) {
            
            // Mechanic rate
            // double sum = StatUtils.sum(partCost);

        }
        else {
            //Franchisee rate
        }

        String total = null;
        return total;
    }

    private String calcGrandTotal(String sum, String VAT){

        float grandTotal = Float.valueOf(sum) + Float.valueOf(VAT);    
       
        return  Float.toString(grandTotal);
    }

}
