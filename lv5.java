import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class lv5 extends JFrame implements Runnable, KeyListener {
    public ArrayList <Wall> was=new ArrayList<>();
    public ArrayList <Wall> fwas=new ArrayList<>();
    public ArrayList <Collidable> bos=new ArrayList<>();
    public ArrayList <Laser> los=new ArrayList<>();
    public ArrayList <Collidable>tblox=new ArrayList<>();
    public ArrayList <Wall> ow=new ArrayList<>();
    public static final int UPS=50;
    public int lives=5;
    private Playaaa boi;
    private BufferedImage buffer;
    private double timeBetweenUpdates=1000.0/UPS;
    public boolean playing=true;
    public int lazyCounter=0;
    private AudioClip bcc=null;
    public lv5(int lives, AudioClip bcc){
        super();
        this.lives=lives;
        this.bcc=bcc;
        boi = new Playaaa(new Rectangle(20,20,20,20),Color.CYAN);

        fwas.add(new Wall(new Rectangle(0,180,100,200),Color.BLACK));
        fwas.add(new Wall(new Rectangle(70,0,330,400),Color.BLACK));

        was.add(new Wall(new Rectangle(0,0,20,400),Color.BLACK));
        was.add(new Wall(new Rectangle(380,0,20,400),Color.BLACK));
        was.add(new Wall(new Rectangle(20,0,90,20),Color.BLACK));
        was.add(new Wall(new Rectangle(20,380,360,20),Color.BLACK));
        was.add(new Wall(new Rectangle(130,0,300,20),Color.BLACK));
        was.add(new Wall(new Rectangle(70,20,14,310),Color.BLACK));
        was.add(new Wall(new Rectangle(148,20,14,310),Color.BLACK));
        was.add(new Wall(new Rectangle(238,20,14,310),Color.BLACK));
        was.add(new Wall(new Rectangle(316,20,14,310),Color.BLACK));

        bos.add(new LeftRightBox(new Rectangle(86,80,20,20),
                LeftRightBox.RIGHT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(90,125,20,20),
                LeftRightBox.LEFT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(84,150,20,20),
                LeftRightBox.RIGHT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(90,200,20,20),
                LeftRightBox.LEFT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(100,270,20,20),
                LeftRightBox.LEFT,Color.RED));

        bos.add(new LeftRightBox(new Rectangle(170,125,20,20),
                LeftRightBox.LEFT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(170,200,20,20),
                LeftRightBox.LEFT,Color.RED));
        bos.add(new LeftRightBox(new Rectangle(170,275,20,20),
                LeftRightBox.LEFT,Color.RED));

        bos.add(new UpDownBox(new Rectangle(252,300,20,20),-1,Color.RED));
        bos.add(new UpDownBox(new Rectangle(302,260,14,30),-1,Color.RED));
        bos.add(new UpDownBox(new Rectangle(260,220,10,35),-1,Color.RED));
        bos.add(new UpDownBox(new Rectangle(255,105,10,10),-1,Color.RED));
        bos.add(new UpDownBox(new Rectangle(280,180,40,2),-1,Color.RED));
        bos.add(new UpDownBox(new Rectangle(252,120,10,10),-1,Color.RED));
        bos.add(new UpDownBox(new Rectangle(305,110,2,30),-1,Color.RED));
        bos.add(new UpDownBox(new Rectangle(275,60,20,18),-1,Color.RED));

        bos.add(new UpDownBox(new Rectangle(331,100,9,10),UpDownBox.UP,Color.RED));
        bos.add(new UpDownBox(new Rectangle(340,110,10,10),UpDownBox.UP,Color.RED));
        bos.add(new UpDownBox(new Rectangle(350,120,10,10),UpDownBox.UP,Color.RED));
        bos.add(new UpDownBox(new Rectangle(360,130,10,10),UpDownBox.UP,Color.RED));
        bos.add(new UpDownBox(new Rectangle(370,140,9,10),UpDownBox.UP,Color.RED));

        was.add(new Wall(new Rectangle(20,118,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(20,263,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(20,316,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(379,118,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(379,263,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(379,316,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(379,171,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(69,118,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(69,263,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(69,316,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(330,118,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(330,263,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(330,316,1,14),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(330,171,1,14),new Color(120, 29, 165)));

        was.add(new Wall(new Rectangle(148,330,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(238,330,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(148,379,14,1),new Color(120, 29, 165)));
        was.add(new Wall(new Rectangle(238,379,14,1),new Color(120, 29, 165)));


        los.add(new Laser(new Rectangle(150,20,10,360),Color.MAGENTA,false));
        los.add(new Laser(new Rectangle(240,20,10,360),Color.MAGENTA,false));
        los.add(new Laser(new Rectangle(20,120,60,10),Color.MAGENTA,true));
        los.add(new Laser(new Rectangle(20,265,60,10),Color.MAGENTA,true));
        los.add(new Laser(new Rectangle(20,318,60,10),Color.MAGENTA,true));
        los.add(new Laser(new Rectangle(330,173,80,10),Color.MAGENTA,true));
        los.add(new Laser(new Rectangle(330,120,60,10),Color.MAGENTA,true));
        los.add(new Laser(new Rectangle(330,265,60,10),Color.MAGENTA,true));
        los.add(new Laser(new Rectangle(330,318,60,10),Color.MAGENTA,true));

        tblox.add(new Collidable(new Rectangle(275,40,20,20),new Color(240,191,241)));
        tblox.add(new Collidable(new Rectangle(190,40,20,20),new Color(240,191,241)));
        tblox.add(new Collidable(new Rectangle(107,40,20,20),new Color(240,191,241)));
        tblox.add(new Collidable(new Rectangle(290,345,20,20),new Color(240,191,241)));
        tblox.add(new Collidable(new Rectangle(35,140,20,20),new Color(240,191,241)));

        ow.add(new Wall(new Rectangle(318,320,10,80),Color.ORANGE));
        ow.add(new Wall(new Rectangle(242,320,80,10),Color.ORANGE));
        ow.add(new Wall(new Rectangle(158,320,80,10),Color.ORANGE));
        ow.add(new Wall(new Rectangle(84,320,70,10),Color.ORANGE));

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
        bg.fillRect(330,200,60,50);
        bg.setColor(boi.getColor());
        bg.fillRect((int)boi.getRect().getX(),
                (int)boi.getRect().getY(),
                (int)boi.getRect().getWidth(),
                (int)boi.getRect().getWidth());
        bg.setColor(Color.BLACK);
        bg.fillRect(110,15,20,5);
        bg.fillRect(110,5,20,7);
        bg.fillRect(110,10,15,5);
        bg.fillRect(115,3,15,2);
        bg.fillRect(110,0,17,3);
        for(int x=0;x<bos.size();x++){
            bg.setColor(bos.get(x).getColor());
            bg.fillRect((int)bos.get(x).getRect().getX(),
                    (int)bos.get(x).getRect().getY(),
                    (int)bos.get(x).getRect().getWidth(),
                    (int)bos.get(x).getRect().getHeight());
        }
        for(int x=0;x<ow.size();x++){
            bg.setColor(ow.get(x).getColor());
            bg.fillRect((int)ow.get(x).getRect().getX(),
                    (int)ow.get(x).getRect().getY(),
                    (int)ow.get(x).getRect().getWidth(),
                    (int)ow.get(x).getRect().getHeight());
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
        for(int x=0;x<tblox.size();x++) {
            bg.setColor(tblox.get(x).getColor());
            bg.fillRect((int) tblox.get(x).getRect().getX(),
                    (int) tblox.get(x).getRect().getY(),
                    (int) tblox.get(x).getRect().getWidth(),
                    (int) tblox.get(x).getRect().getHeight());
        }
        if(tblox.size()==5) {
            for (int x = 0; x < fwas.size(); x++) {
                bg.setColor(fwas.get(x).getColor());
                bg.fillRect((int) fwas.get(x).getRect().getX(),
                        (int) fwas.get(x).getRect().getY(),
                        (int) fwas.get(x).getRect().getWidth(),
                        (int) fwas.get(x).getRect().getHeight());
            }
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
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(237,140,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(217,125,20,20),UpDownBox.UP,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(236,74,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(217,75,20,20),LeftRightBox.RIGHT,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(162,76,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(163,75,20,20),UpDownBox.DOWN,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(163,141,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(163,125,20,20),LeftRightBox.LEFT,Color.RED));
            }

            if(bos.get(x).collidesWith(new Collidable(new Rectangle(237,215,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(217,200,20,20),UpDownBox.UP,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(236,149,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(217,150,20,20),LeftRightBox.RIGHT,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(162,151,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(163,150,20,20),UpDownBox.DOWN,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(163,216,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(163,200,20,20),LeftRightBox.LEFT,Color.RED));
            }

            if(bos.get(x).collidesWith(new Collidable(new Rectangle(237,290,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(217,275,20,20),UpDownBox.UP,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(236,224,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(217,225,20,20),LeftRightBox.RIGHT,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(162,226,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new UpDownBox(new Rectangle(163,225,20,20),UpDownBox.DOWN,Color.RED));
            }
            if(bos.get(x).collidesWith(new Collidable(new Rectangle(163,291,1,1), Color.BLACK))){
                bos.remove(x);
                bos.add(new LeftRightBox(new Rectangle(163,275,20,20),LeftRightBox.LEFT,Color.RED));
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
        if(tblox.size()==5) {
            for (int x = 0; x < fwas.size(); x++) {
                if (boi.collidesWith(fwas.get(x))) {
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

                if (boi.collidesWith(fwas.get(x))) {
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
        for(int x=0;x<tblox.size();x++){
            if(boi.collidesWith(tblox.get(x))){
                if(tblox.size()<=4)
                    ow.remove(x);
                tblox.remove(x);
            }
        }
        boi.update();
        if(boi.collidesWith(new Collidable(new Rectangle(110,0,20,1),Color.WHITE))){
            boi.getRect().setLocation(20,20);
            new BL(lives, bcc);
            setVisible(false);
        }
        if(lives==0){
            lives--;
            new FinalScreenL(bcc);
            setVisible(false);
        }
        if(boi.collidesWith(new Collidable(new Rectangle(330,200,60,50),Color.DARK_GRAY))){
            playing=false;
            new FinalScreenW(lives, bcc);
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
        for (int x = 0; x < ow.size(); x++) {
            if (boi.collidesWith(ow.get(x))) {
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

            if (boi.collidesWith(ow.get(x))) {
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


