
package zombie.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameObjectTest {
    
    GameObject go;

    public GameObjectTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        go = new GameObject();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void xSetsAndGetsCorrectly() {
        go.setX(10);
        assertEquals(10, go.getX());
        go.setX(5);
        assertEquals(5, go.getX());
    }
    
    @Test
    public void ySetsAndGetsCorrectly() {
        go.setY(10);
        assertEquals(10, go.getY());
        go.setY(5);
        assertEquals(5, go.getY());
    }
    
    @Test
    public void textureSetsAndGetsCorrectly() {
        go.setTexture("jee");
        assertEquals("jee", go.getTexture());
        go.setTexture("lol");
        assertEquals("lol", go.getTexture());
    }

}