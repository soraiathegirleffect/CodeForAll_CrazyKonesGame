package game;

import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Main {


    public static void main(String[] args) {

        //Canvas.setMaxX(1200);
        //Canvas.setMaxY(700);
        // x, y, width, height

        Sound sound = new Sound("start.wav");
        //sound.play();

        Background background = new Background();
        Car car = new Car();
        Wall wall = new Wall();
        Client client = new Client();
        car.setBackground(background);

        KeyboardLogic keyboardLogic = new KeyboardLogic();
        keyboardLogic.setCar(car);

    }
}
