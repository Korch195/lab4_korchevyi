package lotr;
import java.util.Random;
public class Knight extends King{
    public Knight(){
        this.hp = new Random().nextInt(11) + 2;
        this.power = new Random().nextInt(11) + 2;
    }
}
