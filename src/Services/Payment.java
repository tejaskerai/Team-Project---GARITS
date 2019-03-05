package Services;

import java.util.Date;

public class Payment {

	private Date date;
	private String amount;
	private String paymentType;

	public Date getDate() {
		return this.date;
	}

	public String getAmount() {
		return this.amount;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	/**
	 * 
	 * @param d
	 * @param a
	 * @param paymentType
	 */
	public static Payment Payment(Date d, String a, String paymentType) {
		// TODO - implement Payment.Payment
		throw new UnsupportedOperationException();
	}

}