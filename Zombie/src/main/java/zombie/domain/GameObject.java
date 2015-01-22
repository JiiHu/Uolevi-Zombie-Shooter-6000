
package zombie.domain;

import com.badlogic.gdx.graphics.Texture;

public class GameObject {
    
    protected int x;
    protected int y;
    protected String texture;
    
    public GameObject() {
        
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

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
    
    
    
    
}
