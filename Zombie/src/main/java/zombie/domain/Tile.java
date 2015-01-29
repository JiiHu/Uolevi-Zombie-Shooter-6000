 

package zombie.domain;

import java.util.ArrayList;


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

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public ArrayList<Actor> getActors() {
        return actors;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }
    
    
    public void addActor(Actor actor) {
        this.actors.add(actor);
    }
    
    public void removeActor(Actor actor) {
        this.actors.remove(actor);
    }
    
}
