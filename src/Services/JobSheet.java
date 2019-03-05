package Services;

public class JobSheet {

	private string owner;
	private Vehicle vehicle;
	private string jobDescription = " ";
	private float timeTaken = 0;
	private string tasksCompleted = " ";
	private int sparesUsed;
	private string status = "Pending";
	private string estimatedTime = "0 hours";
	private string jobNo;

	public void allocateRepairBay() {
		// TODO - implement JobSheet.allocateRepairBay
		throw new UnsupportedOperationException();
	}

	public void allocateMechanic() {
		// TODO - implement JobSheet.allocateMechanic
		throw new UnsupportedOperationException();
	}

	public string getOwner() {
		return this.owner;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public string getJobDescription() {
		return this.jobDescription;
	}

	/**
	 * 
	 * @param jobDescription
	 */
	public void setJobDescription(string jobDescription) {
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

	public string getTasksCompleted() {
		return this.tasksCompleted;
	}

	/**
	 * 
	 * @param tasksCompleted
	 */
	public void setTasksCompleted(string tasksCompleted) {
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

	public string getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(string status) {
		this.status = status;
	}

	public string getEstimatedTime() {
		return this.estimatedTime;
	}

	/**
	 * 
	 * @param estimatedTime
	 */
	public void setEstimatedTime(string estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	/**
	 * 
	 * @param o
	 * @param v
	 * @param j
	 */
	public static JobSheet JobSheet(string o, Vehicle v, string j) {
		// TODO - implement JobSheet.JobSheet
		throw new UnsupportedOperationException();
	}

}