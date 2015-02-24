
package zombie.domain;

/**
 * Class is a super class for the Zombies and the Player
 */
public class Actor extends GameObject {
    
    protected int hp;
    protected int maxHp;
    protected int speed;
    protected Tile currentTile;
    protected boolean dead;
    
    public Actor() {
        this.maxHp = 100;
        this.hp = this.maxHp;
        this.speed = 1;
        this.dead = false;
        this.spriteWidth = 20;
        this.spriteHeight = 24;
    }
    
    /**
     * Method for setting actor alive
     */
    public void setAlive() {
        this.dead = false;
    }

    /**
    * Method returns actor's currentTile
    * 
    * @return actor's currentTile
    */
    public Tile getCurrentTile() {
        return currentTile;
    }

    /**
    * Method sets new currentTile for the actor
    * 
    * @param   tile   new tile to be set as actor's currentTile
    */
    public void setCurrentTile(Tile tile) {
        this.currentTile = tile;
    }
    

    /**
    * Method returns actor's hp value
    * 
    * @return actor's hp value
    */
    public int getHp() {
        return hp;
    }

    /**
    * Method sets new hp value for the actor
    * 
    * @param   hp   new hp value
    */
    public void setHp(int hp) {
        if (hp > maxHp || hp < 0) {
            return;
        }
        this.hp = hp;
    }

    /**
    * Method returns actor's maxHp value
    * 
    * @return actor's maxHp value
    */
    public int getMaxHp() {
        return maxHp;
    }

    /**
    * Method sets new maxHp for the Actor
    * 
    * @param   maxHp   new maxHP value
    */
    public void setMaxHp(int maxHp) {
        if (maxHp <= 0) {
            return;
        }
        this.maxHp = maxHp;
    }
    
    /**
     * Method tells if the actor is dead
     * 
     * @return is the actor dead
     */
    public boolean isDead() {
        return this.dead;
    }
    
    /**
    * Method decreases actor's hp
    * 
    * @param   amount   amount that how much the hp is decreased
    * @return was the hit critical to kill the actor
    */
    public boolean decreaseHp(int amount) {
        hp -= amount;
        if (hp <= 0) {
            hp = 0;
            if (!isDead()) {
                dead = true;
                return true;
            }
        }
        return false;
    }
    
    /**
    * Method increases actor's hp
    * 
    * @param   amount   amount that how much the hp is increased
    */
    public void increaseHp(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }
    
    /**
    * Returns actor's speed
    */
    public int getSpeed() {
        return speed;
    }

    /**
    * Method sets new speed for the actor
    * 
    * @param   speed   new speed value for the actor
    */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    /**
    * Method moves actor up as many pixels as actor's speed is
    */
    public void moveUp() {
        this.y += speed;
    }
    
    /**
    * Method moves actor down as many pixels as actor's speed is
    */
    public void moveDown() {
        this.y -= speed;
    }
    
    /**
    * Method moves actor right as many pixels as actor's speed is
    */
    public void moveRight() {
        this.x += speed;
    }
    
    /**
    * Method moves actor left as many pixels as actor's speed is
    */
    public void moveLeft() {
        this.x -= speed;
    }
    
    
}
