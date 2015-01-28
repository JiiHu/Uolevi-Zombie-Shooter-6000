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

    public ZombieGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new ZombieGame(100, 100);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void playerGoesCenterOfTheScreen() {
        assertEquals(50, game.getPlayer().getX());
        assertEquals(50, game.getPlayer().getY());
    }
    
    @Test
    public void playAddsZombies() {
        assertEquals(8, game.getZombieAI().getZombies().size());
        for (int i = 0; i < 99; i++) {
            game.play();
        }
        assertEquals(0, game.getZombieAI().getZombies().size());
        game.play();
        assertEquals(1, game.getZombieAI().getZombies().size());
    }
    
    
    
    
}