package Services;

public class Part {

	private string partName;
	private string code;
	private string manufacturer;
	private string vehicleType;
	private string year;
	private float price;
	private int currentStockLevel = 1;
	private int lowLevelThreshold = 0;

	public string getPartName() {
		return this.partName;
	}

	public string getCode() {
		return this.code;
	}

	public string getManufacturer() {
		return this.manufacturer;
	}

	public string getVehicleType() {
		return this.vehicleType;
	}

	public string getYear() {
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
	public static Part Part(string partName, string code, string manufacturer, string vehicleType, string year, string price, int lowLevelThreshold) {
		// TODO - implement Part.Part
		throw new UnsupportedOperationException();
	}

}