

package zombie.logic;

import zombie.domain.Level;


public class LevelController {
    
    private Level level;
    private ZombieAI zombieAI;
    
    public LevelController(ZombieAI zombieAI) {
        level = new Level(0, 0);
        this.zombieAI = zombieAI;
        newLevel();
    }

    public int getLevelNumber() {
        return level.getLvlNumber();
    }
    
    public void releaseZombie() {
        if (!unreleasedZombiesLeft()) {
            return;
        }
        level.zombieReleased();
        zombieAI.addZombie();
    }
    
    public boolean unreleasedZombiesLeft() {
        return level.getZombiesUnreleased() > 0;
    }
    
    public void newLevel() {
        level.newLevel();
    }
    
    public void zombieKilled() {
        level.zombieKilled();
        if (level.isLevelOver()) {
            newLevel();
        }
    }
    
    
}
