public class Part1
{
    public String findSimpleGene(String dna)
    {
        String res="";
        int firstindex=dna.indexOf("ATG");
        if(firstindex==-1)
            return res;
        int lastindex=dna.indexOf("TAA",firstindex+3);
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
        String ex[]=new String[5];
        ex[0]="RAFGFHGSFHGF";
        ex[1]="GGATGLHLKGKYGKHL";
        ex[2]="ATGAACAAGGGATAA";
        ex[3]="HFGDGFFFFFFFATGAATTFAATTAAHJG";
        ex[4]="JHGATGHGFHGFHGFGHATAARAHUL";
        for(int i=0;i<ex.length;i++) {
            System.out.println("DNA String : " + ex[i]);
            System.out.println("Gene Found : " + findSimpleGene(ex[i]));
        }
    }
    public static  void main(String args[])
    {
        Part1 obj= new Part1();
        obj.testSimpleGene();
    }
}
