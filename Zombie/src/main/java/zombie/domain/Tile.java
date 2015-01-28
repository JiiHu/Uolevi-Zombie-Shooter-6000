

package zombie.domain;

import java.util.ArrayList;


public class Tile {
    
    private ArrayList<Actor> actors;
    private boolean walkable;
    
    public Tile() {
        this.walkable = true;
        this.actors = new ArrayList<Actor>();
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
    
    
    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
    
    public void addActor(Actor actor) {
        this.actors.add(actor);
    }
    
    public void removeActor(Actor actor) {
        this.actors.remove(actor);
    }
    
}
