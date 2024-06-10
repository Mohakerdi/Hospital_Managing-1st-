package hospitalmanaging;

public class InternDoctor extends Doctor {
    int salary;
    Date beginDate;
    Date endDate;
    boolean isFixed = false;

    public boolean IsFixed() {
        return isFixed;
    }

    public void setIsFixed(boolean isFixed) {
        this.isFixed = isFixed;
        salary = (salary*4)/3;
    }

    public InternDoctor(int salary,int depNum, String Name, String Address, Date dateOfBirth, Date beginDate, Date endDate) {
        super(depNum, Name, Address, dateOfBirth);
        this.salary = salary;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.type=3;
    }

    public int getSalary() {
        return salary;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return super.toString()+"InternDoctor{" + "salary=" + salary + ", beginDate=" + beginDate + ", endDate=" + endDate + ", isFixed=" + isFixed + '}';
    }
    
    
    
}
