
package zombie.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Actor;
import zombie.domain.Direction;
import zombie.domain.Map;
import zombie.domain.Tile;

public class MapControllerTest {
    
    Map map;
    ActorController ac;
    MapController mc;
    Actor actor;
    Tile tile;
    
    @Before
    public void setUp() {
        map = new Map(1280, 720);
        mc = new MapController(map);
        ac = new ActorController(mc);
        actor = new Actor();
        tile = new Tile(10,10);
    }
    
    @Test
    public void trueIfActorsTileIsNull() {
        boolean ans = mc.checkIfInNonWalkableTile(actor);
        assertTrue(ans);
    }
    
    @Test
    public void removesActorFromTileAndTileFromActor() {
        actor.setCurrentTile(tile);
        assertEquals(tile, actor.getCurrentTile());
        
        ac.moveActor(actor, Direction.UP);
        
        int divider = map.getDivider();
        int tileX = (actor.getX() + (actor.getSpriteWidth() / 2)) / divider;
        int tileY = (actor.getY() + (actor.getSpriteHeight() / 2)) / divider;
        
        Tile rightTile = map.getTile(tileX, tileY);
        
        assertEquals(false, rightTile.getActors().isEmpty());
    }
    
}
