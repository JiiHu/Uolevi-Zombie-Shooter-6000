
package zombie.domain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Actor {
    
    public Player(int x, int y, String filename) {
        this.x = x;
        this.y = y;
        this.texture = filename;
        setSpriteSize();
    }

    private void setSpriteSize() {
        setSpriteHeight(24);
        setSpriteWidth(16);
    }
    
    
    
    
}
