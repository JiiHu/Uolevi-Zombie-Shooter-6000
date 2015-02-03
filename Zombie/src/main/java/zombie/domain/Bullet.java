
package zombie.domain;

/**
 * Class holds information about fired bullet
 */
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

    /**
    * Method returns bullet's current X axis value
    * 
    * @return bullet's current X axis 
    */
    public int getX() {
        return x;
    }

    /**
    * Method sets new X axis value for the bullet
    * 
    * @param    x   new X axis value for the bullet
    */
    public void setX(int x) {
        this.x = x;
    }

    /**
    * Method returns bullet's current Y axis value
    * 
    * @return bullet's current Y axis value
    */
    public int getY() {
        return y;
    }

    /**
    * Method sets new Y axis value for the bullet
    * 
    * @param    y   new X axis value for the bullet
    */
    public void setY(int y) {
        this.y = y;
    }

    /**
    * Method returns bullet's angle
    * 
    * @return bullet's angle
    */
    public int getAngle() {
        return angle;
    }

    /**
    * Method returns bullet's effectivity
    * 
    * @return bullet's effectivity
    */
    public int getEffectivity() {
        return effectivity;
    }
    
}
