import edu.duke.*;
import java.io.*;
public class ImageInversion {
    public void convertToGreyImage() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource newImage = getGreyImage(new ImageResource(f));
            String newName = f.getName();
            newName="copy-grey-"+newName;
            newImage.setFileName(newName);
            newImage.save();
            newImage.draw();
        }
    }

    public ImageResource getGreyImage(ImageResource inImage)
    {
        ImageResource outImage=new ImageResource(inImage);
        for(Pixel pixel:outImage.pixels())
        {
            Pixel pout=inImage.getPixel(pixel.getX(),pixel.getY());
            int avg=(pout.getRed()+pout.getBlue()+pout.getGreen())/3;
            pixel.setBlue(avg);
            pixel.setGreen(avg);
            pixel.setRed(avg);
        }
        return  outImage;
    }
    public void invertImage() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource newImage = getInvertImage(new ImageResource(f));
            String newName = f.getName();
            newName="inverted in-"+newName;
            newImage.setFileName(newName);
            newImage.save();
            newImage.draw();
        }
    }

    public ImageResource getInvertImage(ImageResource inImage)
    {
        ImageResource outImage=new ImageResource(inImage);
        for(Pixel pixel:outImage.pixels())
        {
            Pixel pout=inImage.getPixel(pixel.getX(),pixel.getY());
            pixel.setBlue(255-pout.getBlue());
            pixel.setGreen(255-pout.getGreen());
            pixel.setRed(255-pout.getRed());
        }
        return  outImage;
    }
    public static void  main(String args[])
    {
        ImageInversion obj= new ImageInversion();
        //obj.convertToGreyImage();
        obj.invertImage();
    }
}

