
package zombie.domain;

public class Actor extends GameObject {
    
    protected int hp;
    protected int maxHp;
    
    public Actor() {
        
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
        if (maxHp < 0) {
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

    
}
