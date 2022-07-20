import java.awt.*;

public class Playaaa extends Collidable {
    private boolean left,right,up,down;
    private Color color;
    public Playaaa(Rectangle rect,Color color) {
        super(rect, color);
        this.color = color;
    }

    @Override
    public void update() {
        if(left==true)
            getRect().setLocation((int)getRect().getX()+3,(int)getRect().getY());
        if(right==true)
            getRect().setLocation((int)getRect().getX()-3,(int)getRect().getY());
        if(up==true)
            getRect().setLocation((int)getRect().getX(),(int)getRect().getY()-3);
        if(down==true)
            getRect().setLocation((int)getRect().getX(),(int)getRect().getY()+3);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
