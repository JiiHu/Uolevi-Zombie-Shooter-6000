

package zombie;

import zombie.domain.Player;
import zombie.logic.ActorController;


public class Game {
    
    private Player player;
    private int width;
    private int height;
    private ActorController actorController;
    
    public Game(int width, int height) {
        this.player = new Player(width/2, height/2, "assets/player.png");
        this.actorController = new ActorController();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ActorController getActorController() {
        return actorController;
    }

    public void setActorController(ActorController actorController) {
        this.actorController = actorController;
    }
    
    
    
}
