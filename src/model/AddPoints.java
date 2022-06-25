package model;

public class AddPoints extends FruitDecorator {

    Fruit fruit;
    private String type;
    private String path ;


    public AddPoints(Fruit fruit){
        this.fruit = fruit;
        type = fruit.getType();
        path = fruit.getPath();
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getNumberOfPointsAdded() {
        return fruit.numberOfPointsAdded + 5;
    }

    @Override
    public boolean getAddsLife() {
        return false;
    }
}
