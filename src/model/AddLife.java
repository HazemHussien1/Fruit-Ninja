package model;

public class AddLife extends FruitDecorator {

    Fruit fruit;
    private String type;
    private String path ;
    public AddLife(Fruit fruit){
        this.fruit = fruit;
        type = fruit.getType();
        path = fruit.getPath();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPath() {
        return path;
    }
    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getNumberOfPointsAdded() {
        return fruit.numberOfPointsAdded;
    }

    @Override
    public boolean getAddsLife() {
        return true;
    }

}
