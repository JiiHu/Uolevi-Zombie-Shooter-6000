package zombie.game;


import zombie.game.ZombieGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZombieGameTest {
    
    ZombieGame game;

    @Before
    public void setUp() {
        game = new ZombieGame(1000, 1000);
    }

    @Test
    public void playerGoesCenterOfTheScreen() {
        assertEquals(500, game.getPlayer().getX());
        assertEquals(500, game.getPlayer().getY());
    }
    
    @Test
    public void playWorks() {
        assertEquals(0, game.getZombieAI().getZombies().size());
        for (int i = 0; i < 99; i++) {
            game.play();
        }
        assertEquals(0, game.getZombieAI().getZombies().size());
        game.play();
        assertEquals(1, game.getZombieAI().getZombies().size());
    }
    
    
    
}