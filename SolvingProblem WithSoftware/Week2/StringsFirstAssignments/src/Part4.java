import edu.duke.URLResource;
public class Part4 {
    public void test()
    {
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.words()) {
            if(s.indexOf("youtube.com")>=0)
            {
                int firstindex=s.indexOf("\"");
                int lastindex=s.indexOf("\"",firstindex+1);
                System.out.println(s.substring(firstindex+1,lastindex));
            }
        }
    }
    public  static  void main(String args[])
    {
        Part4 obj= new Part4();
        obj.test();
    }
}
