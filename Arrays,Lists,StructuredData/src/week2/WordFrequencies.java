package week2;
import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.List;

public class WordFrequencies {
    private List<String> mywords;
    private List<Integer> myfreqs;
    WordFrequencies()
    {
        mywords= new ArrayList<>();
        myfreqs= new ArrayList<>();
    }
    public void findUnique() {
        myfreqs.clear();
        mywords.clear();
        FileResource fr = new FileResource();
        for (String words : fr.words()) {
            int index = mywords.indexOf(words);
            if (index == -1) {
                mywords.add(words);
                myfreqs.add(1);
            } else {
                myfreqs.set(index, myfreqs.get(index) + 1);
            }
        }
    }
    public int findMaxIndex()
    {
        int freq=0,indexmax=-1;
        for(int i=0;i<myfreqs.size();i++)
        {
            if(freq<myfreqs.get(i))
            {
                freq=myfreqs.get(i);
                indexmax=i;
            }
        }
        return indexmax;
    }
    public void tester()
    {
        findUnique();
        System.out.println("Number of unique words :"+myfreqs.size());
        for(int i=0;i<myfreqs.size();i++)
        {
            System.out.println("Word :"+mywords.get(i)+"\t Freq :"+myfreqs.get(i));
        }
        int maxIndex=findMaxIndex();
        System.out.println("Max ocuured word is :"+mywords.get(maxIndex)+"\t freq :"+myfreqs.get(maxIndex));
    }
    public static  void main(String rgs[])
    {
        WordFrequencies obj= new WordFrequencies();
        obj.tester();
    }
}
