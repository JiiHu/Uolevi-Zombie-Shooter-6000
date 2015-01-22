package zombie.domain;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zombie.domain.Actor;


public class ActorTest {
    
    Actor person;
    
    public ActorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        person = new Actor();
        person.setMaxHp(50);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getHpReturnsCorrectValue() {
        assertEquals(0, person.getHp());
        person.setHp(10);
        assertEquals(10, person.getHp());
        person.setHp(15);
        assertEquals(15, person.getHp());
    }
    
    @Test
    public void maxHpSetsAndGetsCorrectValue() {
        person.setMaxHp(100);
        assertEquals(100, person.getMaxHp());
        person.setMaxHp(50);
        assertEquals(50, person.getMaxHp());
    }
    
    @Test
    public void hpSetsAndGetsRightValue() {
        person.setMaxHp(100);
        person.setHp(50);
        assertEquals(50, person.getHp());
        person.setHp(100);
        assertEquals(100, person.getHp());
    }
    
    @Test
    public void cantSetNegativeMaxHp() {
        person.setMaxHp(100);
        person.setMaxHp(-1);
        assertEquals(100, person.getMaxHp());
    }
    
    @Test
    public void cantSetNegativeHp() {
        person.setHp(-1);
        assertEquals(0, person.getHp());
    }
    
    @Test
    public void cantSetHpOverMaxHp() {
        person.setHp(30);
        person.setHp(51);
        assertEquals(30, person.getHp());
        person.setHp(40);
        assertEquals(40, person.getHp());
    }
    
    @Test
    public void decreaseHpWorksCorrectly() {
        person.setHp(30);
        person.decreaseHp(10);
        assertEquals(20, person.getHp());
        person.decreaseHp(8);
        assertEquals(12, person.getHp());
    }
    
    @Test
    public void increaseHpWorksCorrectly() {
        person.setHp(10);
        person.increaseHp(10);
        assertEquals(20, person.getHp());
        person.increaseHp(8);
        assertEquals(28, person.getHp());
    }
    
    @Test
    public void increaseHpWontIncreaseOverMaxHp() {
        person.setHp(45);
        person.increaseHp(10);
        assertEquals(50, person.getHp());
    }
    @Test
    public void decreaseHpWontDecreaseUnderZero() {
        person.setHp(10);
        person.decreaseHp(15);
        assertEquals(0, person.getHp());
    }

}
