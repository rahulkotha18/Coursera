package week1;
import edu.duke.FileResource;
public class NewCeasarCipherTwo
{
    private String alphabet;
    private String shiftedalphabetkey1;
    private String shiftedalphabetkey2;
    private int key1;
    private int key2;
    NewCeasarCipherTwo(int key1,int key2)
    {
        this.key1=key1;
        this.key2=key2;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedalphabetkey1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedalphabetkey2=alphabet.substring(key2)+alphabet.substring(0,key2);
    }
    public String encrypt(String input,int key)
    {
        NewCeasarCipher cc= new NewCeasarCipher(key);
        return  cc.encrypt(input);
    }
}
    class TestCeasarCipherTwo
    {
        public int[] countLetters(String str)
        {
            int count[]=new int[26];
            for(int i=0;i<str.length();i++)
            {
                if(Character.isLetter(str.charAt(i)))
                {
                    int index=(int)str.charAt(i)-65;
                    count[index]+=1;
                }
            }
            return  count;
        }
        public int maxIndex(int []count)
        {
            int maxindex=-1,value=0;
            for(int i=0;i<count.length;i++)
            {
                if(value<count[i])
                {
                    value=count[i];
                    maxindex=i;
                }
            }
            return  maxindex;
        }
        public int getKey(String str)
        {
            int []count=countLetters(str);
            int maxindex=maxIndex(count);
            int key=maxindex-4;
            if(key<0)
                key=key+26;
            return key;
        }
        public String halfOfString(String msg,int start)
        {
            StringBuilder sb= new StringBuilder();
            for(int i=start;i<msg.length();i+=2)
            {
                sb.append(msg.charAt(i));
            }
            return sb.toString();
        }
        public void sinpleTests()
        {
            int key1=2,key2=5;
            NewCeasarCipherTwo obj=new NewCeasarCipherTwo(key1,key2);
            FileResource fr=new FileResource();
            String input=fr.asString();
            String input1=halfOfString(input,0);
            String input2=halfOfString(input,1);
            String msg1=obj.encrypt(input1,key1);
            String msg2=obj.encrypt(input2,key2);
//            System.out.println(input);
//            System.out.println("part 1:"+msg1);
//            System.out.println("part 2:"+msg2);
            msg1= breakCeasarCipher(msg1,1);
            msg2= breakCeasarCipher(msg2,2);
            System.out.println(join(msg1,msg2));
        }
        public String breakCeasarCipher(String input,int i)
        {
            int key=getKey(input);
            NewCeasarCipher cc=new NewCeasarCipher(key);
            System.out.println("Key "+i+" :"+key);
            return cc.decrypt(input);
        }
        public String join(String a,String b)
        {
            int i=0;
            StringBuilder sb=new StringBuilder();
            for(;i<b.length();i++)
            {
                sb.append(a.charAt(i));
                sb.append(b.charAt(i));
            }
            if(i<a.length())
                sb.append(a.charAt(i));
            return  sb.toString();
        }
        public static void main(String args[])
        {
            TestCeasarCipherTwo obj = new TestCeasarCipherTwo();
            obj.sinpleTests();
        }
    }