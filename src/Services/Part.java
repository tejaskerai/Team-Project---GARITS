package Services;

public class Part {

	private String partName;
	private String code;
	private String manufacturer;
	private String vehicleType;
	private String year;
	private float price;
	private int currentStockLevel = 1;
	private int lowLevelThreshold = 0;

	public String getPartName() {
		return this.partName;
	}

	public String getCode() {
		return this.code;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public String getYear() {
		return this.year;
	}

	public float getPrice() {
		return this.price;
	}

	public int getCurrentStockLevel() {
		return this.currentStockLevel;
	}

	/**
	 * 
	 * @param currentStockLevel
	 */
	public void setCurrentStockLevel(int currentStockLevel) {
		this.currentStockLevel = currentStockLevel;
	}

	public int getLowLevelThreshold() {
		return this.lowLevelThreshold;
	}

	/**
	 * 
	 * @param lowLevelThreshold
	 */
	public void setLowLevelThreshold(int lowLevelThreshold) {
		this.lowLevelThreshold = lowLevelThreshold;
	}

	/**
	 * 
	 * @param partName
	 * @param code
	 * @param manufacturer
	 * @param vehicleType
	 * @param year
	 * @param price
	 * @param lowLevelThreshold
	 */
	public static Part Part(String partName, String code, String manufacturer, String vehicleType, String year, String price, int lowLevelThreshold) {
		// TODO - implement Part.Part
		throw new UnsupportedOperationException();
	}

}