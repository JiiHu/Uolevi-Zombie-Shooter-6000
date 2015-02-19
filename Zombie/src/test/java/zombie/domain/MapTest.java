
package zombie.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MapTest {
    
    Map map;
        
    @Before
    public void setUp() {
        map = new Map(1280, 720);
    }
    
    @Test
    public void generatesRightSizedTilesArray() {
        // divider hardcoded into Map.class
        int divider = 16;
        // presumption that the map is 1280x720 pixels
        int x = 1280/divider;
        int y = 720/divider;
        
        Tile tile1 = map.getTile(x-1, y-1);
        assertFalse(tile1 == null);
        
        Tile tile = map.getTile(x, y);
        assertEquals(null, tile);
        
    }
    
    @Test
    public void returnsNullWhenGettingTileOutOfBounds() {
        assertEquals(null, map.getTile(-1, -1));
    }
    
    @Test
    public void widthAndHeightGetsCorrectly() {
        assertEquals(1280, map.getWidth());
        assertEquals(720, map.getHeight());
        
        Map map2 = new Map(100, 20);
        
        assertEquals(100, map2.getWidth());
        assertEquals(20, map2.getHeight());
    }
    
    @Test
    public void getDividerWorks() {
        // 16 is hardcoded
        assertEquals(16, map.getDivider());
    }
    
}
