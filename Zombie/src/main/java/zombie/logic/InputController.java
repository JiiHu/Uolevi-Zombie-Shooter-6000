

package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Direction;
import zombie.domain.Player;
import zombie.domain.Zombie;


public class InputController {
    
    private Player player;
    private ActorController actorController;
    private BulletController bulletController;
    
    public InputController(ActorController ac, Player player, BulletController bulletController) {
        this.player = player;
        this.actorController = ac;
        this.bulletController = bulletController;
    }
    
    public void movePlayer(Direction direction) {
        actorController.moveActor(player, direction);
    }
    
    public void mousePosition(int x, int y) {
        actorController.rotatePlayer(x, y);
    }
    
    public void mouseClicked(int x, int y) {
        int angle = player.getAngle();
        bulletController.bulletShot(x, y, angle);
    }
    
}
