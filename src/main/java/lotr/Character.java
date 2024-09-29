package lotr;
import lombok.Setter;
import lombok.Getter;
@Getter @Setter
public abstract class Character implements Kickable{
    protected int power;
    protected int hp;

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

    @Override
    public String toString() {
        return "Character{hp=" + this.hp + ", power=" + this.power + "}";
    }
    
}