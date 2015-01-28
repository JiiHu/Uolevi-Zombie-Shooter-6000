
package zombie.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import zombie.domain.Player;
import static org.junit.Assert.*;
import zombie.domain.Direction;
import zombie.domain.Map;
import zombie.logic.ActorController;

public class ActorControllerTest {
    
    ActorController ac;
    MapController mc;
    Map map;
    Player p;
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
        p = new Player(50, 50, "test");
        speed = p.getSpeed();
    }

    @After
    public void tearDown() {
    }


    @Test
    public void directionUpWorks() {
        int startX = p.getX();
        int startY = p.getY();
        ac.moveActor(p, Direction.UP);
        boolean boolX = p.getX() == startX;
        boolean boolY = p.getY() == startY+speed;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionDownWorks() {
        int startX = p.getX();
        int startY = p.getY();
        ac.moveActor(p, Direction.DOWN);
        boolean boolX = p.getX() == startX;
        boolean boolY = p.getY() == startY-speed;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionLeftWorks() {
        int startX = p.getX();
        int startY = p.getY();
        ac.moveActor(p, Direction.LEFT);
        boolean boolX = p.getX() == startX-speed;
        boolean boolY = p.getY() == startY;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionRightWorks() {
        int startX = p.getX();
        int startY = p.getY();
        ac.moveActor(p, Direction.RIGHT);
        boolean boolX = p.getX() == startX+speed;
        boolean boolY = p.getY() == startY;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }

}