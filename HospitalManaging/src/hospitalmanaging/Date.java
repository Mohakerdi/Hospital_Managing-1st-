package hospitalmanaging;

public class Date {

    static int dif(Date bgn, Date end) {
        int dify = end.y - bgn.y;
        int difm = end.m - bgn.m;
        if(end.d - bgn.d < 0)
            difm-=1;
        if(difm < 0)
            dify-=1;
        return dify;
    }
    int d, m, y;
    
    public Date(){}
    
    public Date(int d,int m, int y) {
        if(d>0 && d<32) this.d = d;
        if(m>0 && m<13) this.m = m;
        if(y>1940 && y<2025 )this.y = y;
    }
    public static Date setDate(int d, int m, int y){
        Date dt = new Date(d, m, y);
        return dt;
    }
    public static boolean isOk(Date date){
        if(date.d == 0 || date.m == 0 || date.y == 0)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return d+"/"+m+"/"+y;
    }
    
}
