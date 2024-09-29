package lotr;

public class Hobbit extends Character{
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
    @Override
    public String toString() {
        return "Hobbit{hp=" + this.hp + ", power=" + this.power + "}";
    }
    
}