

package zombie.domain;

/**
 * Class stores information about a certain place
 */
public class Place {
    
    private int x;
    private int y;
    
    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    } 

    public int getY() {
        return y;
    }
    
}
