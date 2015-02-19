

package zombie.logic;

import zombie.domain.Level;
import zombie.domain.Player;

/**
 * Class for easy access to the all data which can be shown on the heads-up display
 */
public class HUDController {
    
    private LevelController levelController;
    private ZombieAI zombieAI;
    private Player player;
    
    public HUDController(LevelController levelController, Player player, ZombieAI zombieAI) {
        this.levelController = levelController;
        this.player = player;
        this.zombieAI = zombieAI;
    }
    
    /**
     * Method returns current level number
     * 
     * @return current level number
     */
    public int levelNumber() {
        return levelController.getLevelNumber();
    }
    
    /**
     * Method returns amount of killed zombies
     * 
     * @return amount of killed zombies
     */
    public int zombiesKilled() {
        return zombieAI.getZombiesKilled();
    }
    
    /**
     * Method returns Player's Hp and its MaxHp
     * 
     * @return Player's Hp and its MaxHp
     */
    public String playerHp() {
        return player.getHp() + " / " + player.getMaxHp();
    }

}
