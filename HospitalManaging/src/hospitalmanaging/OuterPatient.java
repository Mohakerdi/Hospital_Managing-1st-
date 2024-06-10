package hospitalmanaging;

import java.util.ArrayList;

public class OuterPatient extends Pateint {
    
    ArrayList<OTL> OuterLogs = new ArrayList();
    Date dateOfAccept;
    boolean isAccepted;
    
    public OuterPatient(String Name, String Address, Date dateOfBirth) {
        super(Name, Address, dateOfBirth);
    }
    

    public ArrayList<OTL> getOuterLogs() {
        return OuterLogs;
    }

    public Date getDateOfAccept() {
        return dateOfAccept;
    }

    public void setDateOfAccept(Date dateOfAccept) {
        this.dateOfAccept = dateOfAccept;
    }

    public boolean IsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    @Override
    public String toString() {
        return super.toString()+"\nOuterPatient{" + "OuterLogs=" + OuterLogs.size() + ", dateOfAccept=" + dateOfAccept + ", isAccepted=" + isAccepted + '}';
    }
    
    
    
}
