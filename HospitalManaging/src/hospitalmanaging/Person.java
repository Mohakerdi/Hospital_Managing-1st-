package hospitalmanaging;

public abstract class Person {
    int Num;
    String Name;
    String Address;
    Date dateOfBirth;

    public Person(String Name, String Address, Date dateOfBirth) {
        this.Name = Name;
        this.Address = Address;
        this.dateOfBirth = dateOfBirth;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "{" + "Num=" + Num + ", Name=" + Name + ", Address=" + Address + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
    
}
