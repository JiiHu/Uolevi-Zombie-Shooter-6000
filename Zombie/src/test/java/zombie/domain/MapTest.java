
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
        int divider = 10;
        // presumption that the map is 1280x720 pixels
        int x = 1280/divider;
        int y = 720/divider;
        
        try {
            map.getTile(x-1, y-1);
        } catch(Exception e) {
            assertTrue(false);
        }
        
        try {
            map.getTile(x, y);
            // if the test goes to next line the tile array
            // was too big because it didn't throw error
            assertTrue(false);
        } catch(Exception e) {
            assertTrue(true);
        }
        
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
        // 10 is hardcoded
        assertEquals(10, map.getDivider());
    }
    
}
