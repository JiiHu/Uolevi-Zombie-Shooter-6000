

package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Bullet;
import zombie.domain.Player;


public class BulletController {
    
    private int effectivity;
    private MapController mc;
    
    public BulletController(MapController mc) {
        this.effectivity = 10;
        this.mc = mc;
    }
    
    public void bulletShot(int x, int y, int angle) {
        Bullet b = new Bullet(x, y, angle, effectivity);
        
        goForwardUntilBulletHitsWall(b);
        
    }

    private void goForwardUntilBulletHitsWall(Bullet b) {
        int x = b.getX();
        int y = b.getY();
        Actor actor = mc.checkIfSomethingIsInSameTile(x, y);
        
        if (actor == null) {
            return;
        }
        
        
    }
    
    
}
