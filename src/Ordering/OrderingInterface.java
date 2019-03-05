package Ordering;

import Services.*;
import java.util.Date;

public abstract interface OrderingInterface {

	/**
	 * 
	 * @param orderID
	 */
	abstract BulkOrder getBulkOrder(String orderID);

	/**
	 * 
	 * @param orderID
	 * @param date
	 */
	abstract void createBulkOrder(String orderID, Date date);

	/**
	 * 
	 * @param orderID
	 */
	abstract PartOrder getPartOrder(String orderID);

	/**
	 * 
	 * @param part
	 * @param amount
	 * @param orderID
	 * @param date
	 */
	abstract void createPartOrder(Part part, int amount, String orderID, Date date);

}