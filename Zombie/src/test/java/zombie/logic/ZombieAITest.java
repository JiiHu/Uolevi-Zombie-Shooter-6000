
package zombie.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Map;
import zombie.domain.Player;
import zombie.domain.Zombie;

public class ZombieAITest {

    ZombieAI zombieAI;
    ActorController ac;
    MapController mc;
    Map map;
    Player player;

    @Before
    public void setUp() {
        player = new Player(500,500,"test");
        map = new Map(1000,1000);
        mc = new MapController(map);
        ac = new ActorController(mc);
        zombieAI = new ZombieAI(ac, player);
    }

    
    @Test
    public void getZombiesWorks() {
        assertEquals(0, zombieAI.getZombies().size());
        zombieAI.addZombie();
        assertEquals(1, zombieAI.getZombies().size());
    }
    
    @Test
    public void addAndRemoveZombieWorks() {
        assertEquals(0, zombieAI.getZombies().size());
        zombieAI.addZombie();
        assertEquals(1, zombieAI.getZombies().size());
        Zombie z = zombieAI.getZombies().get(0);
        zombieAI.removeZombie(z);
        assertEquals(0, zombieAI.getZombies().size());
    }
    
    @Test
    public void moveZombiesWorks() {
        zombieAI.addZombie();
        Zombie z = zombieAI.getZombies().get(0);
        int zX1 = z.getX();
        int zY1 = z.getY();
        zombieAI.moveZombies();
        int zX2 = z.getX();
        int zY2 = z.getY();
        
        assertTrue(zX1 != zX2);
        assertTrue(zY1 != zY2);
    }
    
    
    @Test
    public void zombiesMoveToCorrectDirection() {
        zombieAI.addZombie();
        Zombie z = zombieAI.getZombies().get(0);

        int zX1 = z.getX();
        int zY1 = z.getY();
        zombieAI.moveZombies();
        int zX2 = z.getX();
        int zY2 = z.getY();
        
        int pX = player.getX();
        int pY = player.getY();
        
        if (pX < zX1) {
            assertTrue(zX1 > zX2);
        } else if (pX > zX1) {
            assertTrue(zX1 < zX2);
        } else {
            assertTrue(zX1 == zX2);
        }
        
        if (pY < zY1) {
            assertTrue(zY1 > zY2);
        } else if (pY > zY1) {
            assertTrue(zY1 < zY2);
        } else {
            assertTrue(zY1 == zY2);
        }
    }
    
    

}