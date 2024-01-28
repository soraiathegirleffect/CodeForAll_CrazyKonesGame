package game;

import org.academiadecodigo.simplegraphics.pictures.Picture;
public class Wall {

    private Picture picture;

    public Wall() {
        picture = new Picture(350, 300, Game.RESOURCES_PREFIX + "wall.png");
        picture.draw();
    }
}
