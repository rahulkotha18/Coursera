public class Part3 {
    public String lastPart(String a , String b)
    {
        int index=-1,len1=a.length(),len2=b.length();
        index=b.indexOf(a);
        if(index<0)
            return b;
        return b.substring(index+len1);
    }

    public boolean twoOccurrences(String a , String b)
    {
        int len1=a.length();
        int len2=b.length();
        int count=0,index=1;
        while(index >=0 && index < len2)
        {
            index=b.indexOf(a,index);
            if(index>=0)
            {
                count++;
                if(count>=2)
                    return true;
            }
            else
                return false;
            index=index+len1;
        }
        return false;
    }
    public void testing()
    {
        String a[]=new String[3];
        String b[]=new String[3];
        a[0]="a";
        a[1]="by";
        a[2]="atg";
        b[0]="banana";
        b[1]="A story by abby long";
        b[2]="ctgtatgta";
        for(int i=0;i<a.length;i++)
        {
            System.out.println("Sring a="+a[i]+"\nString b ="+b[i]);
            System.out.println("Result \t : "+twoOccurrences(a[i],b[i])+"\n");

        }
    }
    public  void test()
    {
        String a[]=new String[3];
        String b[]=new String[3];
        a[0]="an";
        a[1]="by";
        a[2]="zoo";
        b[0]="banana";
        b[1]="A story by abby long";
        b[2]="forest";
        for(int i=0;i<a.length;i++)
        {
            System.out.println("Sring a="+a[i]+"\nString b ="+b[i]);
            System.out.println("Result \t : "+lastPart(a[i],b[i])+"\n");
        }
    }
    public static  void  main(String  args[])
    {
        Part3 obj = new Part3();
        obj.testing();
        obj.test();
    }
}
