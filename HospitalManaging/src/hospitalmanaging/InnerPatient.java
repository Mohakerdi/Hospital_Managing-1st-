package hospitalmanaging;
import java.util.ArrayList;

public class InnerPatient extends Pateint {

    ArrayList<OTL> OuterLogs = new ArrayList();
    ArrayList<ITL> InnerLogs = new ArrayList();
    Date dateOfRelease;
    boolean isReleased;
    
    public InnerPatient(String Name, String Address, Date dateOfBirth) {
        super(Name, Address, dateOfBirth);
    }


    public ArrayList<OTL> getOuterLogs() {
        return OuterLogs;
    }

    public ArrayList<ITL> getInnerLogs() {
        return InnerLogs;
    }
    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public boolean IsReleased() {
        return isReleased;
    }

    public void setIsReleased(boolean isReleased) {
        this.isReleased = isReleased;
    }

    @Override
    public String toString() {
        return super.toString()+"\nInnerPatient{" + "OuterLogs=" + OuterLogs.size() + ", InnerLogs=" + InnerLogs.size() + ", dateOfRelease=" + dateOfRelease + ", isReleased=" + isReleased + '}';
    }
    
}
