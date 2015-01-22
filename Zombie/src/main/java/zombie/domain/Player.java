
package zombie.domain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Actor {
    
    private Weapon weapon1;
    private Weapon weapon2;
    
    public Player(int x, int y, String filename) {
        this.x = x;
        this.y = y;
        this.texture = filename;
    }

    public Weapon getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    public Weapon getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }
    
    
    
    
}
