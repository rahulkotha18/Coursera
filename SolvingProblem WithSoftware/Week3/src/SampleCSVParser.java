import edu.duke.*;
import org.apache.commons.csv.*;
public class SampleCSVParser {
    public CSVParser tester() {
        FileResource fr= new FileResource();
        CSVParser parser=fr.getCSVParser();
        return parser;
    }
    public String countryInfo(CSVParser parser,String country){
        String res="NOT FOUND";
        for(CSVRecord record:parser)
        {
            String countries=record.get("Country");
            if(countries.contains(country))
            {
                String exports=record.get("Exports");
                String value=record.get("Value (dollars)");
                res=country+":"+exports+":"+value;
                break;
            }
            else
                ;
        }
        return res;
    }
    public  void listExportersTwoProducts(CSVParser parser,String exportitem1,String exportitem2){
        for(CSVRecord record:parser) {
        String exports=record.get("Exports");
        if(exports.contains(exportitem1) && exports.contains(exportitem2))
            System.out.println(record.get("Country"));
        }
    }
    public int numberOfExporters(CSVParser parser,String exportitem)
    {
        int count=0;
        for(CSVRecord record:parser) {
            String exports=record.get("Exports");
            if(exports.contains(exportitem))
                count++;
        }
        return count;
    }
    public void bigExporters(CSVParser parser,String amount)
    {
        int l1=amount.length();
        for(CSVRecord record:parser) {
            String amt=record.get("Value (dollars)");
            int l2=amt.length();
            if(l2>l1)
                System.out.println(record.get("Country")+"  "+amt);
        }
    }
    public static void main(String args[]) {
        SampleCSVParser obj = new SampleCSVParser();
        CSVParser parser = obj.tester();
        String country = "Peru";
        System.out.println(obj.countryInfo(parser, country));
        parser = obj.tester();
        obj.listExportersTwoProducts(parser, "machinery", "chemicals");
        parser = obj.tester();
        System.out.println("number of countries exporting gold are:" + obj.numberOfExporters(parser, "gold"));
        parser = obj.tester();
        obj.bigExporters(parser,"$999,999,999");
    }
}
