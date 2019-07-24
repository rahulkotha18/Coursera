public class Part2 {
    public String findSimpleGene(String dna,String startcodon , String stopcodon)
    {
        String res="";
        int firstindex=dna.indexOf(startcodon);
        if(firstindex==-1)
            return res;
        int lastindex=dna.indexOf(stopcodon,firstindex+3);
        if(lastindex==-1)
            return res;
        int genlength=(lastindex+3)-firstindex;
        if(genlength%3==0)
        {
            res=dna.substring(firstindex,lastindex+3);
            return res;
        }
        return res;
    }
    public void testSimpleGene()
    {
        String startcodon="ATG";
        String stopcodon="TAA";
        String ex[]=new String[5];
        ex[0]="RAFGFHGSFHGF";
        ex[1]="adfdfatgrahulktaagfgd";
        ex[4]="ATGAACAAGGGATAA";
        ex[3]="HFGDGFFFFFFFATGAATTFAATTAAHJG";
        ex[2]="GGATGLHLKGKYGKHL";
        for(int i=0;i<ex.length;i++) {
            System.out.println("DNA String : " + ex[i]);
            if(Character.isLowerCase(ex[i].charAt(0)))
            {
                System.out.println("Gene Found : " + findSimpleGene(ex[i],startcodon.toLowerCase(),stopcodon.toLowerCase()));
            }
            else
                System.out.println("Gene Found : " + findSimpleGene(ex[i],startcodon,stopcodon));
        }
    }
    public static  void main(String args[])
    {
        Part2 obj= new Part2();
        obj.testSimpleGene();
    }
}
