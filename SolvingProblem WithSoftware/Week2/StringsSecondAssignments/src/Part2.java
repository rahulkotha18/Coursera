import  java.util.Scanner;
public class Part2 {
    public int howMany(String a, String b)
    {
        if(a.equals(""))
            return 0;
        int len1=a.length();
        int len2=b.length();
        int count=0,index=1;
        while(index >=0 && index < len2)
        {
            index=b.indexOf(a,index);
            if(index>=0)
                count++;
            else
                break;
            index=index+len1;
        }
        return  count;
    }
    public  void testHowMany()
    {
        String a="";
        String b="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a and b in new lines:");
        a=sc.nextLine();
        b=sc.nextLine();
        System.out.println(howMany(a,b));
    }
    public static  void main(String qr[])
    {
        Part2 obj = new Part2();
        obj.testHowMany();
    }
}
