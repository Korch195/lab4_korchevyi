package lotr;

public class GameManager {
    public void fight(Character c1, Character c2) {
        if (c1 instanceof Hobbit && c2 instanceof Hobbit){
        // need to check 
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