package model;

public class Banana extends Fruit {

    private String BANANA_PATH = "/view/assets/banana.png";
    private String BANANA_FIRST_SLICE_PATH = "/view/assets/banana_sliced1.png";
    private String BANANA_SECOND_SLICE_PATH = "/view/assets/banana_sliced2.png";

    private String type = "banana";

    public String getPath() {
        return BANANA_PATH;
    }

    public void setBANANA_PATH(String BANANA_PATH) {
        this.BANANA_PATH = BANANA_PATH;
    }

    public String getBANANA_FIRST_SLICE_PATH() {
        return BANANA_FIRST_SLICE_PATH;
    }

    public void setBANANA_FIRST_SLICE_PATH(String BANANA_FIRST_SLICE_PATH) {
        this.BANANA_FIRST_SLICE_PATH = BANANA_FIRST_SLICE_PATH;
    }

    public String getBANANA_SECOND_SLICE_PATH() {
        return BANANA_SECOND_SLICE_PATH;
    }

    public void setBANANA_SECOND_SLICE_PATH(String BANANA_SECOND_SLICE_PATH) {
        this.BANANA_SECOND_SLICE_PATH = BANANA_SECOND_SLICE_PATH;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}