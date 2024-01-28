package game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {

    private Background background;

    private Picture picture;

    public Car(){
        picture = new Picture(10, 20, Game.RESOURCES_PREFIX + "car.png");
        //picture = new Picture(STARTING_X, STARTING_Y, "Resources/catiaStreetStore.PNG"); //Create Character model on the screen
        picture.draw();
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public void moveLeft(){

        picture.translate(-Game.SPEED, 0);
    }

    public void moveRight(){

        picture.translate(Game.SPEED, 0);
    }

    public void moveUp(){

        picture.translate(0, -Game.SPEED);
    }

    public void moveDown(){
        picture.translate(0, Game.SPEED);
    }
}

