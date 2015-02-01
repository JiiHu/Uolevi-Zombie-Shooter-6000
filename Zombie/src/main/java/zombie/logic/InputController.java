

package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Direction;
import zombie.domain.Player;
import zombie.domain.Zombie;


public class InputController {
    
    private Player player;
    private ActorController actorController;
    
    public InputController(ActorController ac, Player player) {
        this.player = player;
        this.actorController = ac;
    }
    
    public void movePlayer(Direction direction) {
        actorController.moveActor(player, direction);
    }
    
    public void mousePosition(int x, int y) {
        actorController.rotatePlayer(x, y);
    }
    
}
