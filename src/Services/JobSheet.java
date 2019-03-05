package Services;

public class JobSheet {

	private String owner;
	private Vehicle vehicle;
	private String jobDescription = " ";
	private float timeTaken = 0;
	private String tasksCompleted = " ";
	private int sparesUsed;
	private String status = "Pending";
	private String estimatedTime = "0 hours";
	private String jobNo;

	public void allocateRepairBay() {
		// TODO - implement JobSheet.allocateRepairBay
		throw new UnsupportedOperationException();
	}

	public void allocateMechanic() {
		// TODO - implement JobSheet.allocateMechanic
		throw new UnsupportedOperationException();
	}

	public String getOwner() {
		return this.owner;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	/**
	 * 
	 * @param jobDescription
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public float getTimeTaken() {
		return this.timeTaken;
	}

	/**
	 * 
	 * @param timeTaken
	 */
	public void setTimeTaken(float timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getTasksCompleted() {
		return this.tasksCompleted;
	}

	/**
	 * 
	 * @param tasksCompleted
	 */
	public void setTasksCompleted(String tasksCompleted) {
		this.tasksCompleted = tasksCompleted;
	}

	public void getSparesUsed() {
		// TODO - implement JobSheet.getSparesUsed
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sparesUsed
	 */
	public void setSparesUsed(int sparesUsed) {
		this.sparesUsed = sparesUsed;
	}

	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getEstimatedTime() {
		return this.estimatedTime;
	}

	/**
	 * 
	 * @param estimatedTime
	 */
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	/**
	 * 
	 * @param o
	 * @param v
	 * @param j
	 */
	public static JobSheet JobSheet(String o, Vehicle v, String j) {
		// TODO - implement JobSheet.JobSheet
		throw new UnsupportedOperationException();
	}

}