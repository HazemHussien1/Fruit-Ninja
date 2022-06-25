package model;

import javafx.scene.image.ImageView;

public class DeathBomb extends Bomb {

    private String path = "/view/assets/death_bomb.png";
    private ImageView img;

    private String type = "deathbomb";

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public ImageView getImg() {
        return img;
    }

    @Override
    public void setImg(ImageView img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
