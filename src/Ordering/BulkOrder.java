package Ordering;

import Reports.*;
import java.util.Date;

public class BulkOrder {

	private String orderID;
	private int parts;
	private float total;
	private Invoice invoice = null;
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

	public String getOrderID() {
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
	public static BulkOrder BulkOrder(String orderID, Date date) {
		// TODO - implement BulkOrder.BulkOrder
		throw new UnsupportedOperationException();
	}

}