

package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Direction;

public class ActorController {
    
    private MapController mapController;
    
    public ActorController(MapController mapController) {
        this.mapController = mapController;
    }
    
    public void moveActor(Actor actor, Direction direction) {
        makeMovement(actor, direction);    
        mapController.updateActorsTile(actor);
        
        boolean wasAbleToWalk = mapController.checkIfInNonWalkableTile(actor);
        if (!wasAbleToWalk) {
            revertMovement(actor, direction);
        }
    }

    private void makeMovement(Actor actor, Direction direction) {
        if (direction == Direction.UP) {
            actor.moveUp();
        } else if (direction == Direction.DOWN) {
            actor.moveDown();
        } else if (direction == Direction.LEFT) {
            actor.moveLeft();
        } else if (direction == Direction.RIGHT) {
            actor.moveRight();
        }
     }
    
    private void revertMovement(Actor actor, Direction direction) {
        makeMovement(actor, oppositeDirection(direction));
    }
    
    private Direction oppositeDirection(Direction direction) {
        if (direction == Direction.UP) {
            return Direction.DOWN;
        } else if (direction == Direction.DOWN) {
            return Direction.UP;
        } else if (direction == Direction.LEFT) {
            return Direction.RIGHT;
        } else {
            return Direction.LEFT;
        }
    }

}
