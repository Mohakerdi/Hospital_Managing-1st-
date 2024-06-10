package hospitalmanaging;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Scanner;

public class HospitalManaging{
        
    static Date today = new Date(7, 6, 2024);
    
   // Doctors & Patients Lists------------------------------------
    static ArrayList<Doctor> drs = new ArrayList();          //---
    static ArrayList<Pateint> patients = new ArrayList();    //---
   //-------------------------------------------------------------

    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("-----Welcome To Hospital Managment System-----");
        while(true){   
            System.out.println("exit: 'q' || add: 'a' || delete: 'd' ");
            System.out.println("fix: 'f' || count: 'c' || info: 'i'");
            System.out.println("release patient: 'r'");
            char input = in.next().charAt(0);
            if(input == 'q'){
                System.out.println("Closing System");
                return;
            }
            func(input);
        }
    }
    
    public static void func(char i){
        switch (i) {
            case 'a':{
                System.out.println("What do you want to add?");
                System.out.println("Doctor log: 'd' | Patient Log: 'p' | Treatment: 't'");
                add();
                break;}
            
            case 'd':{
                System.out.println("Delete doctor log");
                delete();
                break;}
            
            case 'f':{fix();break;}
            
            case 'c':{count();break;}
            
            case 'i':{info();break;}
            
            case 'r':{release();break;}
            
            default:System.out.println("WRONG INPUT");break;
        }
    }
    
    public static void add(){
        String nm;String ad;int y;int d;int m;Date bd;int dn;
        char input = in.next().charAt(0);
        switch (input) {
            case 'd':
                System.out.println("Name:...");
                in.nextLine();nm =in.nextLine();
                System.out.println("Address:...");
                ad = in.next();
                System.out.println("Date Of Birth:");d = in.nextInt();m = in.nextInt();y = in.nextInt();
                bd =  new Date(d, m, y);
                if(Date.isOk(bd)==false){System.out.println("Bad input!!!"); return;}  
                System.out.println("Beggining date:"); d = in.nextInt(); m = in.nextInt(); y = in.nextInt();
                Date Begin = new Date(d, m, y);
                if(Date.isOk(Begin)==false){System.out.println("Bad input!!!"); return;}  
                System.out.println("Enter if contracted 'c', fixed 'f'or intern 'i':");
                char ch = in.next().charAt(0);
                switch(ch){
                    case 'c':
                        System.out.println("(Clinics) Gastrointestinal'5' | Ophthal '6' | Internal '7' :...");dn = in.nextInt();
                        ContractedDoctor doc1 = new ContractedDoctor(dn, nm, ad, bd, Begin);
                        drs.add(doc1);
                        System.out.println("Doctor was added succesfully!\nhis serial number is: "+doc1.Num);
                        break;
                    case'f':
                        System.out.println("(Departments) Ophthal'1' | Surgery '2' | Thoracic '3'| Ambulance'4' ");dn = in.nextInt();
                        System.out.println("Enter Salary:");int s1 = in.nextInt();
                        SpecialistDoctor doc2 = new SpecialistDoctor(s1, dn, nm, ad, bd);
                        drs.add(doc2); 
                        System.out.println("Doctor was added succesfully!\nhis serial number is: "+doc2.Num);
                        break;
                    case'i':
                        System.out.println("(Departments) Ophthal'1' | Surgery '2' | Thoracic '3'| Ambulance'4' ");dn = in.nextInt();
                        System.out.println("Enter Salary:");int s2 = in.nextInt();
                        int yearsOfExp = Date.dif(Begin, today);
                        if(yearsOfExp < 1){s2 /= 2;}//50%
                        else{s2 = (s2*3)/4;}//75%
                        InternDoctor doc3 = new InternDoctor(s2, dn, nm, ad, bd, Begin, today);
                        drs.add(doc3);
                        System.out.println("Doctor was added succesfully!\nhis serial number is: "+doc3.Num);
                        break;
                }
                break;
                
            case 'p':
                int dep;
                System.out.println("Name:...");
                in.nextLine();/*Extra one to consume leftover line*/nm =in.nextLine();
                System.out.println("Address:...");
                ad = in.next();
                System.out.println("Date Of Birth:");d = in.nextInt();m = in.nextInt();y = in.nextInt();
                bd = new Date(d, m, y);
                if(Date.isOk(bd)==false){System.out.println("Bad input!!!"); return;}  
                System.out.println("Enter if inner'i' or outer pateint'o':");
                char type = in.next().charAt(0);
                if(type=='i'){
                    System.out.println("(Departments) Ophthal'1' | Surgery '2' | Thoracic '3'| Ambulance'4' ");dep = in.nextInt();
                    InnerPatient p1 = new InnerPatient(nm, ad, bd);patients.add(p1);
                    p1.setDepNum(dep);
                }
                else if (type=='o'){
                    System.out.println("(Clinics) Gastrointestinal'5' | Ophthal '6' | Internal '7' :...");dep = in.nextInt();
                    OuterPatient p2 = new OuterPatient(nm, ad ,bd);patients.add(p2);
                    p2.setDepNum(dep);
                }
                System.out.println("Patient was added succesfully!");
                System.out.println("His seriel number is: "+Pateint.getPcnt());
                break;
            case 't':
                int cost;
                System.out.println("Enter the date of the treatment(day/month/year):");d = in.nextInt();m = in.nextInt();y = in.nextInt();
                Date tDate = new Date(d,m,y);
                if(Date.isOk(tDate)==false){System.out.println("Bad input!!!"); return;}  
                System.out.println("Enter the cost:");cost = in.nextInt();
                System.out.println("give me the seriel number of the patient:");
                int n = in.nextInt();
                for(int i=0; i<patients.size() ;i++){
                    if(patients.get(i).Num == n){
                        if(patients.get(i).depNum<=4){
                            System.out.println("Enter the department number:");
                            System.out.println("(Departments) Ophthal'1' | Surgery '2' | Thoracic '3'| Ambulance'4' ");
                            System.out.println("(Clinics) Gastrointestinal'5' | Ophthal '6' | Internal '7' :...");
                            dn = in.nextInt();
                            if(dn>=1 && dn <=4){
                                ArrayList<Doctor> doctors =new ArrayList();
                                System.out.println("Enter the serial numbers of engaged doctors(type '0' when stop):");
                                for(int j=0; j<drs.size() ;j++){
                                    int drNum = in.nextInt();
                                    if(drNum==0) break;
                                    else if(drs.get(j).Num == drNum){
                                        doctors.add(drs.get(j));
                                        System.out.println("Doctor added sucessfully!");
                                    }
                                }
                                ITL log = new ITL(dn, doctors, tDate, cost);
                                ((InnerPatient) patients.get(i)).InnerLogs.add(log);
                            }
                            else if(dn>=5 && dn <=7){
                                Doctor x = null;
                                System.out.println("Enter the serial number of engaged doctor:");
                                int drNum = in.nextInt();
                                for(int j=0; j<drs.size() ;j++){
                                    if(drs.get(j).Num == n)
                                        x = drs.get(j);
                                }
                                if(x.type == 2){
                                    OTL log = new OTL(dn, x, tDate, cost);
                                    ((InnerPatient) patients.get(i)).OuterLogs.add(log);
                                    ((ContractedDoctor) x).addProfites(cost/2);
                                }
                                else{
                                    System.out.println("Not a contracted doctor!!!");return;
                                }
                            }
                        }
                        else if(patients.get(i).depNum<=7){
                            System.out.println("Enter the department number:");
                            System.out.println("(Clinics) Gastrointestinal'5' | Ophthal '6' | Internal '7' :...");dn = in.nextInt();
                            Doctor x = null;
                            System.out.println("Enter the serial number of engaged doctor:");
                            int drNum = in.nextInt();
                            for(int j=0; j<drs.size() ;j++){
                                if(drs.get(j).Num == drNum)
                                    x = drs.get(j);
                            }
                            if(x.type == 2){
                                OTL log = new OTL(dn, x, tDate, cost);
                                ((InnerPatient) patients.get(i)).OuterLogs.add(log);
                                ((ContractedDoctor) x).addProfites(cost/2);
                            }
                            else{
                                System.out.println("Not a contracted doctor!!!");return;
                            }
                        }
                        System.out.println("Treatment was addded");
                    return;
                    }
                }
                System.out.println("Out of range!!!");
                break;
                
            default:System.out.println("WRONG INPUT!!!");break;
        }
    }
    public static void delete(){
        System.out.println("give me the serial number of the doctor you want to delete");
        int n = in.nextInt();
        for(int i=0; i<drs.size() ;i++){
            if(drs.get(i).Num == n){
                System.out.println("Dctor was removed sucessfully");
                drs.remove(drs.get(i));
                return;
            }
        }
        System.out.println("Out of range!!!");
    }
    public static void fix(){
        System.out.println("give me the serial number of the doctor you want to fix");
        int n = in.nextInt();
        if(n>drs.size()){
            System.out.println("Out of range!!!");
        }
        else{
            for(int i=0; i<drs.size() ;i++){
                if(drs.get(i).Num == n){
                    if(drs.get(i).type==3){
                        if(((InternDoctor) drs.get(i)).IsFixed())
                            System.out.println("Doctor is Fixed already!");
                        else{
                            ((InternDoctor) drs.get(i)).setIsFixed(true);
                            System.out.println("Doctor was fixed succesfully");
                        }
                    }
                    else
                        System.out.println("He is not an intern!!!");
                }
            }
        }
    }
    public static void count(){
        System.out.println("What do you want to count?");
        System.out.println("Contracted Doctors: 'd' | All Doctors: 'D'");
        System.out.println("Pateints in a clinic or department: 'p' | All Pateints : 'P'");
        char input = in.next().charAt(0);
        switch (input) {
            case 'd':
                int contractedCnt=0;
                for(int i=0; i<drs.size() ;i++){
                    if(drs.get(i).isContracted)
                        contractedCnt++;
                }
                System.out.println("The number of contracted doctors is: "+(contractedCnt));
                break;
                
            case 'D':
                System.out.println("The number of doctors is: ");
                System.out.println(drs.size());
                break;
                
            case 'p':
                int dep;int cnt = 0;
                System.out.println("Enter department number(1 -> 7)");
                System.out.println("(Departments) Ophthal'1' | Surgery '2' | Thoracic '3'| Ambulance'4' ");
                System.out.println("(Clinics) Gastrointestinal'5' | Ophthal '6' | Internal '7' :...");
                dep = in.nextInt();
                for(int i=0; i<patients.size() ;i++){
                    if(patients.get(i).depNum == dep) cnt++;
                }
                System.out.println("The number of patients is : "+cnt);
                break;
                
            case 'P':
                System.out.println("The number of patients is: ");
                System.out.println(patients.size());
                break;
            default:System.out.println("WRONG INPUT!!!");break;
        }
    }
    public static void info(){
        System.out.println("What do you want to see details about?");
        System.out.println("All Doctors: 'D' | All Tretments (pateint):'T'");
        System.out.println("All Patients: 'P'");
        char input = in.next().charAt(0);
        System.out.println("========================================");
            switch (input) {
            case 'T':
                System.out.println("Enter the serial number of the patient:");int n=in.nextInt();
                for(int i=0; i<patients.size() ;i++){
                    if(patients.get(i).Num == n){
                        if(patients.get(i).depNum <= 4){
                            ArrayList<ITL> iLogs = ((InnerPatient) patients.get(i)).getInnerLogs();
                            ArrayList<OTL> oLogs = ((InnerPatient) patients.get(i)).getOuterLogs();
                            for(ITL x: iLogs){System.out.println(x.toString());}
                            for(OTL x: oLogs){System.out.println(x.toString());}
                            break;
                        }
                        else if(patients.get(i).depNum <= 7){
                            ArrayList<OTL> oLogs = ((OuterPatient) patients.get(i)).getOuterLogs();
                            for(OTL x: oLogs){System.out.println(x.toString());}
                            break;
                        }
                    }
                }
                System.out.println("========================================");                
                break;
            case 'D':
                for(int i=0; i<drs.size() ;i++){
                    System.out.println(drs.get(i).toString());
                    System.out.println("========================================");
                }
                
                break;
        
            case 'P':
                for(int j=0;j<patients.size(); j++){
                    if(patients.get(j).depNum <= 4){
                        System.out.println(((InnerPatient) patients.get(j)).toString());
                    }
                    else if(patients.get(j).depNum <= 7){
                        System.out.println(((OuterPatient) patients.get(j)).toString());
                    }
                    System.out.println("========================================");
                }
                
                break;
        
            default:System.out.println("WRONG INPUT!!!");break;
        }
    }
    public static void release(){
        System.out.println("give me the serial number of the pateint you want to release(Inner Patient): ");
        int pnum= in.nextInt();
        for(int i=0; i<patients.size() ;i++){
            if(patients.get(i).Num == pnum){
                ((InnerPatient) patients.get(i)).isReleased = true;
                System.out.println("Patient was released succesfully");
                return;
            }
        }
        System.out.println("Out of range!!!");
    }

