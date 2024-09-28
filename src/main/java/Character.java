public class Character {
    private int power;
    private int hp;
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
    
}
class Hobbit {

}
