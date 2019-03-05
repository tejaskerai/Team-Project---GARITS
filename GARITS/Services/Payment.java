package Services;

public class Payment {

	private Date date;
	private string amount;
	private string paymentType;

	public Date getDate() {
		return this.date;
	}

	public string getAmount() {
		return this.amount;
	}

	public string getPaymentType() {
		return this.paymentType;
	}

	/**
	 * 
	 * @param d
	 * @param a
	 * @param paymentType
	 */
	public static Payment Payment(Date d, string a, string paymentType) {
		// TODO - implement Payment.Payment
		throw new UnsupportedOperationException();
	}

}