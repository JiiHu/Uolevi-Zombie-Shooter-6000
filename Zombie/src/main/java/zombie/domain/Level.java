

package zombie.domain;


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
    
    public boolean isLevelOver() {
        return zombiesLeftOnLevel == 0;
    }

    public void zombieKilled() {
        zombiesLeftOnLevel--;
    }
    
    public void zombieReleased() {
        zombiesUnreleased--;
    }

    public int getZombiesUnreleased() {
        return zombiesUnreleased;
    }
    
    public void newLevel() {
        lvlNumber++;
        zombieAmount += increment;
        zombiesLeftOnLevel = zombieAmount;
        zombiesUnreleased = zombieAmount;
    }

    public int getZombieAmount() {
        return zombieAmount;
    }

    public void setZombieAmount(int zombieAmount) {
        this.zombieAmount = zombieAmount;
    }

    public int getLvlNumber() {
        return lvlNumber;
    }

    public int getZombiesLeftOnLevel() {
        return zombiesLeftOnLevel;
    }

}
