
package zombie.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {
    
    Tile tile;
    Actor actor;

    @Before
    public void setUp() {
        tile = new Tile(10,10);
        actor = new Actor();
    }
    
    @Test
    public void addActorWorks() {
        assertEquals(0, tile.getActors().size());
        tile.addActor(actor);
        assertEquals(1, tile.getActors().size());
    }
    
    @Test
    public void removeActorWorks() {
        tile.addActor(actor);
        assertEquals(1, tile.getActors().size());
        tile.removeActor(actor);
        assertEquals(0, tile.getActors().size());
    }
    
    @Test
    public void isWalkableWorks() {
        assertTrue(tile.isWalkable());
        tile.setWalkable(false);
        assertFalse(tile.isWalkable());
    }
    
    @Test
    public void colAndRowGetsCorretcly() {
        assertEquals(10, tile.getCol());
        assertEquals(10, tile.getRow());
        
        Tile tile2 = new Tile(5, 5);
        
        assertEquals(5, tile2.getCol());
        assertEquals(5, tile2.getRow());
    }

}