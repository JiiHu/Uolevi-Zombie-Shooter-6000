

package zombie.logic;

import zombie.domain.Actor;
import zombie.domain.Direction;
import zombie.domain.Player;
import zombie.domain.Zombie;

/**
 * Class to control the input from the real-life player
 */
public class InputController {
    
    private Player player;
    private ActorController actorController;
    private BulletController bulletController;
    
    public InputController(ActorController ac, Player player, BulletController bulletController) {
        this.player = player;
        this.actorController = ac;
        this.bulletController = bulletController;
    }
    
    /**
     * Method will move the player to the direction which is given to the controller
     * 
     * @param   direction   Direction to which the player should go
     */
    public void movePlayer(Direction direction) {
        if (player.isDead()) {
            return;
        }
        actorController.moveActor(player, direction);
    }
    
    /**
     * Method is given mouse coordinates at the moment 
     * and it will rotate the player to face the mouse
     * 
     * @param   x   Mouse's coordinate on the X axis
     * @param   y   Mouse's coordinate on the Y axis
     */
    public void mousePosition(int x, int y) {
        if (player.isDead()) {
            return;
        }
        actorController.rotatePlayer(x, y);
    }
    
    /**
     * Method will fire a bullet to the given coordinates
     * 
     * @param   x   Mouse's position on the X axis when the mouse is clicked
     * @param   y   Mouse's position on the Y axis when the mouse is clicked
     */
    public void mouseClicked(int x, int y) {
        if (player.isDead()) {
            return;
        }
        int angle = player.getAngle();
        bulletController.bulletShot(x, y, angle);
    }
    
}
