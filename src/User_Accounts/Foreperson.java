package User_Accounts;

import Services.*;

public class Foreperson extends Receptionist implements MechanicInterface {

    // All overides are methods from Mechanic
    @Override
    public void setJob() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public JobSheet getJob(String jobNo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void setJobDuration(String jobDuration) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getJobDuration(String jobNo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void usePart(Part part) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Forepersons additional operation
    public void allocateMechanic(String username){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}