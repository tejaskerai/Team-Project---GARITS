package Ordering;

import Services.*;
import Reports.*;

public class PartOrder {

	private string orderID;
	private Part part;
	private int amount;
	private float total;
	private Invoice invoice = empty;
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

	public string getOrderID() {
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
	public static PartOrder PartOrder(Part part, int amount, string orderID, Date date) {
		// TODO - implement PartOrder.PartOrder
		throw new UnsupportedOperationException();
	}

}