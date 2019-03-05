package Services;

public class CustomerAccount {

	private String customerID;
	private String name;
	private String email;
	private String mobile;
	private String paymentStatus;
	private String discountPlan;
	private float discountAmount;
	private String address;
	private String postCode;
	private int vehicles;

	public void archive() {
		// TODO - implement CustomerAccount.archive
		throw new UnsupportedOperationException();
	}

	public void recordPayment() {
		// TODO - implement CustomerAccount.recordPayment
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	/**
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	/**
	 * 
	 * @param paymentStatus
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getDiscountPlan() {
		return this.discountPlan;
	}

	/**
	 * 
	 * @param discountPlan
	 */
	public void setDiscountPlan(String discountPlan) {
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

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return this.postCode;
	}

	/**
	 * 
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
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

	public String getCustomerID() {
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
	public static CustomerAccount CustomerAccount(String customerID, String name, String email, String mobile, String paymentStatus, String discountPlan, float discountAmount, String address, String postCode) {
		// TODO - implement CustomerAccount.CustomerAccount
		throw new UnsupportedOperationException();
	}

}