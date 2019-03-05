package Ordering;

import Services.*;

public abstract interface OrderingInterface {

	/**
	 * 
	 * @param orderID
	 */
	abstract BulkOrder getBulkOrder(string orderID);

	/**
	 * 
	 * @param orderID
	 * @param date
	 */
	abstract void createBulkOrder(string orderID, Date date);

	/**
	 * 
	 * @param orderID
	 */
	abstract PartOrder getPartOrder(string orderID);

	/**
	 * 
	 * @param part
	 * @param amount
	 * @param orderID
	 * @param date
	 */
	abstract void createPartOrder(Part part, int amount, string orderID, Date date);

}