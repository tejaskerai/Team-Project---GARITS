package Ordering;

import Services.*;
import Reports.*;
import java.util.Date;

public class PartOrder {

	private String orderID;
	private Part part;
	private int amount;
	private float total;
	private Invoice invoice = null;
	private Date date;

	public Part getPart() {
		return this.part;
	}

	public int getAmount() {
		return this.amount;
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
	 * @param part
	 * @param amount
	 * @param orderID
	 * @param date
	 */
	public static PartOrder PartOrder(Part part, int amount, String orderID, Date date) {
		// TODO - implement PartOrder.PartOrder
		throw new UnsupportedOperationException();
	}

}