
package zombie.domain;


public class Player extends Actor {
    
    public Player(int x, int y, String filename) {
        this.x = x;
        this.y = y;
        this.texture = filename;
        setSpriteHeight(24);
        setSpriteWidth(16);
        this.speed = 2;
    }
    
}
