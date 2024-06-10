package hospitalmanaging;

public abstract class Doctor extends Person {
    static public int drCnt=0;
    boolean isContracted =false;
    int depNum;
    int type;
    public Doctor(int depNum, String Name, String Address, Date dateOfBirth) {
        super(Name, Address, dateOfBirth);
        drCnt++;
        Num = drCnt;
        this.depNum = depNum;
    } 

    @Override
    public String toString() {
        return super.toString()+"\n{depNum=" + depNum + "}";
    }
      
}
