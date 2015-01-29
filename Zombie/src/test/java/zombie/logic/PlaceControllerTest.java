
package zombie.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Place;

public class PlaceControllerTest {
    
    PlaceController pc;

    @Before
    public void setUp() {
        pc = new PlaceController();
    }

    
    @Test
    public void getRandomPlaceReturnsPlace() {
        assertEquals(Place.class, pc.getRandomPlace().getClass());
    }

}