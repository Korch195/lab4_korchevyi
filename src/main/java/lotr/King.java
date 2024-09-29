package lotr;
import java.util.Random;
public class King extends Character{
    public King(){
        this.power = new Random().nextInt(11) + 5;
        this.hp = new Random().nextInt(11) + 5;
    }
    @Override
    public void kick(Character c){
        c.setHp(c.hp - this.power);
    }
}
