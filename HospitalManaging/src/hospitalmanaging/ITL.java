package hospitalmanaging;
import java.util.ArrayList;

public class ITL extends TreatmentLog {
    int depNum;
    ArrayList drsLog;

    public ITL(int depNum, ArrayList drsLog, Date date, int cost) {
        super(date, cost);
        this.depNum = depNum;
        this.drsLog = drsLog;
    }   

    public int getDepNum() {
        return depNum;
    }

    public void setDepNum(int depNum) {
        this.depNum = depNum;
    }

    public ArrayList getDrsLog() {
        return drsLog;
    }

    public void setDrsLog(ArrayList drsLog) {
        this.drsLog = drsLog;
    }

    @Override
    public String toString() {
        return super.toString()+"{" + "depNum=" + depNum + ", drsLog=" + drsLog + '}';
    }
    
    
}
