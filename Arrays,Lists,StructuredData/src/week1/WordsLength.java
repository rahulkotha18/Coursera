package week1;
import edu.duke.FileResource;
public class WordsLength {
    public void countWordLength(FileResource res,int count[]) {
        int len = 0, largestlengthword = 0;
        for (String word : res.words()) {
            if ( (word.length()>=2)&&  Character.isLetter(word.charAt(0))) {
                len = word.length();
                if(!Character.isLetter(word.charAt(len-1)))
                    len--;
                count[len] += 1;
            }
        }
        System.out.println("most common word length: "+indexOf(count));
    }

    public void testCountWordLengths()
    {
        FileResource fr= new FileResource();
        int count[]=new int[31];
        countWordLength(fr,count);
    }

    public int indexOf(int []count)
    {
        int index=-1;
        for(int i=0;i<count.length;i++)
        {
            if(index<count[i])
                index=count[i];
        }
        return index;
    }

    public static void main(String args[])
    {
        WordsLength obj= new WordsLength();
        obj.testCountWordLengths();
    }
}
