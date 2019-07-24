package week1;
import edu.duke.*;
public class CeasarCipher {
    static String upperalphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String loweralphabet="abcdefghijklmnopqrstuvwxyz";
    public String encrypt(String input,int key)
    {

        String encryptupper=upperalphabet.substring(key)+upperalphabet.substring(0,key);
        String encryptlower=loweralphabet.substring(key)+loweralphabet.substring(0,key);
        StringBuilder sb=new StringBuilder(input);
        char ch=sb.charAt(0),newchar='a';
        int index=0;
        for(int i=0;i<sb.length();i++)
        {
            ch=sb.charAt(i);
            index=upperalphabet.indexOf(ch);
            if(index>=0)
            {
                newchar=encryptupper.charAt(index);
                sb.setCharAt(i,newchar);
            }
            else if ((index=loweralphabet.indexOf(ch))>=0)
            {
                newchar=encryptlower.charAt(index);
                sb.setCharAt(i,newchar);
            }
        }
        return sb.toString();
    }
    public  char encrypt(char ch,int key)
    {
        if(!Character.isLowerCase(ch)&&!Character.isUpperCase(ch))
            return ch;
        String encryptupper=upperalphabet.substring(key)+upperalphabet.substring(0,key);
        String encryptlower=loweralphabet.substring(key)+loweralphabet.substring(0,key);
        int index=0;
        index=upperalphabet.indexOf(ch);
        if(index>=0)
            return encryptupper.charAt(index);
        index=loweralphabet.indexOf(ch);
        return encryptlower.charAt(index);
    }
    public String encryptTwoKeys(String input,int key1,int key2)
    {
        char ch=0;
        int i=0,len=input.length();
        StringBuilder sb=new StringBuilder();
        for(i=0;i<len;i++)
        {
            sb.append(encrypt(input.charAt(i), key1));
            i++;
            if (i ==len)
                break;
            sb.append(encrypt(input.charAt(i),key2));
        }
        return sb.toString();
    }
    public  static void main(String args[])
    {
          CeasarCipher obj= new CeasarCipher();
//        FileResource fr = new FileResource();
//        String msg=fr.asString();
//        int key=23;
//        System.out.println(obj.encrypt("First Legion",key));
       System.out.println(obj.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
    }
}
