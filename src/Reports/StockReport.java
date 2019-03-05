package Reports;

import Services.*;

public class StockReport extends Report {

	private Part part;
	private float totalPrice;

	public Part getPart() {
		return this.part;
	}

	/**
	 * 
	 * @param part
	 * @param totalPrice
	 */
	public static void generate(Part part, float totalPrice) {
		// TODO - implement StockReport.generate
		throw new UnsupportedOperationException();
	}

}