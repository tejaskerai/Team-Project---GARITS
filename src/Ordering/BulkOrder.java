package Ordering;

import Reports.*;

public class BulkOrder {

	private string orderID;
	private int parts;
	private float total;
	private Invoice invoice = empty;
	private Date date;

	public void getParts() {
		// TODO - implement BulkOrder.getParts
		throw new UnsupportedOperationException();
	}

	public float getTotal() {
		return this.total;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public string getOrderID() {
		return this.orderID;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param orderID
	 * @param date
	 */
	public static BulkOrder BulkOrder(string orderID, Date date) {
		// TODO - implement BulkOrder.BulkOrder
		throw new UnsupportedOperationException();
	}

}