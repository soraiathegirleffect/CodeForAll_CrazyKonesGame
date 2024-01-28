package game;

import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Main {


    public static void main(String[] args) {

        Canvas.setMaxX(800);
        Canvas.setMaxY(400);
        // x, y, width, height

        Background background = new Background();
        Car car = new Car();
        car.setBackground(background);

        KeyboardLogic keyboardLogic = new KeyboardLogic();
        keyboardLogic.setCar(car);

    }
}
