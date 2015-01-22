
package zombie.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import zombie.domain.Player;
import static org.junit.Assert.*;
import zombie.logic.ActorController;

public class ActorControllerTest {
    
    ActorController ac;
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
        ac = new ActorController();
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
        ac.moveActor(p, "UP");
        boolean boolX = p.getX() == startX;
        boolean boolY = p.getY() == startY+speed;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionDownWorks() {
        int startX = p.getX();
        int startY = p.getY();
        ac.moveActor(p, "DOWN");
        boolean boolX = p.getX() == startX;
        boolean boolY = p.getY() == startY-speed;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionLeftWorks() {
        int startX = p.getX();
        int startY = p.getY();
        ac.moveActor(p, "LEFT");
        boolean boolX = p.getX() == startX-speed;
        boolean boolY = p.getY() == startY;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionRightWorks() {
        int startX = p.getX();
        int startY = p.getY();
        ac.moveActor(p, "RIGHT");
        boolean boolX = p.getX() == startX+speed;
        boolean boolY = p.getY() == startY;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }

}