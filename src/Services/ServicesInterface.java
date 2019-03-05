package Services;

public abstract interface ServicesInterface {

	/**
	 * 
	 * @param regNo
	 */
	abstract Vehicle getVehicle(string regNo);

	/**
	 * 
	 * @param vehicle
	 */
	abstract void addVehicle(Vehicle vehicle);

	/**
	 * 
	 * @param vehicle
	 */
	abstract void removeVehicle(regNo vehicle);

	/**
	 * 
	 * @param CustomerID
	 */
	abstract CustomerAccount getCustomerAccount(string CustomerID);

	abstract void createCustomerAccount();

	/**
	 * 
	 * @param customerAccount
	 */
	abstract void removeCustomerAccount(CustomerID customerAccount);

	/**
	 * 
	 * @param jobNo
	 */
	abstract JobSheet getJobSheet(string jobNo);

	/**
	 * 
	 * @param o
	 * @param v
	 * @param j
	 */
	abstract void createJobSheet(string o, Vehicle v, string j);

	/**
	 * 
	 * @param code
	 */
	abstract Part getPart(string code);

	abstract void addPart();

}