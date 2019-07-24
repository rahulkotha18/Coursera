public class Part2 {
    public float printCGRatio(String dna)
    {
        int C_count=0;
        int G_count=0;
        char ch='A';
        for(int i=0;i<dna.length();i++)
        {
            ch=dna.charAt(i);
            if(ch=='C')
                C_count++;
            else if(ch=='G')
                G_count++;
            else;
        }
        return (float)C_count/G_count;
    }
    public  int countCTG(String dna)
    {
        int count=0,index=0;
        String temp="CTG";
        int len=temp.length();
        while(true)
        {
            index=dna.indexOf(temp,index+len);
            if(index>=0)
                count++;
            else
                break;
        }
        return count;
    }
    public static  void main(String args[])
    {
        Part2 obj = new Part2();
        String dna ="ADFDGFDSXFDRCTGCGCDFHGGCTGCTGCHCCCTGHCCCCCHCG";
        System.out.println("C/G ratio    :"+obj.printCGRatio(dna));
        System.out.println("CTG found at :"+obj.countCTG(dna)+" times");
    }
}
