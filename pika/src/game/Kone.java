package game;

import org.academiadecodigo.simplegraphics.pictures.Picture;
public class Kone {

    private Picture picture;

    public Kone(Position position) {
        picture = new Picture(350, 300, Game.RESOURCES_PREFIX + "kone.png");
        picture.draw();
    }
}
