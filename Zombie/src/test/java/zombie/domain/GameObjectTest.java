
package zombie.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameObjectTest {
    
    GameObject go;

    @Before
    public void setUp() {
        go = new GameObject();
        go.setX(100);
        go.setY(100);
        go.setSpriteHeight(20);
        go.setSpriteWidth(20);
    }
    
    @Test
    public void setCentersWorksAfterSettingSpriteSize() {
        assertEquals(110, go.getCenterX());
        assertEquals(110, go.getCenterY());
        
        go.setSpriteHeight(40);
        go.setSpriteWidth(40);
        
        assertEquals(120, go.getCenterX());
        assertEquals(120, go.getCenterY());
        
    }
    
    
    @Test
    public void defaultAngleIsZero() {
        assertEquals(0, go.getAngle());
    }
    
    @Test
    public void getTextureAsIntReturnsCorrectValue() {
        go.setTexture("1");
        assertEquals(1, go.getTextureAsInt());
        go.setTexture("5");
        assertEquals(5, go.getTextureAsInt());
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
    
    @Test
    public void spriteSizesGetAndSetWork() {
        go.setSpriteHeight(10);
        assertEquals(10, go.getSpriteHeight());
        go.setSpriteHeight(5);
        assertEquals(5, go.getSpriteHeight());
 
        go.setSpriteWidth(10);
        assertEquals(10, go.getSpriteWidth());
        go.setSpriteWidth(5);
        assertEquals(5, go.getSpriteWidth());
    }
    
    

}