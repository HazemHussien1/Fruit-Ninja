package model;

public class Watermelon  extends Fruit{
    private String WATERMELON_PATH = "/view/assets/watermelon.png";
    private String WATERMELON_FIRST_SLICE_PATH = "/view/assets/watermelon_sliced1.png";
    private String WATERMELON_SECOND_SLICE_PATH = "/view/assets/watermelon_sliced2.png";

    private String type = "watermelon";

    public String getPath() {
        return WATERMELON_PATH;
    }

    public void setWATERMELON_PATH(String WATERMELON_PATH) {
        this.WATERMELON_PATH = WATERMELON_PATH;
    }

    public String getWATERMELON_FIRST_SLICE_PATH() {
        return WATERMELON_FIRST_SLICE_PATH;
    }

    public void setWATERMELON_FIRST_SLICE_PATH(String WATERMELON_FIRST_SLICE_PATH) {
        this.WATERMELON_FIRST_SLICE_PATH = WATERMELON_FIRST_SLICE_PATH;
    }

    public String getWATERMELON_SECOND_SLICE_PATH() {
        return WATERMELON_SECOND_SLICE_PATH;
    }

    public void setWATERMELON_SECOND_SLICE_PATH(String WATERMELON_SECOND_SLICE_PATH) {
        this.WATERMELON_SECOND_SLICE_PATH = WATERMELON_SECOND_SLICE_PATH;
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
