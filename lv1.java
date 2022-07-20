import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.applet.*;
import java.net.URL;

public class lv1 extends JFrame implements Runnable, KeyListener {
    public GameMusic GM;
    public ArrayList <Wall> was=new ArrayList<>();
    public ArrayList <Collidable> bos=new ArrayList<>();
    public static final int UPS=50;
    public int lives=5;
    private Playaaa boi;
    private BufferedImage buffer;
    private double timeBetweenUpdates=1000.0/UPS;
    public boolean playing=true;
    private URL bc=null;
    private AudioClip bcc=null;
    private URL oof=null;
    private AudioClip ooof=null;
    public lv1(){
        super();
        try {
            bc = new URL("File:Joakim Karud - Classic.wav");
            oof = new URL("File:roblox.wav");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        bcc=Applet.newAudioClip(bc);

        ooof=Applet.newAudioClip(oof);
        bcc.loop();
        bos.add(new UpDownBox(new Rectangle(80,80,20,20),
                UpDownBox.UP,Color.RED));
        bos.add(new UpDownBox(new Rectangle(60,150,20,20),
                UpDownBox.DOWN,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(120,120,20,20),
                UpDownBox.LEFT,Color.RED));
        bos.add(new UpDownBox(new Rectangle(320,150,20,20),
                UpDownBox.UP,Color.RED));
        bos.add(new UpDownBox(new Rectangle(320,250,20,20),
                UpDownBox.DOWN,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(30,100,20,20),
                UpDownBox.LEFT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(250,280,20,20),
                UpDownBox.LEFT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(300,300,20,20),
                UpDownBox.LEFT,Color.RED));
        boi = new Playaaa(new Rectangle(20,20,20,20),Color.CYAN);
        was.add(new Wall(new Rectangle(0,0,20,400),Color.BLACK));
        was.add(new Wall(new Rectangle(380,0,20,400),Color.BLACK));
        was.add(new Wall(new Rectangle(20,0,360,20),Color.BLACK));
        was.add(new Wall(new Rectangle(20,380,360,20),Color.BLACK));
        was.add(new Wall(new Rectangle(100,100,100,20),Color.BLACK));
        was.add(new Wall(new Rectangle(100,100,20,100),Color.BLACK));
        was.add(new Wall(new Rectangle(300,200,20,100),Color.BLACK));
        was.add(new Wall(new Rectangle(200,300,100,20),Color.BLACK));
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
        bg.setColor(Color.YELLOW);
        bg.fillRect(20,20,40,40);
        for(int x=0;x<bos.size();x++){
            bg.setColor(bos.get(x).getColor());
            bg.fillRect((int)bos.get(x).getRect().getX(),
                    (int)bos.get(x).getRect().getY(),
                    (int)bos.get(x).getRect().getWidth(),
                    (int)bos.get(x).getRect().getHeight());
        }
        for(int x=0;x<was.size();x++){
            bg.setColor(was.get(x).getColor());
            bg.fillRect((int)was.get(x).getRect().getX(),
                    (int)was.get(x).getRect().getY(),
                    (int)was.get(x).getRect().getWidth(),
                    (int)was.get(x).getRect().getHeight());
        }
        bg.setColor(Color.GREEN);
        bg.fillRect(340,340,40,40);
        bg.setColor(boi.getColor());
        bg.fillRect((int)boi.getRect().getX(),
                (int)boi.getRect().getY(),
                (int)boi.getRect().getWidth(),
                (int)boi.getRect().getWidth());
        bg.setColor(Color.WHITE);
        bg.drawString("Lives:"+lives,300,10);
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
                update();
                shouldRepaint=true;}
            if(shouldRepaint)
                repaint();
            try{
                Thread.sleep(25);
            }catch (Exception e){

            }
        }
    }
    public void update(){
        for(int x=0;x<bos.size();x++){
            bos.get(x).update();
            for (int y=0;y<bos.size();y++) {
                if (x != y && bos.get(x).collidesWith(bos.get(y))) {
                    bos.get(y).changeDirection();
                    bos.get(y).update();
                    bos.get(x).changeDirection();
                    bos.get(x).update();
                }
            }
            for(int z=0;z<was.size();z++){
                if(bos.get(x).collidesWith(was.get(z))){
                    bos.get(x).changeDirection();
                    bos.get(x).update();
                }
            }
        }
        boi.update();
        if(lives==0){
            lives--;
            new FinalScreenL(bcc);
            setVisible(false);
        }
        if(boi.collidesWith(new Collidable(new Rectangle(340,340,40,40),Color.DARK_GRAY))){
            playing=false;
            lives++;
            new lv2(lives,bcc);
            boi.getRect().setLocation(0,0);
            setVisible(false);
        }
        for (int x=0;x<bos.size();x++){
        if(boi.collidesWith(bos.get(x))) {
            boi.setRect(new Rectangle(20,20,20,20));
            lives--;}
        }
        for(int x=0;x<was.size();x++) {
            if (boi.collidesWith(was.get(x))) {
                if (boi.isDown() == true) {
                    boi.setRect(new Rectangle((int) boi.getRect().getX(),
                            (int) boi.getRect().getY() - 3,
                            (int) boi.getRect().getWidth(),
                            (int) boi.getRect().getHeight()));
                } else if (boi.isUp() == true) {
                    boi.setRect(new Rectangle((int) boi.getRect().getX(),
                            (int) boi.getRect().getY() + 3,
                            (int) boi.getRect().getWidth(),
                            (int) boi.getRect().getHeight()));
                }

            }

            if (boi.collidesWith(was.get(x))) {
                if (boi.isRight() == true) {
                    boi.setRect(new Rectangle((int) boi.getRect().getX() + 3,
                            (int) boi.getRect().getY(),
                            (int) boi.getRect().getWidth(),
                            (int) boi.getRect().getHeight()));
                } else if (boi.isLeft() == true) {
                    boi.setRect(new Rectangle((int) boi.getRect().getX() - 3,
                            (int) boi.getRect().getY(),
                            (int) boi.getRect().getWidth(),
                            (int) boi.getRect().getHeight()));
                }

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
        if(e.getKeyChar()=='w' || e.getKeyChar()=='W'){
            boi.setUp(true);
        }
        else if(e.getKeyChar()=='s' || e.getKeyChar()=='S'){
            boi.setDown(true);
        }
        else if(e.getKeyChar()=='a' || e.getKeyChar()=='A'){
            boi.setRight(true);
        }
        else if(e.getKeyChar()=='d' || e.getKeyChar()=='D'){
            boi.setLeft(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='w' || e.getKeyChar()=='W'){
            boi.setUp(false);
        }
        else if(e.getKeyChar()=='s' || e.getKeyChar()=='S'){
            boi.setDown(false);
        }
        else if(e.getKeyChar()=='a' || e.getKeyChar()=='A'){
            boi.setRight(false);
        }
        else if(e.getKeyChar()=='d' || e.getKeyChar()=='D'){
            boi.setLeft(false);
        }
    }
}


