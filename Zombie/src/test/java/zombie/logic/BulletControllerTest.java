
package zombie.logic;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import zombie.domain.Map;
import zombie.domain.Player;
import zombie.domain.Zombie;

public class BulletControllerTest {
    
    
    LevelController lc;
    ZombieAI zombieAI;
    ActorController ac;
    MapController mc;
    Map map;
    Player player;
    BulletController bc;
    
    @Before
    public void setUp() {
        map = new Map(1000,1000);
        mc = new MapController(map);
        player = new Player(500,500,"test");
        ac = new ActorController(mc, player);
        zombieAI = new ZombieAI(ac,player,5);
        lc = new LevelController(zombieAI);
        bc = new BulletController(mc, lc);
    }

    @Test
    public void bulletShotWorks() {
        zombieAI.addZombie();
        Zombie z = zombieAI.getZombies().get(0);
        
        zombieAI.moveZombies();
        
        int x = z.getX();
        int y = z.getY();
        
        for (int i = 0; i < 10; i++) {
            bc.bulletShot(x+15, y+15, 0);
        }
        
        assertEquals(0, zombieAI.getZombies().size());
        
    }
}