package Ordering;

import Services.Part;
import java.util.Date;

public class OrderingController implements OrderingInterface {

	/**
	 * 
	 * @param orderID
	 */
	public BulkOrder getBulkOrder(String orderID) {
		// TODO - implement OrderingController.getBulkOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param orderID
	 * @param date
	 */
	public void createBulkOrder(String orderID, Date date) {
		// TODO - implement OrderingController.createBulkOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param orderID
	 */
	public PartOrder getPartOrder(String orderID) {
		// TODO - implement OrderingController.getPartOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param orderID
	 * @param date
	 */
	public void createPartOrder(String orderID, Date date) {
		// TODO - implement OrderingController.createPartOrder
		throw new UnsupportedOperationException();
	}

	public static OrderingController OrderingController() {
		// TODO - implement OrderingController.OrderingController
		throw new UnsupportedOperationException();
	}

    @Override
    public void createPartOrder(Part part, int amount, String orderID, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}