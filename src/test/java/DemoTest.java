import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DemoTest {

    Character hobbit;
    Character elf;
    Character king;
    Character knight;
    GameManager gameManager;
    CharacterFactory factory;

    @BeforeEach
    void setup() {
        hobbit = new Hobbit();
        elf = new Elf();
        king = new King();
        knight = new Knight();
        gameManager = new GameManager();
        factory = new CharacterFactory();
    }

    @Test
    void hobbitInitializationTest() {
        assertEquals(3, hobbit.hp);
        assertEquals(0, hobbit.power);
    }

    @Test
    void elfInitializationTest() {
        assertEquals(10, elf.hp);
        assertEquals(10, elf.power);
    }

    @Test
    void kingInitializationTest() {
        assertTrue(king.hp >= 5 && king.hp <= 15);
        assertTrue(king.power >= 5 && king.power <= 15);
    }

    @Test
    void knightInitializationTest() {
        assertTrue(knight.hp >= 2 && knight.hp <= 12);
        assertTrue(knight.power >= 2 && knight.power <= 12);
    }

    @Test
    void hobbitKickTest() {
        int initialHp = elf.hp;
        hobbit.kick(elf);
        assertEquals(initialHp, elf.hp);
    }

    @Test
    void elfKickWeakerTest() {
        elf.kick(hobbit);
        assertEquals(0, hobbit.hp);
    }

    @Test
    void elfKickStrongerTest() {
        Character strongerEnemy = new Elf();
        strongerEnemy.setPower(11);  
        int initialHp = strongerEnemy.hp;
        int initialPower = strongerEnemy.power;

        elf.kick(strongerEnemy);
        assertEquals(initialHp - elf.power, strongerEnemy.hp);
        assertEquals(initialPower - 1, strongerEnemy.power);
    }

    @Test
    void kingKickTest() {
        int initialHp = elf.hp;
        king.kick(elf);
        if (initialHp - king.power < 0) {
            assertEquals(0, elf.hp);
        } else{
            assertEquals(initialHp - king.power, elf.hp);
        }
    }

    @Test
    void isAliveTest() {
        assertTrue(elf.isAlive());
        elf.setHp(0);
        assertFalse(elf.isAlive());
    }

    @Test
    void fightTest() {
        Character character1 = factory.createCharacter();
        Character character2 = factory.createCharacter();

        gameManager.fight(character1, character2);
        assertFalse(character1.isAlive() && character2.isAlive());
    }
}
