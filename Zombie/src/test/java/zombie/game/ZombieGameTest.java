package zombie.game;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Zombie;
import zombie.logic.ActorController;
import zombie.logic.HUDController;
import zombie.logic.InputController;

public class ZombieGameTest {
    
    ZombieGame game;

    @Before
    public void setUp() {
        game = new ZombieGame(1000, 1000);
    }

    @Test
    public void getHUDControllerWorks() {
        assertEquals(HUDController.class, game.getHUDController().getClass());
    }

    @Test
    public void getInputControllerWorks() {
        assertEquals(InputController.class, game.getInputController().getClass());
    }

    @Test
    public void getZombieTexturesAmountWorks() {
        // value 5 is hardcoded at the moment
        assertEquals(5, game.getZombieTexturesAmount());
    }

    @Test
    public void playerGoesCenterOfTheScreen() {
        assertEquals(500, game.getPlayer().getX());
        assertEquals(500, game.getPlayer().getY());
    }
    

    @Test
    public void playMovesZombies() {
        for (int i = 0; i < 300; i++) {
            game.play();
        }
        Zombie z = game.getZombieAI().getZombies().get(0);
        int x = z.getX();
        int y = z.getY();
        game.play();
        assertTrue(x != z.getX());
        assertTrue(y != z.getY());
    }
    
    @Test
    public void playWorks() {
        assertEquals(0, game.getZombieAI().getZombies().size());
        for (int i = 0; i < 299; i++) {
            game.play();
        }
        assertEquals(0, game.getZombieAI().getZombies().size());
        game.play();
        assertEquals(1, game.getZombieAI().getZombies().size());
    }
    
    
    
}