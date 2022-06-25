package model;

public abstract class  FruitDecorator extends Fruit {
    private Fruit fruit;

//    public FruitDecorator(Fruit fruit){
//        this.fruit = fruit;
//    }

    public abstract int getNumberOfPointsAdded();
    public abstract boolean getAddsLife();


}
