
package zombie.domain;

public class Actor extends GameObject {
    
    protected int hp;
    protected int maxHp;
    protected int speed;
    protected Tile currentTile;
    
    public Actor() {
        this.maxHp = 100;
        this.hp = this.maxHp;
        this.speed = 1;
        this.spriteWidth = 20;
        this.spriteHeight = 24;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }
    

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > maxHp || hp < 0) {
            return;
        }
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        if (maxHp <= 0) {
            return;
        }
        this.maxHp = maxHp;
    }
    
    public void decreaseHp(int amount) {
        hp -= amount;
        if (hp <= 0) {
            hp = 0;
        }
    }
    
    public void increaseHp(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }
    
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void moveUp() {
        this.y += speed;
    }
    
    public void moveDown() {
        this.y -= speed;
    }
    public void moveRight() {
        this.x += speed;
    }
    public void moveLeft() {
        this.x -= speed ;
    }
    
    
}
