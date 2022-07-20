import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FinalScreenL extends JFrame implements Runnable, KeyListener {
    public ArrayList <Wall> was=new ArrayList<>();
    public ArrayList <Collidable> bos=new ArrayList<>();
    public static final int UPS=50;
    public int lives=5;
    private Playaaa boi;
    private BufferedImage buffer;
    private double timeBetweenUpdates=1000.0/UPS;
    public boolean playing=true;
    private URL oof=null;
    private AudioClip ooof=null;
    private AudioClip bcc=null;
    public FinalScreenL(AudioClip bcc){
        super();
        this.bcc=bcc;
        try {
            oof = new URL("File:FAIL SOUND EFFECT.wav");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        ooof=Applet.newAudioClip(oof);
        bcc.stop();
        ooof.play();
        addKeyListener(this);
        setSize(400,400);
        buffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        Thread t=new Thread(this);
        t.start();
    }
    public void paint(Graphics g){
        Graphics bg=buffer.getGraphics();
        bg.setColor(Color.LIGHT_GRAY);
        bg.fillRect(0,0,getWidth(),getHeight());
        bg.setColor(Color.RED);
        bg.drawString("You Lost!",175,150);
        bg.drawString("Press 'R' try play again",145,200);
        bg.drawString("Or",195,225);
        bg.drawString("'esc' to leave the game.",145,250);
        g.drawImage(buffer,0,0,null);
    }

    @Override
    public void run() {
        long startTime=System.nanoTime();
        long updatesDone=0;
        while (true){
            long updatesNeed=(long)(((System.nanoTime()-startTime)/1000000)/timeBetweenUpdates);
            boolean shouldRepaint=false;
            for(;updatesDone<updatesNeed;updatesDone++){
                shouldRepaint=true;}
            if(shouldRepaint)
                repaint();
            try{
                Thread.sleep(25);
            }catch (Exception e){

            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
        if(e.getKeyChar()=='r' || e.getKeyChar()=='R'){
            ooof.stop();
            new lv1();
            setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


