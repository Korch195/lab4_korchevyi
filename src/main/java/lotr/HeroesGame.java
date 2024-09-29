package lotr;

public class HeroesGame {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        GameManager gameManager = new GameManager();

        // Character character1 = new Elf();
        // Character character2 = new Elf();
        Character character1 = factory.createCharacter();
        Character character2 = factory.createCharacter();

        System.out.println("Fight between " + character1.getClass().getSimpleName() + " and " + character2.getClass().getSimpleName());
        gameManager.fight(character1, character2);
    }
}