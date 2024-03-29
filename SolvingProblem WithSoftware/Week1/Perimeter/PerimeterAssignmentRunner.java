import edu.duke.*;
import java.io.File;
public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int counter=0;
        for(Point p:s.getPoints())
            counter++;
        return counter;
    }

    public double getAverageLength(Shape s) {
        double avg_length=0;
        int no_of_points=getNumPoints(s);
        double perimeter= getPerimeter(s);
        return perimeter/no_of_points;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double max=0;
        for (Point currPt : s.getPoints())
        {
            double currDist = prevPt.distance(currPt);
            if(max<currDist)
                max=currDist;
            prevPt=currPt;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        double max_x=s.getLastPoint().getX();
        for(Point currPt : s.getPoints())
        {
            max_x=Math.max(max_x,currPt.getX());
        }
        return max_x;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr=new DirectoryResource();
        double maxperimeter=0.0;
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape sf = new Shape(fr);
            double per=getPerimeter(sf);
            if(maxperimeter<per)
                maxperimeter=per;
        }
        return maxperimeter;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null;
        DirectoryResource dr=new DirectoryResource();
        double maxperimeter=0.0;
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape sf = new Shape(fr);
            double per=getPerimeter(sf);
            if(maxperimeter<per)
                {
                    maxperimeter = per;
                    temp=f;
                }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points=getNumPoints(s);
        System.out.println("Number of points =\t"+points);
        double avg_length=getAverageLength(s);
        System.out.println("Average length =\t"+avg_length);
        double large_side=getLargestSide(s);
        System.out.println("Largest side =\t"+large_side);
        double large_X=getLargestX(s);
        System.out.println("Largest X point =\t"+large_X);

    }
    
    public void testPerimeterMultipleFiles() {
       double largestperimeter= getLargestPerimeterMultipleFiles();
       System.out.println("largestperimeter =\t"+largestperimeter);
    }

    public void testFileWithLargestPerimeter() {
        String largestperimeterfile= getFileWithLargestPerimeter();
        System.out.println("File with largestperimeter =   "+largestperimeterfile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter =\t"+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
//        pr.getLargestPerimeterMultipleFiles();
        pr.testPerimeterMultipleFiles();
       // pr.getFileWithLargestPerimeter();
        pr.testFileWithLargestPerimeter();
    }
}
