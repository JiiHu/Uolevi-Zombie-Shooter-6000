
package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Map;
import zombie.domain.Tile;


public class MapController {
    
    private Map map;
    private int divider;
    
    public MapController(Map map) {
        this.map = map;
        this.divider = map.getDivider();
    }
    
    public void updateActorsTile(Actor actor) {
        int tileX = calculateTile(actor.getX(), actor.getSpriteWidth(), divider);
        int tileY = calculateTile(actor.getY(), actor.getSpriteHeight(), divider);
        
        removeActorFromTile(actor);
        setNewTileToActor(actor, tileX, tileY);
    }
    
    public Actor checkIfSomethingIsInSameTile(int x, int y) {
        int tileX = calculateTile(x, 1, divider);
        int tileY = calculateTile(y, 1, divider);
        Tile tile = map.getTile(tileX, tileY);
        if (tile.getActors().isEmpty()) {
            return null;
        }
        return tile.getActors().get(0);
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
