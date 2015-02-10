
package zombie.domain;

/**
 * Super class for different kinds of objects which are in the game
 */
public class GameObject {
    
    protected int x;
    protected int y;
    protected String texture;
    protected int spriteWidth;
    protected int spriteHeight;
    protected int centerX;
    protected int centerY;
    protected int angle = 0;
    
    

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }

    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }
    
    public int getTextureAsInt() {
        return Integer.parseInt(texture);
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

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
    
    
}
