package Services;

public abstract interface ServicesInterface {

	/**
	 * 
	 * @param regNo
	 */
	abstract Vehicle getVehicle(String regNo);

	/**
	 * 
	 * @param vehicle
	 */
	abstract void addVehicle(Vehicle vehicle);

	/**
	 * 
	 * @param vehicle
	 */
	abstract void removeVehicle(/*regNo vehicle*/);

	/**
	 * 
	 * @param CustomerID
	 */
	abstract CustomerAccount getCustomerAccount(String CustomerID);

	abstract void createCustomerAccount();

	/**
	 * 
	 * @param customerAccount
	 */
	abstract void removeCustomerAccount(/*CustomerID customerAccount*/);

	/**
	 * 
	 * @param jobNo
	 */
	abstract JobSheet getJobSheet(String jobNo);

	/**
	 * 
	 * @param o
	 * @param v
	 * @param j
	 */
	abstract void createJobSheet(String o, Vehicle v, String j);

	/**
	 * 
	 * @param code
	 */
	abstract Part getPart(String code);

	abstract void addPart();

}