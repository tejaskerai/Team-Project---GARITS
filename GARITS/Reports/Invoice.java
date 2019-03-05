package Reports;

import Services.*;

public class Invoice {

	private string invoiceID;
	private CustomerAccount customerAccount;
	private Date date;
	private Part parts;
	private float total;
	private Vehicle vehicle;
	private JobSheet jobDetails;
	private float VAT;

	public string getInvoiceID() {
		return this.invoiceID;
	}

	public string getPaymentStatus() {
		// TODO - implement Invoice.getPaymentStatus
		throw new UnsupportedOperationException();
	}

	public string getPartName() {
		// TODO - implement Invoice.getPartName
		throw new UnsupportedOperationException();
	}

	public string getManufacturer() {
		// TODO - implement Invoice.getManufacturer
		throw new UnsupportedOperationException();
	}

	public string getVehichleType() {
		// TODO - implement Invoice.getVehichleType
		throw new UnsupportedOperationException();
	}

	public string getYears() {
		// TODO - implement Invoice.getYears
		throw new UnsupportedOperationException();
	}

	public float getPrice() {
		// TODO - implement Invoice.getPrice
		throw new UnsupportedOperationException();
	}

	public string getCustomerDetails() {
		// TODO - implement Invoice.getCustomerDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public Invoice(string ID) {
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
	public static Invoice Invoice(string invoiceID, CustomerAccount customerAccount, Date date, Part parts, float total, Vehicle vehicle, JobSheet jobDetails, float VAT) {
		// TODO - implement Invoice.Invoice
		throw new UnsupportedOperationException();
	}

}