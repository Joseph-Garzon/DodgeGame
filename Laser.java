import java.awt.*;

public class Laser extends Collidable {
    private boolean of;
    public Laser(Rectangle rect, Color color, boolean of) {
        super(rect, color);
        this.of=of;
    }

    public boolean isOf() {
        return of;
    }

    public void setOf(boolean of) {
        this.of = of;
    }
    public void changeOf(){
        if(of==false)
            of=true;
        else
            of=false;
    }
}
