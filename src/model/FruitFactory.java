package model;

public class FruitFactory {

    public Fruit createFruit(String fruitType){
        if(fruitType.equals("lemon")){
            return new Lemon();
        }else if (fruitType.equals("watermelon")){
            return new Watermelon();
        }else if(fruitType.equals("banana")){
            return new Banana();
        }else {
            return new Pineapple();
        }
    }

}
