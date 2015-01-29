
package zombie.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {
    
    Tile tile;

    @Before
    public void setUp() {
        tile = new Tile(10,10);
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