import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;


public class Programm {
    public static void main(String[] args)  {
        final String ACCESS_TOKEN =
                "CCCr1n-ypjgAAAAAAAAAAS36u_YmIw5bmmFZ6PRXoII-oZFOkjoJ-Ztmo5KEoxyn";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client=new DbxClientV2(config, ACCESS_TOKEN);
        while (true)
        {
            Image image=new Image();
            MyThread thread=new MyThread(client,image.getName(),image.getImage());
            thread.run();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
