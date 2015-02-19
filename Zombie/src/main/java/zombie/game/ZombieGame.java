

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
    
    private long timePlayed;
    private int zombieTexturesAmount;
    
    private Player player;
    private HUDController hud;
    private ZombieAI zombieAI;
    private InputController inputController;
    private LevelController levelController;
    
    public ZombieGame(int width, int height) {
        this.timePlayed = 0;
        this.zombieTexturesAmount = 5;
        this.player = new Player(width/2, height/2, "assets/player.png");
        
        Map map = new Map(width, height);
        MapController mapController = new MapController(map);
        ActorController actorController = new ActorController(mapController, player);
        this.zombieAI = new ZombieAI(actorController, mapController, player, zombieTexturesAmount);
        this.levelController = new LevelController(zombieAI);
        BulletController bulletController = new BulletController(mapController, levelController);
        this.inputController = new InputController(actorController, player, bulletController);
        this.hud = new HUDController(levelController, player, zombieAI);
        
        mapController.updateActorsTile(player);
    }
    
    /**
     * Method should be called each time something is drawn to the screen
     */
    public boolean play() {
        if (player.isDead()) {
            return false;
        }
        timePlayed++;
        zombieAI.moveZombies();
        checkIfZombieShouldBeReleased();
        return true;
    }
    
    /**
     * Method checks if right amount of time has passed so that zombie can be released
     */
    private void checkIfZombieShouldBeReleased() {
        if (timePlayed % 300 == 0) {
            player.increaseHp(2);
            int lvlNumber = hud.levelNumber();
            for (int i = 0; i < lvlNumber; i++) {
                levelController.releaseZombie();
            }
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
