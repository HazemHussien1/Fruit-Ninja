package model;

public class Pineapple extends Fruit {
    private String PINEAPPLE_PATH = "/view/assets/pineapple.png";
    private String PINEAPPLE_FIRST_SLICE_PATH = "/view/assets/pineapple_sliced1.png";
    private String PINEAPPLE_SECOND_SLICE_PATH = "/view/assets/pineapple_sliced2.png";

    private String type = "pineapple";

    public String getPath() {
        return PINEAPPLE_PATH;
    }

    public void setPINEAPPLE_PATH(String PINEAPPLE_PATH) {
        this.PINEAPPLE_PATH = PINEAPPLE_PATH;
    }

    public String getPINEAPPLE_FIRST_SLICE_PATH() {
        return PINEAPPLE_FIRST_SLICE_PATH;
    }

    public void setPINEAPPLE_FIRST_SLICE_PATH(String PINEAPPLE_FIRST_SLICE_PATH) {
        this.PINEAPPLE_FIRST_SLICE_PATH = PINEAPPLE_FIRST_SLICE_PATH;
    }

    public String getPINEAPPLE_SECOND_SLICE_PATH() {
        return PINEAPPLE_SECOND_SLICE_PATH;
    }

    public void setPINEAPPLE_SECOND_SLICE_PATH(String PINEAPPLE_SECOND_SLICE_PATH) {
        this.PINEAPPLE_SECOND_SLICE_PATH = PINEAPPLE_SECOND_SLICE_PATH;
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
