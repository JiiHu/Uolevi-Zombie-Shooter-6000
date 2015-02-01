

package zombie.game;

import zombie.domain.Map;
import zombie.domain.Player;
import zombie.logic.ActorController;
import zombie.logic.BulletController;
import zombie.logic.InputController;
import zombie.logic.LevelController;
import zombie.logic.MapController;
import zombie.logic.ZombieAI;


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
    
    public ZombieGame(int width, int height) {
        this.timePlayed = 0;
        this.zombieTexturesAmount = 5;
        this.player = new Player(width/2, height/2, "assets/player.png");
        this.map = new Map(width, height);
        this.mapController = new MapController(map);
        this.actorController = new ActorController(mapController, player);
        this.zombieAI = new ZombieAI(actorController, player, zombieTexturesAmount);
        this.levelController = new LevelController(zombieAI);
        this.bulletController = new BulletController(mapController);
        this.inputController = new InputController(actorController, player, bulletController);
    }
    
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

    public ZombieAI getZombieAI() {
        return zombieAI;
    }

    public int getZombieTexturesAmount() {
        return zombieTexturesAmount;
    }
    
 
    public Player getPlayer() {
        return player;
    }
    
    public ActorController getActorController() {
        return actorController;
    }
    
    public InputController getInputController() {
        return inputController;
    }
    
}
