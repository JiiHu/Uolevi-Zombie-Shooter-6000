
package zombie.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Map;
import zombie.domain.Player;
import zombie.domain.Tile;
import zombie.domain.Zombie;

public class HUDControllerTest {
    
    LevelController lc;
    ZombieAI zombieAI;
    ActorController ac;
    MapController mc;
    Map map;
    Player player;
    HUDController hud;
    
    @Before
    public void setUp() {
        map = new Map(1000,1000);
        mc = new MapController(map);
        player = new Player(500,500,"test");
        ac = new ActorController(mc, player);
        zombieAI = new ZombieAI(ac, mc, player, 5);
        lc = new LevelController(zombieAI);
        hud = new HUDController(lc, player, zombieAI);
    }


    @Test
    public void zombiesKilledWorks() {
        assertEquals(0, hud.zombiesKilled());
        
        zombieAI.addZombie();
        Zombie z = zombieAI.getZombies().get(0);
        Tile t = new Tile(1,1);
        t.addActor(z);
        z.setCurrentTile(t);
        
        zombieAI.removeZombie(z);
        
        assertEquals(1, hud.zombiesKilled());
    }

}