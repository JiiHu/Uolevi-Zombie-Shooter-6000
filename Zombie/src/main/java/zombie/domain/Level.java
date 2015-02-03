

package zombie.domain;

/**
 * Class to hold information about current levels variables
 */
public class Level {
    
    private int zombieAmount;
    private int lvlNumber;
    private int zombiesLeftOnLevel;
    private int zombiesUnreleased;
    private int increment;
    
    public Level(int lvlNumber, int zombieAmount) { 
        this.zombieAmount = zombieAmount;
        this.lvlNumber = lvlNumber;
        this.zombiesLeftOnLevel = zombieAmount;
        this.zombiesUnreleased = zombieAmount;
        this.increment = 8;
    }
    
    /**
     * Method tells whether the current level is over or not,
     * that is that is there zombies left which aren't killed
     * 
     * @return is the current level over 
     */
    public boolean isLevelOver() {
        return zombiesLeftOnLevel == 0;
    }

    /**
     * Method should be called every time zombie is killed
     */
    public void zombieKilled() {
        zombiesLeftOnLevel--;
    }
    
    /**
     * Method should be called every time a zombie is released
     */
    public void zombieReleased() {
        zombiesUnreleased--;
    }

    /**
     * Method returns how many zombies are waiting to be released
     * on current level
     * 
     * @return amount of zombies which aren't yet released on the current level
     */
    public int getZombiesUnreleased() {
        return zombiesUnreleased;
    }
    
    /**
     * Method should be called when the level is changed
     */
    public void newLevel() {
        lvlNumber++;
        zombieAmount += increment;
        zombiesLeftOnLevel = zombieAmount;
        zombiesUnreleased = zombieAmount;
    }

    /**
     * Method returns the total amount of zombies on current level
     * 
     * @return amount of zombies on current level
     */
    public int getZombieAmount() {
        return zombieAmount;
    }

    /**
     * Method sets new amount of zombies to the current level
     * 
     * @param   zombieAmount    new amount of zombies
     */
    public void setZombieAmount(int zombieAmount) {
        this.zombieAmount = zombieAmount;
    }
    
    /**
     * Method returns current level number
     * 
     * @return current level number
     */
    public int getLvlNumber() {
        return lvlNumber;
    }

    /**
     * Method returns the amount of zombies on the current level
     * which aren't killed yet
     * 
     * @return the amount of zombies which are left on the current level
     */
    public int getZombiesLeftOnLevel() {
        return zombiesLeftOnLevel;
    }

}
