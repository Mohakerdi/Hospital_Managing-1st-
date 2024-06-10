package hospitalmanaging;

public class ContractedDoctor extends Doctor {
    int profites;
    Date contractDate;
    
    public ContractedDoctor(int depNum, String Name, String Address, Date dateOfBirth, Date contractDate) {
        super(depNum, Name, Address, dateOfBirth);
        this.isContracted= true;
        this.contractDate = contractDate;
        this.type=2;
    }   

    public int getProfites() {
        return profites;
    }

    public void addProfites(int profites) {
        this.profites += profites;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Override
    public String toString() {
        return super.toString()+"ContractedDoctor{" + "profites=" + profites + ", contractDate=" + contractDate + '}';
    }
    
    
}
