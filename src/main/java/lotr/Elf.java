package lotr;
public class Elf extends Character{
    public Elf(){
        this.power = 10;
        this.hp = 10;
    }
    @Override
    public void kick(Character c){
        if (this.power > c.power){
            c.setHp(0);
        } else {
            // posibly not correct implementation
            c.setHp(c.hp - this.power);
            c.setPower(c.power - 1);
        }
    }
    @Override
    public String toString() {
        return "Elf{hp=" + this.hp + ", power=" + this.power + "}";
    }
    
}