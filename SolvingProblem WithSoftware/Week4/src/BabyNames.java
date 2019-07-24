import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyNames {
    public void totalBirths()
    {
     int bcount=0,gcount=0;
     String gender=null;
     for(CSVRecord rec:new FileResource().getCSVParser(false))
     {
         gender=rec.get(1);
         if(gender.equals("M")) bcount++;
         else gcount++;
     }
     System.out.println("Total births:"+(bcount+gcount)+"\nBoys Count:"+bcount+"\nGirls Count:"+gcount);
    }
    public int getRank(int year,String name,String gender)
    {
        int rank=1;
        for(CSVRecord rec:new FileResource("testing/"+"yob"+year+"short.csv").getCSVParser(false))
        {
            if(rec.get(0).equals(name))
                return rank;
            else if (rec.get(1).equals(gender))
                rank++;
        }
        return -1;
    }
    public String getName(int year,int rank,String gender)
    {
        for(CSVRecord rec:new FileResource("testing/"+"yob"+year+"short.csv").getCSVParser(false))
        {
            if(rec.get(1).equals(gender)&&rank==1)
                return rec.get(0);
            else if (rec.get(1).equals(gender))
                rank--;
        }
        return "NO NAME";
    }
    public void whatIsNameInYear(String name,int year,int newyear,String gender)
    {
        int rank=getRank(year,name,gender);
        String newname=getName(newyear,rank,gender);
        System.out.println(name+"born in "+year+" would be "+newname+" if she was born in "+newyear+".");
    }

    public int yearOfHighestRank(String name,String gender) {
       int res=Integer.MAX_VALUE,rank=0,year=0;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()) {
            rank = getRank(Integer.parseInt(f.getName().substring(3, 7)), name, gender);
            if (res > rank) {
                res = rank;
                year = Integer.parseInt(f.getName().substring(3, 7));
            }
        }
        if(year!=0)
            return  year;
        return -1;
    }

    public double getAverageRank(String name,String gender) {
        double avgrank=0.0;
        int rank=0,count=0;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()) {
            rank= getRank(Integer.parseInt(f.getName().substring(3, 7)), name, gender);
            count++;
            if(rank<0)
                return -1;
            avgrank+=rank;
            }
        return avgrank/count;
    }
    public int getTotalBirthsRankedHigher(int year,String name,String gender)
    {
        int res=0;
        for(CSVRecord rec:new FileResource("testing/"+"yob"+year+"short.csv").getCSVParser(false))
        {
            if(rec.get(0).equals(name))
                break;
            if(rec.get(1).equals(gender))
                res+=Integer.parseInt(rec.get(2));
        }
        return res;
    }
    public static void main(String args[])
    {
        BabyNames obj = new BabyNames();
        //System.out.println(obj.getRank(2012,"Mason","M"));
        //int year=2012,newyear=2014;
        //String name="Isabella",gender="F";
       // obj.whatIsNameInYear(name,year,newyear,gender);
        //System.out.println(obj.yearOfHighestRank("Mason","M"));
        //System.out.println(obj.getAverageRank("Jacob","M"));
        System.out.println(obj.getTotalBirthsRankedHigher(2012,"Ethan","M"));
    }
}
