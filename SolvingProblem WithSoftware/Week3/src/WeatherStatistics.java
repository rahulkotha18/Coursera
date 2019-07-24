import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class WeatherStatistics {
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord record=null;
        double mintemp=0.0;
        for(CSVRecord cuurentrecord:parser)
        {
            if(record==null) {
                record = cuurentrecord;
                mintemp=Double.parseDouble(record.get("TemperatureF"));
            }
            else
            {
                if(mintemp>Double.parseDouble(cuurentrecord.get("TemperatureF")))
                {
                    if( Double.parseDouble(cuurentrecord.get("TemperatureF"))>=0.0 ) {
                        record = cuurentrecord;
                        mintemp = Double.parseDouble(cuurentrecord.get("TemperatureF"));
                    }
                }
            }
        }
        return record;
    }
    public void testColdestHourInFile()
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        CSVRecord rec=coldestHourInFile(parser);
        System.out.println("Coldest hour is :"+rec.get("TimeEST")+" on "+rec.get("DateUTC")+" and temp is :"+rec.get("TemperatureF"));
    }
    public void testColdestHourInFile(String filename)
    {
        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        CSVRecord rec=coldestHourInFile(parser);
        System.out.println("Coldest hour is :"+rec.get("TimeEST")+" on "+rec.get("DateUTC")+" and temp is :"+rec.get("TemperatureF"));
    }
    public void readCSV(String filename)
    {
        File f= new File(filename);
        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        for(CSVRecord rec:parser)
            System.out.println(rec.get("DateUTC")+"  "+rec.get("TemperatureF"));
    }
    public String fileWithColdestTemperature()
    {
        String coldestfile=null;
        Double mintemp=0.0;
        File mintempfile=null;
        DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            FileResource fr=new FileResource(f);
            CSVRecord currentrecord=coldestHourInFile(fr.getCSVParser());
            if(mintemp==0.0) {
                mintempfile=f;
                mintemp=Double.parseDouble(currentrecord.get("TemperatureF"));
            }
            else
            {
                if(mintemp>Double.parseDouble(currentrecord.get("TemperatureF")))
                {
                    if( Double.parseDouble(currentrecord.get("TemperatureF"))>=0.0 ) {
                        mintempfile=f;
                        mintemp = Double.parseDouble(currentrecord.get("TemperatureF"));
                    }
                }
            }
        }
        coldestfile=mintempfile.toString();
        return coldestfile;
    }
    public void testFileWithColdestTemperature()
    {
        String fname=fileWithColdestTemperature();
        System.out.println(" file with Coldest temperature is :"+fname);
        testColdestHourInFile(fname);
        readCSV(fname);
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        int lowesthumidity=0,tmp=0;
        CSVRecord rec=null;
        for(CSVRecord curr : parser)
        {
            String hum=curr.get("Humidity");
            if(hum.equals("N/A"))
                continue;
            tmp=Integer.parseInt(hum);
            if(rec==null) {
                lowesthumidity=tmp;
                rec=curr;
            }
            else
            {
                if(lowesthumidity>tmp)
                {
                    lowesthumidity=tmp;
                    rec=curr;
                }
            }
        }
        return rec;
    }
    public void testTowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest humity in file found was :"+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
    public CSVRecord lowestHumidityInManyFiles()
    {
        CSVRecord rec=null;
        int lowesthumidity=0,tmp=0;
        String humidity=null;
        DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            FileResource fr=new FileResource(f);
            CSVRecord currentrecord=lowestHumidityInFile(fr.getCSVParser());
            humidity=currentrecord.get("Humidity");
            tmp=Integer.parseInt(humidity);
            if(rec==null) {
                rec=currentrecord;
                lowesthumidity=tmp;
            }
            else
            {
                if(lowesthumidity>tmp)
                {
                    lowesthumidity=tmp;
                    rec=currentrecord;
                }
            }
        }
        return rec;
    }
    public void testLowestHumidityInManyFiles()
    {
        CSVRecord rec=lowestHumidityInManyFiles();
        System.out.println("Lowest humidity was at "+rec.get("Humidity")+" "+rec.get("DateUTC"));
    }
    public double aveargeTemperature(CSVParser parser)
    {
        double avgtemp=0.0;
        String tmp;
        int count=0;
        for(CSVRecord rec:parser)
        {
            tmp=rec.get("TemperatureF");
            if(Double.parseDouble(tmp)>=0)
            {
                count++;
                avgtemp+=Double.parseDouble(tmp);
            }
        }
        return avgtemp/count;
    }
    public void testAverageTemperature()
    {
        FileResource fr = new FileResource();
        System.out.println("Average temperature in file is  "+aveargeTemperature(fr.getCSVParser()));
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value)
    {
        double res=0.0;
        int count=0;
        String tmp=null;
        String humidity=null;
        for(CSVRecord rec:parser)
        {
            humidity=rec.get("Humidity");
            if(humidity.equals("N/A"))
                continue;
            else
            {
                tmp=rec.get("TemperatureF");
                if(Integer.parseInt(humidity)>value)
                {
                    if(Double.parseDouble(tmp)>=0)
                    {
                        count++;
                        res+=Double.parseDouble(tmp);
                    }
                }
            }
        }
        return res/count;
    }
    public  void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr= new FileResource();
        System.out.println("Average Temp when high Humidity is "+averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80));
    }
    public static  void main(String args[])
    {
        WeatherStatistics obj = new WeatherStatistics();
        obj.testColdestHourInFile();
        obj.testFileWithColdestTemperature();
        obj.testTowestHumidityInFile();
        obj.testLowestHumidityInManyFiles();
        obj.testAverageTemperature();
        obj.testAverageTemperatureWithHighHumidityInFile();
    }
}
