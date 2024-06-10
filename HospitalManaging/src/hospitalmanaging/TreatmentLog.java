package hospitalmanaging;

public abstract class TreatmentLog {
    private static int n=1;
    int tLogNum;
    Date date;
    int cost;

    public TreatmentLog(Date date, int cost) {
        this.tLogNum = n;
        this.date = date;
        this.cost = cost;
        n++;
    }

    public int gettLogNum() {
        return tLogNum;
    }

    public void settLogNum(int tLogNum) {
        this.tLogNum = tLogNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{" + "tLogNum=" + tLogNum + ", date=" + date + ", cost=" + cost + '}';
    }
    
    
    
}
