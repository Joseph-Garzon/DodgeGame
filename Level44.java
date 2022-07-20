import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level44 extends JFrame implements Runnable, KeyListener {
    public ArrayList <Wall> was=new ArrayList<>();
    public ArrayList <Collidable> bos=new ArrayList<>();
    public ArrayList <Laser> los=new ArrayList<>();
    public static final int UPS=50;
    public int lives=5;
    private Playaaa boi;
    private BufferedImage buffer;
    private double timeBetweenUpdates=1000.0/UPS;
    public boolean playing=true;
    public int lazyCounter=0;
    private AudioClip bcc=null;
    public Level44(int lives, AudioClip bcc){
        super();
        this.lives=lives;
        this.bcc=bcc;
        boi = new Playaaa(new Rectangle(20,20,20,20),Color.CYAN);
        was.add(new Wall(new Rectangle(0,0,20,400),Color.BLACK));
        was.add(new Wall(new Rectangle(380,0,20,400),Color.BLACK));
        was.add(new Wall(new Rectangle(20,0,360,20),Color.BLACK));
        was.add(new Wall(new Rectangle(20,380,360,20),Color.BLACK));
        was.add(new Wall(new Rectangle(70,20,10,310),Color.BLACK));
        was.add(new Wall(new Rectangle(70,70,260,260),Color.BLACK));

        was.add(new Wall(new Rectangle(20,118,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(20,228,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(20,316,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(379,118,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(379,228,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(379,316,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(69,118,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(69,228,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(69,316,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(330,118,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(330,228,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(330,316,1,14),new Color(120, 29, 165)));

        was.add(new Wall(new Rectangle(118,20,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(198,20,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(288,20,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(118,69,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(198,69,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(288,69,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(118,330,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(198,330,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(288,330,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(118,379,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(198,379,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(288,379,14,1),new Color(120, 29, 165)));

        los.add(new Laser(new Rectangle(120,20,10,360),Color.MAGENTA,false));
        los.add(new Laser(new Rectangle(200,20,10,360),Color.MAGENTA,false));
        los.add(new Laser(new Rectangle(290,20,10,360),Color.MAGENTA,false));
        los.add(new Laser(new Rectangle(20,120,360,10),Color.MAGENTA,true));
        los.add(new Laser(new Rectangle(20,230,360,10),Color.MAGENTA,true));
        los.add(new Laser(new Rectangle(20,318,360,10),Color.MAGENTA,true));
        bos.add(new UpDownBox(new Rectangle(200,40,20,20),
                UpDownBox.UP,Color.RED));
        bos.add(new UpDownBox(new Rectangle(200,360,20,20),
                UpDownBox.UP,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(20,200,20,20),
                UpDownBox.LEFT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(360,200,20,20),
                UpDownBox.LEFT,Color.RED));

        bos.add(new UpDownBox(new Rectangle(360,360,20,20),
                UpDownBox.DOWN,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(20,360,20,20),
                UpDownBox.RIGHT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(360,40,20,20),
                UpDownBox.LEFT,Color.RED));
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
        bg.fillRect(20,20,50,50);
        bg.setColor(Color.GREEN);
        bg.fillRect(80,20,40,60);
        bg.setColor(boi.getColor());
        bg.fillRect((int)boi.getRect().getX(),
                (int)boi.getRect().getY(),
                (int)boi.getRect().getWidth(),
                (int)boi.getRect().getWidth());
        for(int x=0;x<bos.size();x++){
            bg.setColor(bos.get(x).getColor());
            bg.fillRect((int)bos.get(x).getRect().getX(),
                    (int)bos.get(x).getRect().getY(),
                    (int)bos.get(x).getRect().getWidth(),
                    (int)bos.get(x).getRect().getHeight());
        }
        for(int x=0;x<los.size();x++){
            if(los.get(x).isOf()==true){
                bg.setColor(los.get(x).getColor());
                bg.fillRect((int)los.get(x).getRect().getX(),
                        (int)los.get(x).getRect().getY(),
                        (int)los.get(x).getRect().getWidth(),
                        (int)los.get(x).getRect().getHeight());}
        }
        for(int x=0;x<was.size();x++){
            bg.setColor(was.get(x).getColor());
            bg.fillRect((int)was.get(x).getRect().getX(),
                    (int)was.get(x).getRect().getY(),
                    (int)was.get(x).getRect().getWidth(),
                    (int)was.get(x).getRect().getHeight());
        }
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
                lazyCounter++;
                if(lazyCounter%70==0){
                    for(int x=0;x<los.size();x++){
                        los.get(x).changeOf();
                    }
                }
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
        for(int x=0;x<los.size();x++) {
            if (boi.collidesWith(los.get(x))&& (los.get(x).isOf()==true)) {
                boi.setRect(new Rectangle(20, 20, 20, 20));
                lives--;
            }
        }
        for(int x=0;x<bos.size();x++){
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(60,360,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(40,360,20,20),UpDownBox.UP,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(40,339,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(40,340,20,20),LeftRightBox.RIGHT,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(20,340,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(20,340,20,20),UpDownBox.DOWN,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(20,379,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(20,360,20,20),LeftRightBox.LEFT,Color.RED));
            }

            if(bos.get(x).collidesWith(new Collidable(new Rectangle(360,339,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(360,340,20,20),LeftRightBox.RIGHT,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(339,340,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(340,340,20,20),UpDownBox.DOWN,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(340,379,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(340,360,20,20),LeftRightBox.LEFT,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(379,379,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(360,360,20,20),UpDownBox.UP,Color.RED));
            }

            if(bos.get(x).collidesWith(new Collidable(new Rectangle(340,20,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(340,20,20,20),UpDownBox.DOWN,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(340,59,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(340,40,20,20),LeftRightBox.LEFT,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(379,20,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(360,20,20,20),LeftRightBox.RIGHT,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(379,59,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(360,40,20,20),UpDownBox.UP,Color.RED));
            }
        }
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
        if(boi.collidesWith(new Collidable(new Rectangle(80,20,40,60),Color.DARK_GRAY))){
            playing=false;
            lives++;
            new lv5(lives,bcc);
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


