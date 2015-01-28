

package zombie.game;

import zombie.domain.Map;
import zombie.domain.Player;
import zombie.domain.Zombie;
import zombie.logic.ActorController;
import zombie.logic.LevelController;
import zombie.logic.MapController;
import zombie.logic.ZombieAI;


public class ZombieGame {
    
    private Player player;
    private Map map;
    private long timePlayed;
    
    private ZombieAI zombieAI;
    
    private ActorController actorController;
    private MapController mapController;
    private LevelController levelController;
    
    public ZombieGame(int width, int height) {
        this.timePlayed = 0;
        this.player = new Player(width/2, height/2, "assets/player.png");
        this.map = new Map(width, height);
        this.mapController = new MapController(map);
        this.actorController = new ActorController(mapController);
        this.zombieAI = new ZombieAI(actorController, player);
        this.levelController = new LevelController(zombieAI);
    }
    
    public void play() {
        timePlayed++;
        zombieAI.moveZombies();
        if (timePlayed % 100 == 0) {
            levelController.releaseZombie();
        }
    }

    public ZombieAI getZombieAI() {
        return zombieAI;
    }
    
 
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public ActorController getActorController() {
        return actorController;
    }
    
}
