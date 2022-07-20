import java.applet.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GameMusic {
    AudioClip now;
    public GameMusic() {
        URL no=null;
        try {
            no = new URL("File:alarm.wav");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        now = Applet.newAudioClip(no);
        now.loop();
    }
}
