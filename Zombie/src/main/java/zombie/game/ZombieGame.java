

package zombie.game;

import zombie.domain.Map;
import zombie.domain.Player;
import zombie.logic.ActorController;
import zombie.logic.BulletController;
import zombie.logic.HUDController;
import zombie.logic.InputController;
import zombie.logic.LevelController;
import zombie.logic.MapController;
import zombie.logic.ZombieAI;

/**
 * Class which includes all the information regarding the game
 */
public class ZombieGame {
    
    private Player player;
    private Map map;
    private long timePlayed;
    private int zombieTexturesAmount;
    
    private ZombieAI zombieAI;
    
    private ActorController actorController;
    private MapController mapController;
    private LevelController levelController;
    private InputController inputController;
    private BulletController bulletController;
    private HUDController hud;
    
    public ZombieGame(int width, int height) {
        this.timePlayed = 0;
        this.zombieTexturesAmount = 5;
        this.player = new Player(width/2, height/2, "assets/player.png");
        this.map = new Map(width, height);
        this.mapController = new MapController(map);
        this.actorController = new ActorController(mapController, player);
        this.zombieAI = new ZombieAI(actorController, player, zombieTexturesAmount);
        this.levelController = new LevelController(zombieAI);
        this.bulletController = new BulletController(mapController, levelController);
        this.inputController = new InputController(actorController, player, bulletController);
        this.hud = new HUDController(levelController, player, zombieAI);
    }
    
    /**
     * Method should be called each time something is drawn to the screen
     */
    public void play() {
        timePlayed++;
        zombieAI.moveZombies();
        checkIfZombieShouldBeReleased();
    }

    private void checkIfZombieShouldBeReleased() {
        if (timePlayed % 100 == 0) {
            levelController.releaseZombie();
        }
    }
    
    /**
     * Method returns HUDController
     * 
     * @return HUDController
     */
    public HUDController getHUDController() {
        return hud;
    }
    
    /**
     * Method returns ZombieAI
     * 
     * @return zombieAI
     */
    public ZombieAI getZombieAI() {
        return zombieAI;
    }

    /**
     * Method returns the amount of available zombie textures
     * 
     * @return amount of available zombie textures
     */
    public int getZombieTexturesAmount() {
        return zombieTexturesAmount;
    }
    
    /**
     * Method returns the Player object
     * 
     * @return Player object
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * Method returns InputController of the game
     * 
     * @return InputController of the game
     */
    public InputController getInputController() {
        return inputController;
    }
    
}
