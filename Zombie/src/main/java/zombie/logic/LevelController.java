

package zombie.logic;

import zombie.domain.Level;
import zombie.domain.Zombie;

/**
 * Class to control the level changing and releasing zombies
 */
public class LevelController {
    
    private Level level;
    private ZombieAI zombieAI;
    
    public LevelController(ZombieAI zombieAI) {
        level = new Level(0, 0);
        this.zombieAI = zombieAI;
        newLevel();
    }

    /**
     * Method will return the current level number
     * 
     * @return current level number
     */
    public int getLevelNumber() {
        return level.getLvlNumber();
    }
    
    /**
     * Method will release a zombie to the game
     */
    public void releaseZombie() {
        if (!unreleasedZombiesLeft()) {
            return;
        }
        level.zombieReleased();
        zombieAI.addZombie();
    }
    
    /**
     * Method will return boolean whether there are unreleased zombies
     * left on the current level or not
     * 
     * @return are there unreleased zombies left on the level
     */
    public boolean unreleasedZombiesLeft() {
        return level.getZombiesUnreleased() > 0;
    }
    
    /**
     * Method will change the level to the next one
     */
    public void newLevel() {
        level.newLevel();
    }
    
    /**
     * Method will tell the level that a zombie is killed
     */
    public void zombieKilled(Zombie zombie) {
        level.zombieKilled();
        zombieAI.removeZombie(zombie);
        if (level.isLevelOver()) {
            newLevel();
        }
    }
    
    
}
