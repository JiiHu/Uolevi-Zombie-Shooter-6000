
package zombie.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlaceTest {

    @Test
    public void getsCorrectValues() {
        Place place = new Place(10, 10);
        assertEquals(10, place.getX());
        assertEquals(10, place.getY());
        
        Place place2 = new Place(150, 150);
        assertEquals(150, place2.getX());
        assertEquals(150, place2.getY());
        
    }

}