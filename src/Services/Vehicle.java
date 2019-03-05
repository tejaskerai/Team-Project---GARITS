package Services;

import java.util.Date;

public class Vehicle {

	private String regNo;
	private String make;
	private String model;
	private int engSerial;
	private int chassisNo;
	private String colour;
	private Date MOTdate = null;

	public String getRegNo() {
		return this.regNo;
	}

	public String getMake() {
		return this.make;
	}

	public String getModel() {
		return this.model;
	}

	public int getEngSerial() {
		return this.engSerial;
	}

	public int getChassisNo() {
		return this.chassisNo;
	}

	public String getColour() {
		return this.colour;
	}

	/**
	 * 
	 * @param colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	public Date getMOTdate() {
		// TODO - implement Vehicle.getMOTdate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param MOTdate
	 */
	public void setMOTdate(Date MOTdate) {
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
	public static Vehicle Vehicle(String rNo, String ma, String mo, int eSe, int cNo, String col) {
		// TODO - implement Vehicle.Vehicle
		throw new UnsupportedOperationException();
	}

}