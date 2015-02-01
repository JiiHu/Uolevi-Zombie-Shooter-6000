package zombie.logic;

import org.junit.Before;
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
        player = new Player(500, 500, "test");
        map = new Map(1280, 720);
        mc = new MapController(map);
        ac = new ActorController(mc, player);
        zombieAI = new ZombieAI(ac, player, 5);
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
        int amount = 30;
        int[][] originalPosition = new int[amount][amount];
        int pX = player.getX();
        int pY = player.getY();

        for (int i = 0; i < amount; i++) {
            zombieAI.addZombie();
            Zombie z = zombieAI.getZombies().get(i);
            originalPosition[i][0] = z.getX();
            originalPosition[i][1] = z.getY();
        }
        
        zombieAI.moveZombies();
        
        for (int i = 0; i < amount; i++) {
            int zX1 = originalPosition[i][0];
            int zY1 = originalPosition[i][1];
            
            Zombie z = zombieAI.getZombies().get(i);
            int zX2 = z.getX();
            int zY2 = z.getY();

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

}
