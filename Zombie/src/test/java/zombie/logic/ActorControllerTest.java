
package zombie.logic;

import org.junit.Before;
import org.junit.Test;
import zombie.domain.Player;
import static org.junit.Assert.*;
import zombie.domain.Direction;
import zombie.domain.Map;
import zombie.domain.Zombie;

public class ActorControllerTest {
    
    ActorController ac;
    MapController mc;
    Map map;
    Player player;
    int speed;
    ZombieAI zombieAI;

    @Before
    public void setUp() {
        map = new Map(1280, 720);
        mc = new MapController(map);
        player = new Player(50, 50, "test");
        ac = new ActorController(mc, player);
        speed = player.getSpeed();
        zombieAI = new ZombieAI(ac, player, 5);
    }
    
    @Test
    public void rotatePlayerWorks() {
        assertEquals(0, player.getAngle());
        ac.rotatePlayer(50, 100);
        assertEquals(90, player.getAngle());
    }
    
    @Test
    public void rotateZombieWorks() {
        zombieAI.addZombie();
        Zombie z = zombieAI.getZombies().get(0);
        
       assertEquals(0, z.getAngle());
       player.setX(z.getX());
       player.setY(z.getY()-20);
       ac.rotateZombie(z);
        assertEquals(270, z.getAngle());
    }

    @Test
    public void directionUpWorks() {
        int startX = player.getX();
        int startY = player.getY();
        ac.moveActor(player, Direction.UP);
        boolean boolX = player.getX() == startX;
        boolean boolY = player.getY() == startY+speed;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionDownWorks() {
        int startX = player.getX();
        int startY = player.getY();
        ac.moveActor(player, Direction.DOWN);
        boolean boolX = player.getX() == startX;
        boolean boolY = player.getY() == startY-speed;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionLeftWorks() {
        int startX = player.getX();
        int startY = player.getY();
        ac.moveActor(player, Direction.LEFT);
        boolean boolX = player.getX() == startX-speed;
        boolean boolY = player.getY() == startY;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    
    @Test
    public void directionRightWorks() {
        int startX = player.getX();
        int startY = player.getY();
        ac.moveActor(player, Direction.RIGHT);
        boolean boolX = player.getX() == startX+speed;
        boolean boolY = player.getY() == startY;
        
        assertEquals(boolX, true);
        assertEquals(boolY, true);
    }
    

}