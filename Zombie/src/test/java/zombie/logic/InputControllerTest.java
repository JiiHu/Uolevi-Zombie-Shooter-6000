
package zombie.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Direction;
import zombie.domain.Map;
import zombie.domain.Player;

public class InputControllerTest {

    InputController ic;
    
    ActorController ac;
    MapController mc;
    BulletController bc;
    Map map;
    Player player;
    
    @Before
    public void setUp() {
        map = new Map(1000,1000);
        mc = new MapController(map);
        player = new Player(500,500,"test");
        ac = new ActorController(mc, player);
        bc = new BulletController(mc);
        
        ic = new InputController(ac, player, bc);
    }

    
    @Test
    public void movePlayerWorks() {
        int x = player.getX();
        int y = player.getY();
        ic.movePlayer(Direction.UP);
        ic.movePlayer(Direction.RIGHT);
        assertTrue(player.getX() > x);
        assertTrue(player.getY() > y);
    }
    
    @Test
    public void mousePositionWorks() {
        int angle = player.getAngle();
        ic.mousePosition(100, 100);
        assertTrue(angle != player.getAngle());
    }

}