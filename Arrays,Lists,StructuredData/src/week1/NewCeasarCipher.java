package week1;
import edu.duke.FileResource;
public class NewCeasarCipher
{
    private String alphabet;
    private String shiftedalphabet;
    private int mainkey;
    NewCeasarCipher(int key)
    {
        mainkey=key;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedalphabet=alphabet.substring(key)+alphabet.substring(0,key);
    }
    public String encrypt(String input)
    {
        StringBuilder sb=new StringBuilder(input);
        char ch=sb.charAt(0),newchar='a';
        int index=0;
        for(int i=0;i<sb.length();i++)
        {
            ch=sb.charAt(i);
            index=alphabet.indexOf(ch);
            if(index>=0)
            {
                newchar=shiftedalphabet.charAt(index);
                sb.setCharAt(i,newchar);
            }
        }
        return sb.toString();
    }
    public String decrypt(String input)
    {
        NewCeasarCipher cc= new NewCeasarCipher(26-mainkey);
        return cc.encrypt(input);
    }
}
class TestCeasarCipher
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
    public void sinpleTests()
    {
        NewCeasarCipher obj=new NewCeasarCipher(18);
        FileResource fr=new FileResource();
        String input=fr.asString();
        String msg=obj.encrypt(input);
        breakCeasarCipher(msg);
    }
    public void breakCeasarCipher(String input)
    {
        int key=getKey(input);
        NewCeasarCipher cc=new NewCeasarCipher(key);
        System.out.println("Key : "+key);
        System.out.println(cc.decrypt(input));
    }
    public static void main(String args[])
    {
        TestCeasarCipher obj = new TestCeasarCipher();
        obj.sinpleTests();
    }
}