//FILLING THE ARRAYLISTS------------------------------------------------------------------------------------------------------------------------------------------
static{
    InternDoctor dr1 = new InternDoctor(3000, 3, "Ahmad Kerdi", "Syria/Damascus", Date.setDate(5, 4, 2000), Date.setDate(15, 3, 2020), Date.setDate(15, 4, 2024));
    InternDoctor dr2 = new InternDoctor(3500, 2, "Malek Arab", "Syria/Daraa", Date.setDate(9, 11, 1999), Date.setDate(6, 3, 2022), Date.setDate(5, 4, 2023));
    InternDoctor dr3 = new InternDoctor(4000, 4, "Yamen Ali", "Syria/Damascus", Date.setDate(16, 3, 2001), Date.setDate(15, 3, 2021), Date.setDate(15, 4, 2024));
    ContractedDoctor dr4 = new ContractedDoctor(5, "Manar Abdo", "Syria/Daraa", Date.setDate(26, 5, 1992), Date.setDate(10, 10, 2015));
    ContractedDoctor dr5 = new ContractedDoctor(6, "Mazen Ashqar", "Syria/Homs", Date.setDate(6, 10, 1987), Date.setDate(17, 1, 2017));
    ContractedDoctor dr6 = new ContractedDoctor(7, "Yara Rayyes", "Syria/Damascus", Date.setDate(4, 7, 1996), Date.setDate(2, 4, 2019));
    ContractedDoctor dr7 = new ContractedDoctor(7, "Sama Sandouk", "Syria/Damascus", Date.setDate(24, 5, 1992), Date.setDate(8, 4, 2016));
    SpecialistDoctor dr8 = new SpecialistDoctor(6000, 1, "Ahmad Youcef", "Syria/Damascus", Date.setDate(15, 4, 1980));
    SpecialistDoctor dr9 = new SpecialistDoctor(6500, 1, "Amal AlKhateeb", "Syria/Damascus", Date.setDate(13, 9, 1988));
    SpecialistDoctor dr10 = new SpecialistDoctor(7500, 2, "Anas Alloush", "Syria/Daraa", Date.setDate(27, 6, 1975));
    SpecialistDoctor dr11 = new SpecialistDoctor(7000, 2, "Kareem Alaswad", "Syria/Damascus", Date.setDate(1, 1, 1971));
    SpecialistDoctor dr12 = new SpecialistDoctor(6500, 2, "Marwa Haddad", "Syria/Damascus", Date.setDate(12, 7, 1990));
    SpecialistDoctor dr13 = new SpecialistDoctor(8500, 3, "Nuha Haddad", "Syria/Damascus", Date.setDate(2, 5, 1960));
    SpecialistDoctor dr14 = new SpecialistDoctor(6500, 3, "Kamal Shareef", "Syria/Damascus", Date.setDate(19, 6, 1984));
    SpecialistDoctor dr15 = new SpecialistDoctor(7000, 4, "Yasser Aallam", "Syria/Homs", Date.setDate(8, 8, 1989));
    SpecialistDoctor dr16 = new SpecialistDoctor(6000, 4, "Ghazal Mohammad", "Syria/Damascus", Date.setDate(18, 11, 1996));
    drs.addAll(asList(dr1, dr2, dr3, dr4, dr5, dr6, dr7, dr8, dr9, dr10, dr11, dr12, dr13, dr14, dr15, dr16));
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------
    InnerPatient p1 = new InnerPatient("Baraa AlAli", "Syria/Latakia", Date.setDate(5, 8, 2000));           p1.setDepNum(1);
    InnerPatient p2 = new InnerPatient("Rama Khalaf", "Syria/AlHasaka", Date.setDate(15, 2, 1995));         p2.setDepNum(1);
    InnerPatient p3 = new InnerPatient("Majed AlNaeemat", "Jordan/AlZarqaa'", Date.setDate(3, 11, 1993));   p3.setDepNum(2);
    InnerPatient p4 = new InnerPatient("Gabriel Eid", "Syria/Damascus", Date.setDate(22, 9, 1996));         p4.setDepNum(2);
    InnerPatient p5 = new InnerPatient("Saleh Rasheed", "Egypt/Cairo", Date.setDate(14, 1, 1985));          p5.setDepNum(3);
    InnerPatient p6 = new InnerPatient("Hayat Najem", "Syria/Hamah", Date.setDate(7, 11, 1975));            p6.setDepNum(3);
    InnerPatient p7 = new InnerPatient("Boshra Marta", "Syria/Homs", Date.setDate(29, 5, 1977));            p7.setDepNum(4);
    OuterPatient p8 = new OuterPatient("Kareen Ahmad", "Syria/Tartous", Date.setDate(25, 7, 2002));         p8.setDepNum(5);
    OuterPatient p9 = new OuterPatient("Hamza AlHaj", "Syria/Daraa", Date.setDate(1, 1, 1967));             p9.setDepNum(6);
    OuterPatient p10 = new OuterPatient("Ghazi Mounir", "Jordan/Amman", Date.setDate(1, 6, 1989));          p10.setDepNum(6);
    OuterPatient p11 = new OuterPatient("Mahmoud AlHelo", "Syria/Damascus", Date.setDate(9, 9, 1963));      p11.setDepNum(7);
    OuterPatient p12 = new OuterPatient("Yaman AlHalak", "Syria/Aleppo", Date.setDate(16, 1, 2007));        p12.setDepNum(7);
    OuterPatient p13 = new OuterPatient("Qusay Najjar", "Syria/Damascus", Date.setDate(6,4,1983));          p13.setDepNum(7);
    patients.addAll(asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13));
    //----------------------------------------------------------------------------------------------------------------------------------------------------
}
}
