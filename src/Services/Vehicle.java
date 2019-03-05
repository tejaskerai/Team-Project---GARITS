package Services;

public class Vehicle {

	private string regNo;
	private string make;
	private string model;
	private int engSerial;
	private int chassisNo;
	private string colour;
	private date MOTdate = NULL;

	public string getRegNo() {
		return this.regNo;
	}

	public string getMake() {
		return this.make;
	}

	public string getModel() {
		return this.model;
	}

	public int getEngSerial() {
		return this.engSerial;
	}

	public int getChassisNo() {
		return this.chassisNo;
	}

	public string getColour() {
		return this.colour;
	}

	/**
	 * 
	 * @param colour
	 */
	public void setColour(string colour) {
		this.colour = colour;
	}

	public date getMOTdate() {
		// TODO - implement Vehicle.getMOTdate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param MOTdate
	 */
	public void setMOTdate(date MOTdate) {
		// TODO - implement Vehicle.setMOTdate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param rNo
	 * @param ma
	 * @param mo
	 * @param eSe
	 * @param cNo
	 * @param col
	 */
	public static Vehicle Vehicle(string rNo, string ma, string mo, int eSe, int cNo, string col) {
		// TODO - implement Vehicle.Vehicle
		throw new UnsupportedOperationException();
	}

}