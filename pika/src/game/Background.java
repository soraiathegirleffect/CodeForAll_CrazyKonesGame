package game;

import game.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;

    public Background() {
        picture = new Picture(0, 0, Game.RESOURCES_PREFIX + "arena.png");
        picture.draw();
    }


    public int getWidth() {
        return picture.getWidth();
    }

    public int getHeight(){
        return picture.getHeight();
    }

    public void moveRight(){
        picture.translate(Game.SPEED, 0);
    }

    public void moveLeft(){
        picture.translate(-Game.SPEED, 0);
    }
}
