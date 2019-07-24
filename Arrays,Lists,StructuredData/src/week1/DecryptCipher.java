package week1;
public class DecryptCipher
{
   public String decrypt(String text,int key)
   {
       CeasarCipher cc=new CeasarCipher();
       String msg=cc.encrypt(text,26-key);
       return  msg;
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
//       for(int i:count)
//           System.out.print(i+"   ");
//       System.out.println();
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
       //System.out.println(maxindex);
       int key=maxindex-4;
       if(key<0)
           key=key+26;
       return key;
   }
   public void decryptTwoKeys(String encrypted)
   {
       String msg1=halfOfString(encrypted,0);
       String msg2=halfOfString(encrypted,1);
       int key1=getKey(msg1);
       int key2=getKey(msg2);
       String str1=decrypt(msg1,key1);
       String str2=decrypt(msg2,key2);
       System.out.println("key 1: "+key1+"\t"+"key 2: "+key2);
       StringBuilder sb = new StringBuilder();
       System.out.println(join(str1,str2));
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
    public  static void main(String args[])
    {
        DecryptCipher obj = new DecryptCipher();
        CeasarCipher cc= new CeasarCipher();
        String msg="EASTER EGGS THE FEAST OF ENGLAND";
//        System.out.println("original msg :"+msg);
//        System.out.println(obj.halfOfString(msg,0));
//        System.out.println(obj.halfOfString(msg,1));
//        System.out.println("\n");
        String encryptedmsg=cc.encryptTwoKeys(msg,25,24);
//        System.out.println("Encrypted msg :"+encryptedmsg);
//        System.out.println(obj.halfOfString(encryptedmsg,0));
//        System.out.println(obj.halfOfString(encryptedmsg,1));
        obj.decryptTwoKeys(encryptedmsg);

    }
}


