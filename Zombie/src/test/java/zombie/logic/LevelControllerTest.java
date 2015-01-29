
package zombie.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Actor;
import zombie.domain.Map;
import zombie.domain.Player;

public class LevelControllerTest {
    
    LevelController lc;
    ZombieAI zombieAI;
    ActorController ac;
    MapController mc;
    Map map;
    Player player;

    @Before
    public void setUp() {
        map = new Map(1000,1000);
        mc = new MapController(map);
        player = new Player(500,500,"test");
        ac = new ActorController(mc);
        zombieAI = new ZombieAI(ac,player);
        lc = new LevelController(zombieAI);
    }
    
    @Test
    public void unreleasedZombiesLeftWorks() {
        assertEquals(true, lc.unreleasedZombiesLeft());
        for (int i = 0; i < 8; i++) {
            lc.releaseZombie();
        }
        assertEquals(false, lc.unreleasedZombiesLeft());
    }
    
    @Test
    public void releaseZombieWorks() {
        assertEquals(0, zombieAI.getZombies().size());
        lc.releaseZombie();
        assertEquals(1, zombieAI.getZombies().size());
    }
    
    @Test
    public void getLevelNumberWorks() {
        assertEquals(1, lc.getLevelNumber());
        lc.newLevel();
        assertEquals(2, lc.getLevelNumber());
    }
    
    @Test
    public void zombieKilledWorks() {
        assertEquals(1, lc.getLevelNumber());
        for (int i = 0; i < 8; i++) {
            lc.zombieKilled();
        }
        assertEquals(2, lc.getLevelNumber());
    }

}