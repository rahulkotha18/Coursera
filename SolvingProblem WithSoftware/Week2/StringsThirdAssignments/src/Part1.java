import edu.duke.StorageResource;
public class Part1 {
    public int findStopIndex(int startindex,String dna , String stopcodon)
    {
        int len=dna.length(),len1=stopcodon.length();
        int stopindex=0,st=startindex;
        while(startindex<len)
        {
            stopindex=dna.indexOf(stopcodon,startindex);
            if(stopindex==-1)
                return len;
            if( (stopindex-st) % 3 ==0)
                return stopindex;
            else
            {
                startindex=stopindex+len1;
            }
        }
        return len;
    }
    public String findGene(String dna)
    {
        int start_ATG=dna.indexOf("ATG");
        if(start_ATG==-1)
            return "";
        int closest=0,len=dna.length();
        int stop_TAA=findStopIndex(start_ATG,dna,"TAA");
        int stop_TAG=findStopIndex(start_ATG,dna,"TAG");
        int stop_TGA=findStopIndex(start_ATG,dna,"TGA");
        closest=(stop_TAA<stop_TAG)?((stop_TAA<stop_TGA)?stop_TAA:stop_TGA):(stop_TAG<stop_TGA)?stop_TAG:stop_TGA;
        if(closest==len) {
            return "";
        }
        return dna.substring(start_ATG,closest+3);
    }
    public StorageResource printAllGenes(String dna)
    {
        StorageResource sr=new StorageResource();
        while(true)
        {
            String currgene=findGene(dna);
            if(currgene.equals(""))
                break;
            else
                sr.add(currgene);
            dna=dna.substring(dna.indexOf(currgene)+currgene.length());
        }
        return sr;
    }
    public  void  iterateStorageResource(StorageResource sr)
    {
        for(String s: sr.data())
            System.out.println(s);
    }
    public static  void main(String args[])
    {
        Part1 obj=new Part1();
        String dna="ATDATGTTFTTDTAAFGGATGTYUYUOTGAHGHGFATGGHJJHGTAG";
        System.out.println("DNA : "+dna);
        System.out.println("gene are :");
        StorageResource sr=obj.printAllGenes(dna);
        obj.iterateStorageResource(sr);
    }
}