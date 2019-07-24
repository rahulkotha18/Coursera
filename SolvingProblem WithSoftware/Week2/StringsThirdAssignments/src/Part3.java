import edu.duke.StorageResource;
public class Part3 {
    public void  processGenes(StorageResource sr)
    {
        int count=0,CGcount=0;
        Part2 obj = new Part2();
        for(String s:sr.data()) {
            if (s.length() > 9) {
                System.out.println("length greater than 9 in this String  ::  "+s);
                count++;
            }
            if(obj.printCGRatio(s)>0.35)
            {
                System.out.println("C/G greater than .35 in this String   ::  "+s);
                CGcount++;
            }

        }
        System.out.println("Number of strings with length greater than 9 are:"+count);
        System.out.println("Number of strings with C/G ratio greater than .35 are:"+CGcount);
    }
    public static  void main(String args[])
    {
        Part1 obj=new Part1();
        String dna="ATDATGTTFTTDTAAFGGATGTGAHGHGFATGCTCFCHYHJCHJJHGTAG";
        System.out.println("DNA : "+dna);
        System.out.println("gene are :");
        StorageResource sr=obj.printAllGenes(dna);
        Part3 obj1=new Part3();
        obj1.processGenes(sr);
    }
}
