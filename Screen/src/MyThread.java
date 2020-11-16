import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;

import java.io.*;
import java.util.Base64;

public class MyThread extends Thread{

    DbxClientV2 client;
    String nameImage;
    String image;
    public MyThread(DbxClientV2 client, String nameImage, String image) {
        this.client=client;
        this.nameImage=nameImage;
        this.image=image;
    }
    @Override
    public void run(){
        try (InputStream in = new ByteArrayInputStream(Base64.getDecoder().decode(image));) {
            FileMetadata metadata = client.files().uploadBuilder("/"+nameImage)
                    .uploadAndFinish(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UploadErrorException e) {
            e.printStackTrace();
        } catch (DbxException e) {
            e.printStackTrace();
        }
    }
}
