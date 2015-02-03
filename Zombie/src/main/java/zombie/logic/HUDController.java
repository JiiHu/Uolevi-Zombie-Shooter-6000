

package zombie.logic;

import zombie.domain.Player;

/**
 * Class for easy access to the all data which can be shown to the heads-up display
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

}
