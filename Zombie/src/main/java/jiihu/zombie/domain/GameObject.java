
package jiihu.zombie.domain;



public abstract class GameObject {
    
    protected int x;
    protected int y;
    protected String spriteFile;
    
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

    public String getSpriteFile() {
        return spriteFile;
    }

    public void setSpriteFile(String spriteFile) {
        this.spriteFile = spriteFile;
    }
    
    
}
