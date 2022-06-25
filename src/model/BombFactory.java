package model;

public class BombFactory  {
    public Bomb createBomb(String bombType){
        if(bombType.equals("lifeBomb")){
            return new LifeBomb();
        }else if(bombType.equals("deathBomb")){
            return new DeathBomb();
        }
        return null;
    }
}
