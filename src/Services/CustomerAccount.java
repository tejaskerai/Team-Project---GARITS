package Services;

public class CustomerAccount {

	private string customerID;
	private string name;
	private string email;
	private string mobile;
	private string paymentStatus;
	private string discountPlan;
	private float discountAmount;
	private string address;
	private string postCode;
	private int vehicles;

	public void archive() {
		// TODO - implement CustomerAccount.archive
		throw new UnsupportedOperationException();
	}

	public void recordPayment() {
		// TODO - implement CustomerAccount.recordPayment
		throw new UnsupportedOperationException();
	}

	public string getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(string name) {
		this.name = name;
	}

	public string getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(string email) {
		this.email = email;
	}

	public string getMobile() {
		return this.mobile;
	}

	/**
	 * 
	 * @param mobile
	 */
	public void setMobile(string mobile) {
		this.mobile = mobile;
	}

	public string getPaymentStatus() {
		return this.paymentStatus;
	}

	/**
	 * 
	 * @param paymentStatus
	 */
	public void setPaymentStatus(string paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public string getDiscountPlan() {
		return this.discountPlan;
	}

	/**
	 * 
	 * @param discountPlan
	 */
	public void setDiscountPlan(string discountPlan) {
		this.discountPlan = discountPlan;
	}

	public float getDiscountAmount() {
		return this.discountAmount;
	}

	/**
	 * 
	 * @param discountAmount
	 */
	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public string getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(string address) {
		this.address = address;
	}

	public string getPostCode() {
		return this.postCode;
	}

	/**
	 * 
	 * @param postCode
	 */
	public void setPostCode(string postCode) {
		this.postCode = postCode;
	}

	public void getVehicles() {
		// TODO - implement CustomerAccount.getVehicles
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param v
	 */
	public void addVehicle(Vehicle v) {
		// TODO - implement CustomerAccount.addVehicle
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param v
	 */
	public void removeVehicle(Vehicle v) {
		// TODO - implement CustomerAccount.removeVehicle
		throw new UnsupportedOperationException();
	}

	public string getCustomerID() {
		return this.customerID;
	}

	/**
	 * 
	 * @param customerID
	 * @param name
	 * @param email
	 * @param mobile
	 * @param paymentStatus
	 * @param discountPlan
	 * @param discountAmount
	 * @param address
	 * @param postCode
	 */
	public static CustomerAccount CustomerAccount(string customerID, string name, string email, string mobile, string paymentStatus, string discountPlan, float discountAmount, string address, string postCode) {
		// TODO - implement CustomerAccount.CustomerAccount
		throw new UnsupportedOperationException();
	}

}