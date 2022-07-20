import java.awt.*;

public class LeftRightBox extends Collidable {
    public static final int LEFT=0;
    public static final int RIGHT=1;

    private int direction;

    public LeftRightBox(Rectangle rect, int direction, Color color) {
        super(rect, color);
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void changeDirection() {
        direction = (direction+1)%2;
    }

    public void update(){
        int yChange = (direction==RIGHT)?-1:1;
        setRect(new Rectangle((int)getRect().getX()+yChange,
                (int)getRect().getY(),
                (int)getRect().getWidth(),
                (int)getRect().getHeight()));
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }
}
