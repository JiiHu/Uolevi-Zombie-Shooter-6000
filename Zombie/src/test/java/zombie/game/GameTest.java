package zombie.game;


import zombie.game.ZombieGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    ZombieGame game;

    public GameTest() {
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

}