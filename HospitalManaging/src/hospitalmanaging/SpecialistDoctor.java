package hospitalmanaging;

public class SpecialistDoctor extends Doctor {
    int salary;
    
    public SpecialistDoctor(int Salary, int depNum, String Name, String Address, Date dateOfBirth) {
        super(depNum, Name, Address, dateOfBirth);
        this.salary = Salary;
        this.type=1;
    }

    public int getDepNum() {
        return depNum;
    }

    public void setDepNum(int depNum) {
        this.depNum = depNum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+"SpecialistDoctor{" + "salary=" + salary + '}';
    }
    

    
}
