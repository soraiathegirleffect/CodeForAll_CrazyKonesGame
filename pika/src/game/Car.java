package game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {

    private Background background;

    private Picture picture;

    private String carRight;
    private String carLeft;
    private String carUp;
    private String carDown;

    public Car(){
        carRight = Game.RESOURCES_PREFIX + "carRight.png";
        carLeft = Game.RESOURCES_PREFIX + "carLeft.png";
        carUp = Game.RESOURCES_PREFIX + "carUp.png";
        carDown = Game.RESOURCES_PREFIX + "carDown.png";
        picture = new Picture(0, 400, carRight);
        picture.draw();
    }
    //picture = new Picture(STARTING_X, STARTING_Y, "Resources/catiaStreetStore.PNG"); //Create Character model on the screen

    public void setBackground(Background background) {
        this.background = background;
    }

    public void moveLeft(){

        if (picture.getX() - Game.SPEED >= 0) {
            picture.load(carLeft);
            picture.translate(-Game.SPEED, 0);
        }
    }

    public void moveRight(){

        if(picture.getX() + picture.getWidth() + Game.SPEED <= background.getWidth()){
            picture.load(carRight);
            picture.translate(Game.SPEED, 0);}
    }

    public void moveUp() {

        if (picture.getY() - Game.SPEED >= 0) {
            picture.load(carUp);
            picture.translate(0, -Game.SPEED);
        }
    }

    public void moveDown(){
        if (picture.getY() + picture.getHeight() + Game.SPEED <= background.getHeight()) {
            picture.load(carDown);
            picture.translate(0, Game.SPEED);
        }
    }
}

