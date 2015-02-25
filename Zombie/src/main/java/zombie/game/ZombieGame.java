

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
    private boolean hasStarted;
    
    private int width;
    private int height;
    
    private Player player;
    private HUDController hud;
    private ZombieAI zombieAI;
    private InputController inputController;
    private LevelController levelController;
    private MapController mapController;
    
    public ZombieGame(int width, int height) {
        this.width = width;
        this.height = height;
        
        this.timePlayed = 0;
        this.zombieTexturesAmount = 5;
        this.hasStarted = false;
        this.player = new Player(width / 2, height / 2, "assets/player.png");
        
        Map map = new Map(width, height);
        this.mapController = new MapController(map);
        ActorController actorController = new ActorController(mapController, player);
        this.zombieAI = new ZombieAI(actorController, mapController, player, zombieTexturesAmount);
        this.levelController = new LevelController(zombieAI);
        BulletController bulletController = new BulletController(mapController, levelController);
        this.inputController = new InputController(actorController, player, bulletController);
        this.hud = new HUDController(levelController, player, zombieAI);
        
        mapController.updateActorsTile(player);
    }

    /**
     * Method returns has the game started
     * 
     * @return has the game started
     */
    public boolean hasStarted() {
        timePlayed++;
        if (timePlayed > 250) {
            startGame();
        }
        return hasStarted;
    }
    
    /**
     * Method starts the game
     */
    private void startGame() {
        this.hasStarted = true;
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
            levelController.addZombiesToReleasingQueue(lvlNumber);
        }
        if (timePlayed % 40 == 0) {
            levelController.releaseZombieFromQueue();
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
    
    /**
     * Method resets the game so that it can be started from scratch
     */
    public void resetEverything() {
        this.zombieAI.resetZombies();
        this.levelController.resetLevel();
        this.player.setHp(100);
        this.player.setAlive();
        this.player.setX(width / 2);
        this.player.setY(height / 2);
        this.mapController.updateActorsTile(player);
    }
    
}
