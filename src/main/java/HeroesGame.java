import java.util.Random;
abstract class Character {
    protected int power;
    protected int hp;
    public void kick(Character c){

    }
    public boolean isAlive(){
        return hp > 0;
    }
    public void setHp(int hp) {
        if (hp > 0) {
            this.hp = hp;
        } else {
            this.hp = 0;
        }
    }
    public void setPower(int power) {
        this.power = power;
    }
    
}
class Hobbit extends Character{
    public Hobbit(){
        this.power = 0;
        this.hp = 3;
    }
    @Override
    public void kick(Character c){
        toCry();
    }
    private void toCry(){

    }

}
class Elf extends Character{
    public Elf(){
        this.power = 10;
        this.hp = 10;
    }
    @Override
    public void kick(Character c){
        if (this.power > c.power){
            c.setHp(0);
        } else {
            c.setPower(c.hp - 1);
        }
    }
}
class King extends Character{
    public King(){
        this.power = new Random().nextInt(11) + 5; // 5 to 15
        this.hp = new Random().nextInt(11) + 5; // 5 to 15
    }
    @Override
    public void kick(Character c){
        c.setHp(c.hp - this.power);
    }
}
class Knight extends King{
    public Knight(){
        this.hp = new Random().nextInt(11) + 2;
        this.power = new Random().nextInt(11) + 2;
    }
}
class CharacterFactory{
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
class GameManager {
    public void fight(Character c1, Character c2) {
        if (c1 instanceof Hobbit && c2 instanceof Hobbit){
            System.out.println("Tie");
            return;
        }
        System.out.println(c1.getClass().getSimpleName() + " HP: " + c1.hp + " Damage: " + c1.power);
        System.out.println(c2.getClass().getSimpleName() + " HP: " + c2.hp + " Damage: " + c2.power);
        System.out.println();
        while (c1.isAlive() && c2.isAlive()) {
            c1.kick(c2);
            if (c2.isAlive()) {
                c2.kick(c1);
            }
            System.out.println(c1.getClass().getSimpleName() + " HP: " + c1.hp);
            System.out.println(c2.getClass().getSimpleName() + " HP: " + c2.hp);
            System.out.println();
        }
        
        if (!c1.isAlive()) {
            System.out.println(c1.getClass().getSimpleName() + " has been defeated!");
        } else {
            System.out.println(c2.getClass().getSimpleName() + " has been defeated!");
        }
    }
}
class HeroesGame {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        GameManager gameManager = new GameManager();

        Character character1 = factory.createCharacter();
        Character character2 = factory.createCharacter();

        System.out.println("Fight between " + character1.getClass().getSimpleName() + " and " + character2.getClass().getSimpleName());
        gameManager.fight(character1, character2);
    }
}