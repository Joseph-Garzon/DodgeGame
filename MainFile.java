import java.applet.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainFile {
    public static URL bc=null;
    public static AudioClip ac=null;
    public static void main(String[] args){
        try {
            bc = new URL("File:Joakim Karud - Classic.wav");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        ac=Applet.newAudioClip(bc);
            new lv1();}
}
