package zombie.game;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Player;
import zombie.domain.Zombie;
import zombie.logic.HUDController;
import zombie.logic.InputController;

public class ZombieGameTest {
    
    ZombieGame game;

    @Before
    public void setUp() {
        game = new ZombieGame(1000, 1000);
    }

    @Test
    public void playerHpIsIncreasedAutomatically() {
        Player player = game.getPlayer();
        player.decreaseHp(5);
        assertEquals(95, player.getHp());
        for (int i = 0; i < 300; i++) {
            game.play();
        }
        assertEquals(97, player.getHp());
    }

    @Test
    public void resetEverythingResetsEverything() {
        game.getZombieAI().addZombie();
        Player p = game.getPlayer();
        p.decreaseHp(50);
        p.setX(50);
        p.setY(50);
        
        game.resetEverything();
        
        assertEquals(0, game.getZombieAI().getZombies().size());
        assertEquals(100, p.getHp());
        assertEquals(500, p.getX());
        assertEquals(500, p.getY());
    }

    @Test
    public void hasStartedReturnsTrueWhenGameHasStarted() {
        assertFalse(game.hasStarted());
        for (int i = 0; i < 250; i++) {
            game.hasStarted();
        }
        assertTrue(game.hasStarted());
    }

    @Test
    public void playReturnsTrueOnStart() {
        assertEquals(true, game.play());
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