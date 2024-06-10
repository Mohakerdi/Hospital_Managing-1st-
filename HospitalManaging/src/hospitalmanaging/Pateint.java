package hospitalmanaging;

public abstract class Pateint extends Person{
    static private int Pcnt=0;
    int depNum;

    public int getDepNum() {
        return depNum;
    }

    public void setDepNum(int depNum) {
        this.depNum = depNum;
    }
    public Pateint(String Name, String Address, Date dateOfBirth) {
        super(Name, Address, dateOfBirth);
        Pcnt++;
        Num = Pcnt;
    }

    public static int getPcnt() {
        return Pcnt;
    }

    @Override
    public String toString() {
        return super.toString()+"{" + "depNum=" + depNum + '}';
    }
    
}
