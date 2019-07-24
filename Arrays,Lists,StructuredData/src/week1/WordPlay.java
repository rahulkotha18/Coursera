package week1;
public class WordPlay {
    public boolean isVowel(char ch)
    {
        String vowel="AEIOUaeiou";
        if(vowel.indexOf(ch)>=0)
            return true;
        return false;
    }
    public String replaceVowels(String phrase,char ch)
    {
        String vowel="aeiouAEIOU";
        StringBuilder sb=new StringBuilder(phrase);
        for(int i=0;i<sb.length();i++)
        {
            if(vowel.indexOf(sb.charAt(i))>=0)
                sb.setCharAt(i,ch);
        }
        return sb.toString();
    }
    public String emphasize(String phrase,char ch)
    {
        StringBuilder sb=new StringBuilder(phrase);
        for(int i=0;i<sb.length();i++)
        {
            if(sb.charAt(i)==Character.toLowerCase(ch)||sb.charAt(i)==Character.toUpperCase(ch))
            {
                if(i%2!=0)
                    sb.setCharAt(i,'+');
                else
                    sb.setCharAt(i,'*');
            }
        }
        return sb.toString();
    }
    public  static  void  main(String args[])
    {
        WordPlay obj= new WordPlay();
        System.out.println(obj.isVowel('a'));
        System.out.println(obj.replaceVowels("RAhul",'#'));
        System.out.println(obj.emphasize("dna ctgaaactga",'a'));
        System.out.println(obj.emphasize("Mary Bella Abracadabra",'a'));
    }
}
