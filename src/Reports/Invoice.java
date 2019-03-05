package Reports;

import Services.*;
import java.util.Date;

public class Invoice {

	private String invoiceID;
	private CustomerAccount customerAccount;
	private Date date;
	private Part parts;
	private float total;
	private Vehicle vehicle;
	private JobSheet jobDetails;
	private float VAT;

	public String getInvoiceID() {
		return this.invoiceID;
	}

	public String getPaymentStatus() {
		// TODO - implement Invoice.getPaymentStatus
		throw new UnsupportedOperationException();
	}

	public String getPartName() {
		// TODO - implement Invoice.getPartName
		throw new UnsupportedOperationException();
	}

	public String getManufacturer() {
		// TODO - implement Invoice.getManufacturer
		throw new UnsupportedOperationException();
	}

	public String getVehichleType() {
		// TODO - implement Invoice.getVehichleType
		throw new UnsupportedOperationException();
	}

	public String getYears() {
		// TODO - implement Invoice.getYears
		throw new UnsupportedOperationException();
	}

	public float getPrice() {
		// TODO - implement Invoice.getPrice
		throw new UnsupportedOperationException();
	}

	public String getCustomerDetails() {
		// TODO - implement Invoice.getCustomerDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public Invoice(String ID) {
		// TODO - implement Invoice.Invoice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param invoiceID
	 * @param customerAccount
	 * @param date
	 * @param parts
	 * @param total
	 * @param vehicle
	 * @param jobDetails
	 * @param VAT
	 */
	public static Invoice Invoice(String invoiceID, CustomerAccount customerAccount, Date date, Part parts, float total, Vehicle vehicle, JobSheet jobDetails, float VAT) {
		// TODO - implement Invoice.Invoice
		throw new UnsupportedOperationException();
	}

}