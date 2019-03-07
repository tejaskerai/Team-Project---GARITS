package User_Accounts;

import Services.JobSheet;
import Services.Part;

public interface MechanicInterface {
    

    public void setJob();

    public JobSheet getJob(String jobNo);

    public void setJobDuration(String jobDuration);

    public String getJobDuration(String jobNo);

    public void usePart(Part part);

}
