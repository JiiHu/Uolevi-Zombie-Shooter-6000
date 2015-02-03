

package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Bullet;
import zombie.domain.Player;
import zombie.domain.Zombie;

/**
 * Class to control the bullets which are fired
 */
public class BulletController {
    
    private int effectivity;
    private MapController mc;
    private LevelController levelController;
    
    public BulletController(MapController mc, LevelController levelController) {
        this.effectivity = 10;
        this.mc = mc;
        this.levelController = levelController;
    }
    
    public void bulletShot(int x, int y, int angle) {
        Bullet b = new Bullet(x, y, angle, effectivity);
        processShooting(b);
        
    }

    private void processShooting(Bullet b) {
        int x = b.getX();
        int y = b.getY();
        Actor actor = mc.checkIfSomethingIsInTile(x, y);
        
        if (actor == null) {
            return;
        }
        
        if (actor instanceof Player) {
            System.out.println("player");
            return;
        } else if (actor instanceof Zombie) {
            System.out.println("zombie");
        }
        
        Zombie zombie = (Zombie) actor;
        shootActor(zombie, b);
    }
    
    private void shootActor(Zombie zombie, Bullet b) {
        int amount = b.getEffectivity();
        zombie.decreaseHp(amount);
        if (zombie.isDead()) {
            System.out.println("pitäis poistaa");
            levelController.zombieKilled(zombie);
        }
    }
    
    
}
