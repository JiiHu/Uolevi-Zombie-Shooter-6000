
package zombie.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BulletTest {
    
    Bullet b;

    @Before
    public void setUp() {
        b = new Bullet(40, 50, 90, 100);
    }


    @Test
    public void getAndSetXWorks() {
        assertEquals(40, b.getX());
        b.setX(70);
        assertEquals(70, b.getX());
    }
    
    @Test
    public void getAndSetYWorks() {
        assertEquals(50, b.getY());
        b.setY(80);
        assertEquals(80, b.getY());
    }
    
    @Test
    public void getAngleWorks() {
        assertEquals(90, b.getAngle());
    }
    
    @Test
    public void getEffectivityWorks() {
        assertEquals(100, b.getEffectivity());
    }

}