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
            c.setPower(c.power - 1);
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

