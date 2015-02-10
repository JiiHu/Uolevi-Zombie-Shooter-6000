
package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Map;
import zombie.domain.Player;
import zombie.domain.Tile;
import zombie.domain.Zombie;

/**
 * Class to control the map
 */
public class MapController {
    
    private Map map;
    private int divider;
    
    public MapController(Map map) {
        this.map = map;
        this.divider = map.getDivider();
    }
    
    /**
     * Method will update an Actor's Tile to the one which it is on at the moment
     * 
     * @param   actor   Actor which Tile should be updated
     */
    public void updateActorsTile(Actor actor) {
        int tileX = calculateTile(actor.getX(), actor.getSpriteWidth(), divider);
        int tileY = calculateTile(actor.getY(), actor.getSpriteHeight(), divider);
        
        removeActorFromTile(actor);
        setNewTileToActor(actor, tileX, tileY);
    }
    
    /**
     * Method will check is there some Actor on the tile which is on the given coordinates
     * 
     * @param   x   Coordinate of the X axis
     * @param   y   Coordinate of the Y axis
     * @return 
     */
    public Actor checkIfSomethingIsInTile(int x, int y) {
        int tileX = calculateTile(x, 1, divider);
        int tileY = calculateTile(y, 1, divider);
        return checkTile(tileX, tileY);
    }
    
    private Actor checkTile(int col, int row) {
        Tile tile = map.getTile(col, row);
        if (tile == null || tile.getActors().isEmpty()) {
            return null;
        }
        return tile.getActors().get(0);
    }
    
    /**
     * Method for checking if something (Zombie) is next to the player
     * 
     * @param   x   Coordinate in pixels on X axis
     * @param   y   Coordinate in pixels on Y axis
     * @return is player in the Tile next to coordinates
     */
    public boolean checkIfPlayerIsInTileOrTileNextToIt(int x, int y) {
        int col = calculateTile(x, 1, divider);
        int row = calculateTile(y, 1, divider);
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                Actor actor = checkTile(row+i, col+j);
                if (actor != null && actor instanceof Player) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Method for checking if Zombie is next to the player
     * 
     * @param   z   zombie which position is checked
     * @return is player close to the zombie
     */
    public boolean checkIfPlayerIsInTileOrTileNextToIt(Zombie z) {
        return checkIfPlayerIsInTileOrTileNextToIt(z.getX(), z.getY());
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

    /**
     * Method will tell whether is the given actor in walkable tile
     * 
     * @param   actor   Actor which currentTile is checked
     * @return boolean whether the currentTile is walkable
     */
    public boolean checkIfInWalkableTile(Actor actor) {
        Tile tile = actor.getCurrentTile();
        if (tile == null) {
            return true;
        }
        return tile.isWalkable();
    }
}
