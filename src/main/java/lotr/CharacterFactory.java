package lotr;
import java.util.Random;
public class CharacterFactory{
    public Character createCharacter(){
        Random random = new Random();
        int value = random.nextInt(4);
        if (value == 0) {
            return new Hobbit();
        } else if (value == 1){
            return new Elf();
        } else if (value == 2){
            return new King();
        } else {
            return new Knight();
        }
    }
}