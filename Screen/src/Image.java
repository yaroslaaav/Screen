import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Image {
    private Date date;
    private SimpleDateFormat formatter;
    BufferedImage screenImage=null;
    public Image() {
        formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
        date = new Date();
        getImage();
    }
    public String getImage(){
        String base64String=null;
        try{
            Rectangle screenSize=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenImage = new Robot().createScreenCapture(screenSize);

            ByteArrayOutputStream baos= new ByteArrayOutputStream(1000);
            ImageIO.write(screenImage, "PNG", baos);

            baos.flush();
            base64String = Base64.getEncoder().encodeToString(baos.toByteArray());
            baos.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return base64String;
    }
    public String getName(){
        return formatter.format(date)+".png";
    }
}
