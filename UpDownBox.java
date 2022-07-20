import java.awt.*;

public class UpDownBox extends Collidable {
    public static final int UP=0;
    public static final int DOWN=1;

    private int direction;

    public UpDownBox(Rectangle rect, int direction, Color color) {
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
        if(direction!=-1){
        int yChange = (direction==UP)?-1:1;
        setRect(new Rectangle((int)getRect().getX(),
                (int)getRect().getY()+yChange,
                (int)getRect().getWidth(),
                (int)getRect().getHeight()));}
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
