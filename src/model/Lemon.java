package model;

public class Lemon extends Fruit {

    private String LEMON_PATH = "/view/assets/lemon.png";
    private String LEMON_FIRST_SLICE_PATH = "/view/assets/lemon_sliced1.png";
    private String LEMON_SECOND_SLICE_PATH = "/view/assets/lemon_sliced2.png";

    private String type = "lemon";

    public String getPath() {
        return LEMON_PATH;
    }

    public void setLEMON_PATH(String LEMON_PATH) {
        this.LEMON_PATH = LEMON_PATH;
    }

    public String getLEMON_FIRST_SLICE_PATH() {
        return LEMON_FIRST_SLICE_PATH;
    }

    public void setLEMON_FIRST_SLICE_PATH(String LEMON_FIRST_SLICE_PATH) {
        this.LEMON_FIRST_SLICE_PATH = LEMON_FIRST_SLICE_PATH;
    }

    public String getLEMON_SECOND_SLICE_PATH() {
        return LEMON_SECOND_SLICE_PATH;
    }

    public void setLEMON_SECOND_SLICE_PATH(String LEMON_SECOND_SLICE_PATH) {
        this.LEMON_SECOND_SLICE_PATH = LEMON_SECOND_SLICE_PATH;
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
