
package zombie.domain;

import com.badlogic.gdx.graphics.Texture;

public class GameObject {
    
    protected int x;
    protected int y;
    protected String texture;
    protected int spriteWidth;
    protected int spriteHeight;
    protected int centerX;
    protected int centerY;
    protected int angle = 0;
    
    public GameObject() {
        setCenters();
    }
    
    private void setCenters() {
        setCenterX();
        setCenterY();
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    private void setCenterX() {
        centerX = x + (spriteWidth / 2);
    }

    private void setCenterY() {
        centerY = y + (spriteHeight / 2);
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
        setCenters();
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }

    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
        setCenters();
    }
    
    public int getTextureAsInt() {
        return Integer.parseInt(texture);
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        setCenters();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        setCenters();
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
