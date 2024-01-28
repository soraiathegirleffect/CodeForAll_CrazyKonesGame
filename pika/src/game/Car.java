package game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {

    private Background background;

    private Picture picture;

    public Car(){
        picture = new Picture(5, 5, Game.RESOURCES_PREFIX + "car.png");
        //picture = new Picture(STARTING_X, STARTING_Y, "Resources/catiaStreetStore.PNG"); //Create Character model on the screen
        picture.draw();
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public void moveLeft(){

        if (picture.getX() - Game.SPEED >= 0) {
            picture.translate(-Game.SPEED, 0);
        }
    }

    public void moveRight(){

        if(picture.getX() + picture.getWidth() + Game.SPEED <= background.getWidth()){
        picture.translate(Game.SPEED, 0);}
    }

    public void moveUp() {

        if (picture.getY() - Game.SPEED >= 0) {
            picture.translate(0, -Game.SPEED);
        }
    }

    public void moveDown(){
        if (picture.getY() + picture.getHeight() + Game.SPEED <= background.getHeight()) {
            picture.translate(0, Game.SPEED);
        }
    }
}

