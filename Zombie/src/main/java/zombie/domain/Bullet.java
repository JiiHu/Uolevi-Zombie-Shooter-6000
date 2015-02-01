

package zombie.domain;


public class Bullet {

    private int x;
    private int y;
    private int angle;
    private int effectivity;
    
    public Bullet(int x, int y, int angle, int effectivity) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.effectivity = effectivity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAngle() {
        return angle;
    }

    public int getEffectivity() {
        return effectivity;
    }
    
}
