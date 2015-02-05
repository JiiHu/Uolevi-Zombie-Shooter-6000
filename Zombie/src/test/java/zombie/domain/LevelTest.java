
package zombie.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LevelTest {
    
    Level level;

    public LevelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        level = new Level(1, 2);
    }

    @After
    public void tearDown() {
    }

    
    @Test
    public void newLevelIncreasesLevelNumber() {
        assertEquals(1, level.getLvlNumber());
        level.newLevel();
        assertEquals(2, level.getLvlNumber());
    }
    
    @Test
    public void zombieKilledDecreasesAmountOfZombiesLeft() {
        assertEquals(2, level.getZombiesLeftOnLevel());
        level.zombieKilled();
        assertEquals(1, level.getZombiesLeftOnLevel());
    }
    
    @Test
    public void zombieReleasedDecreasesAmountOfUnreleasedZombies() {
        assertEquals(2, level.getZombiesUnreleased());
        level.zombieReleased();
        assertEquals(1, level.getZombiesUnreleased());
    }
    
    @Test
    public void isLevelOverWorks() {
        assertEquals(false, level.isLevelOver());
        level.zombieKilled();
        level.zombieKilled();
        assertEquals(true, level.isLevelOver());
    }
    
    @Test
    public void newLevelAddsRightAmountOfZombies() {
        // assumption that multiplier is 1.5
        assertEquals(2, level.getZombieAmount());
        level.newLevel();
        assertEquals(3, level.getZombieAmount());
        level.newLevel();
        assertEquals(4, level.getZombieAmount());
        level.newLevel();
        assertEquals(6, level.getZombieAmount());
    }
    
    

}