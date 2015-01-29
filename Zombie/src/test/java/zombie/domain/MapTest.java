
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
    public void widthAndHeightGetsCorrectly() {
        assertEquals(1280, map.getWidth());
        assertEquals(720, map.getHeight());
        
        Map map2 = new Map(100, 20);
        
        assertEquals(100, map2.getWidth());
        assertEquals(20, map2.getHeight());
    }
    
    @Test
    public void dividerSetsAndGetsCorrectly() {
        map.setDivider(2);
        assertEquals(2, map.getDivider());
        map.setDivider(4);
        assertEquals(4, map.getDivider());
    }
    
}
