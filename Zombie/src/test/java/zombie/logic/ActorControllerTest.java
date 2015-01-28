
package zombie.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import zombie.domain.Player;
import static org.junit.Assert.*;
import zombie.domain.Actor;
import zombie.domain.Direction;
import zombie.domain.Map;
import zombie.domain.Tile;
import zombie.logic.ActorController;

public class ActorControllerTest {
    
    ActorController ac;
    MapController mc;
    Map map;
    Actor person;
    int speed;

    public ActorControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        map = new Map(1280, 720);
        mc = new MapController(map);
        ac = new ActorController(mc);
        person = new Player(50, 50, "test");
        speed = person.getSpeed();
    }

    @After
    public void tearDown() {
    }
    

    @Test
    public void directionUpWorks() {
        int startX = person.getX();
        int startY = person.getY();
        ac.moveActor(person, Direction.UP);
        boolean boolX = person.getX() == startX;
        boolean boolY = person.getY() == startY+speed;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionDownWorks() {
        int startX = person.getX();
        int startY = person.getY();
        ac.moveActor(person, Direction.DOWN);
        boolean boolX = person.getX() == startX;
        boolean boolY = person.getY() == startY-speed;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionLeftWorks() {
        int startX = person.getX();
        int startY = person.getY();
        ac.moveActor(person, Direction.LEFT);
        boolean boolX = person.getX() == startX-speed;
        boolean boolY = person.getY() == startY;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionRightWorks() {
        int startX = person.getX();
        int startY = person.getY();
        ac.moveActor(person, Direction.RIGHT);
        boolean boolX = person.getX() == startX+speed;
        boolean boolY = person.getY() == startY;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    

}