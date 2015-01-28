
package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Map;
import zombie.domain.Tile;


public class MapController {
    
    private Map map;
    
    public MapController(Map map) {
        this.map = map;
    }
    
    public void updateActorsTile(Actor actor) {
        int divider = map.getDivider();
        int tileX = calculateTile(actor.getX(), actor.getSpriteWidth(), divider);
        int tileY = calculateTile(actor.getY(), actor.getSpriteHeight(), divider);
        
        removeActorFromTile(actor);
        setNewTileToActor(actor, tileX, tileY);
    }
    
    private int calculateTile(int pixels, int spriteSize, int divider) {
        return (pixels + (spriteSize / 2)) / divider; 
    }
    
    private void removeActorFromTile(Actor actor) {
        if (actor.getCurrentTile() == null) {
            return;
        }
        Tile oldTile = actor.getCurrentTile();
        oldTile.removeActor(actor);
        actor.setCurrentTile(null);
    }

    private void setNewTileToActor(Actor actor, int tileX, int tileY) {
        Tile newTile = map.getTile(tileX, tileY);
        actor.setCurrentTile(newTile);
        newTile.addActor(actor);
    }

    public boolean checkIfInNonWalkableTile(Actor actor) {
        Tile tile = actor.getCurrentTile();
        if (tile == null) {
            return true;
        }
        return tile.isWalkable();
    }
   
    
    
}
