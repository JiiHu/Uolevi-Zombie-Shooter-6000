 

package zombie.domain;

import java.util.ArrayList;

/**
 * Class contains information about certain piece of map
 */
public class Tile {
    
    private ArrayList<Actor> actors;
    private boolean walkable;
    private int row;
    private int col;
    
    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        this.walkable = true;
        this.actors = new ArrayList<Actor>();
    }

    /**
     * Method returns the row on which the Tile is on the Map
     * 
     * @return number of the row which the Tile is on
     */
    public int getRow() {
        return row;
    }

    /**
     * Method returns the column on which the Tile is on the Map
     * 
     * @return number of the column which the Tile is on
     */
    public int getCol() {
        return col;
    }
    
    /**
     * Method returns list of actors which are currently on the Tile
     * 
     * @return ArrayList of Actors in the Tile
     */
    public ArrayList<Actor> getActors() {
        return actors;
    }

    /**
     * Method returns boolean whether the Tile is walkable or not
     * 
     * @return boolean whether the Tile is walkable or not
     */
    public boolean isWalkable() {
        return walkable;
    }

    /**
     * Method changes Tile's walkable value to boolean provided
     * 
     * @param walkable boolean whether the Tile should be walkable or not
     */
    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }
    
    /**
     * Method adds Actor to the Tile
     * 
     * @param actor Actor which is currently in the Tile
     */
    public void addActor(Actor actor) {
        this.actors.add(actor);
    }
    
    /**
     * Method removes Actor from the Tile
     * 
     * @param actor Actor which should be removed from the Tile
     */
    public void removeActor(Actor actor) {
        this.actors.remove(actor);
    }
    
}
