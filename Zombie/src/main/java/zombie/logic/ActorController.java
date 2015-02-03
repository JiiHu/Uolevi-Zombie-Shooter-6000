

package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Direction;
import zombie.domain.Player;
import zombie.domain.Zombie;

/**
 * Class for controlling actors, such as player and zombies
 */
public class ActorController {
    
    private MapController mapController;
    private Player player;
    
    public ActorController(MapController mapController, Player player) {
        this.mapController = mapController;
        this.player = player;
    }
    
    /**
     * Method rotates zombie to face the player
     * 
     * @param   zombie  Zombie to be rotated
     */
    public void rotateZombie(Zombie zombie) {
        int x = player.getX();
        int y = player.getY();
        rotateActor((Actor) zombie, x, y);
    }

    /**
     * Method rotates player to face the given coordinates
     * 
     * @param   x   X axis of the point which player should face
     * @param   y   Y axis of the point which player should face
     */
    public void rotatePlayer(int x, int y) {
        rotateActor(player, x, y);
    }
    
    private void rotateActor(Actor actor, int x, int y) {
        int angle = calculateAngle(x, y, actor.getX(), actor.getY());
        actor.setAngle(angle);
    }
    
    /*
      calculates angle followingly
      -135    -90     -45
      180     x,y     0
      135     90      45    
    */
    private int calculateAngle(int mouseX, int mouseY, int x, int y) {
        int diffX = mouseX - x;
        int diffY = mouseY - y;
        double radians = Math.atan2(diffY, diffX);
        double angle = radians * 180 / Math.PI;
        return editAngleTo360Degrees((int) angle);
    }
    
    private int editAngleTo360Degrees(int angle) {
        if (angle < 0) {
            angle = angle * -1;
        } else {
            angle = 180 + (180-angle);
        }
        return 360-angle;
    }
    
    /**
     * Method moves actor to the given direction
     * <p>
     * Will automatically revert the movement if the actor 
     * goes to the non-walkable area
     * 
     * @param   actor   Actor to be moved
     * @param   direction Direction to which actor should go
     */
    public void moveActor(Actor actor, Direction direction) {
        makeMovement(actor, direction);    
        mapController.updateActorsTile(actor);
        
        boolean wasAbleToWalk = mapController.checkIfInWalkableTile(actor);
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
