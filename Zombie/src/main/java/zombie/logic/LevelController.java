

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
        this.zombieAI = zombieAI;
        makeLevel();
    }

    private void makeLevel() {
        level = new Level(0, 4);
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
     * Method returns Level object
     * 
     * @return object containing level information
     */
    public Level getLevel() {
        return level;
    }
    
    private boolean isLevelOver() {
        return level.isLevelOver();
    }
    
    /**
     * Method will tell to Level and ZombieAI objects that a zombie 
     * is killed and checks if new level should be changed
     */
    public void zombieKilled(Zombie zombie) {
        level.zombieKilled();
        zombieAI.removeZombie(zombie);
        if (isLevelOver()) {
            newLevel();
        }
    }

    /**
     * Method will reset the Level
     */
    public void resetLevel() {
        makeLevel();
    }
    
    
}
