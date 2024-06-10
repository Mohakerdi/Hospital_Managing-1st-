package hospitalmanaging;

public class OTL extends TreatmentLog {
    int clinicNum;
    Doctor dr;

    public OTL(int clinicNum, Doctor dr, Date date, int cost) {
        super(date, cost);
        this.clinicNum = clinicNum;
        this.dr = dr;
    }

    public int getClinicNum() {
        return clinicNum;
    }

    public void setClinicNum(int clinicNum) {
        this.clinicNum = clinicNum;
    }

    public Doctor getDr() {
        return dr;
    }

    public void setDr(Doctor dr) {
        this.dr = dr;
    }

    @Override
    public String toString() {
        return super.toString()+"{" + "clinicNum=" + clinicNum + ", dr=" + dr + '}';
    }

    
}
