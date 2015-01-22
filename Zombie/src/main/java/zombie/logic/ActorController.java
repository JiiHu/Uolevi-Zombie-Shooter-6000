

package zombie.logic;

import zombie.domain.Actor;

public class ActorController {
    
    public ActorController() {
        
    }
    
    public void moveActor(Actor actor, String direction) {
        if (direction.equals("UP")) {
            actor.moveUp();
        } else if (direction.equals("DOWN")) {
            actor.moveDown();
        } else if (direction.equals("LEFT")) {
            actor.moveLeft();
        } else if (direction.equals("RIGHT")) {
            actor.moveRight();
        }
    }
    
}
