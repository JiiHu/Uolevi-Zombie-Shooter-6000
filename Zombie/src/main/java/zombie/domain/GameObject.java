
package zombie.domain;

public class GameObject {
    
    protected int x;
    protected int y;
    protected SpriteImage sprite;
    
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

    public SpriteImage getSprite() {
        return sprite;
    }

    public void setSprite(SpriteImage sprite) {
        this.sprite = sprite;
    }
    
    
}
