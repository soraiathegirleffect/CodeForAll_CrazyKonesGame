package game;

import gameObjects.Car;
import gameObjects.Obstacle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    public static int SPEED;

    public static final String RESOURCES_PREFIX = "resources/";

    private boolean gameStarted = true; //was true before menu

    private Car car;

    private ObstacleFactory obstacleFactory;

    private Picture gameOverPic;
    private Picture controlsPic;

    private Score score;

    private ScoreManager scoreManager;
    private Text finalScoreText; // Add this field to keep track of the final score text

    private CollisionDetector colissionDetector;

    public Game() {
        SPEED = Speed.MEDIUM.getSpeedValue();//acessed by enum
        scoreManager = new ScoreManager();
        obstacleFactory = new ObstacleFactory();
        Picture gameOverPic = new Picture(0, 0, Game.RESOURCES_PREFIX + "gameOverScreen.png");
        this.gameOverPic = gameOverPic;
    }

    public void start() throws InterruptedException { //game breaks in main if exception is thrown
        //gameStarted = true;
        int randomizer = 0; //1 to 5 we need to create a strategy DP to replace this
        while (true) { //was game started
            System.out.println(""); //it had (controlsPic == null); without sout bc of sleep it goes out of loop and never starts
            if(controlsPic == null) {
                randomizer = (int) (Math.random() * 5) + 1; // 1 to 5
                //implement in move a verif to check if it hit the edge of the background
                if (obstacleFactory.getObstacles().size() == 10) {
                    obstacleFactory.removeObstacle(0);
                }
                if (gameStarted) {
                    switch (randomizer) {
                        case 1:
                        case 2:
                            obstacleFactory.addFireKone();
                            break;
                        case 3:
                            obstacleFactory.addClient();
                            break;
                        default:
                            obstacleFactory.addKone();
                            break;
                    }
                    Thread.sleep(1000); //search game loops without sleep or put sleep inside move
                    //System.out.println(Thread.currentThread().getName());
                }
                moveObstacles();
            }
        }
    }

    private void moveObstacles(){
        for(Obstacle obstacle: obstacleFactory.getObstacles()) {
            if (!gameStarted) {
                return;
            }
            obstacle.move();
            if (!car.getGodMode()) {
                colissionDetector.collision(obstacle);
            }
        }
    }

    public void gameOver(){
        if (gameStarted) {
            gameStarted = false;
            gameOverPic.draw();

            int finalScore = score.getScore();
            int highScore = scoreManager.readHighScore();

            // Only update the high score and draw the score if the final score is greater
            if (finalScore > highScore) {
                scoreManager.writeHighScore(finalScore);
                if (finalScoreText != null) {
                    finalScoreText.delete();
                }
                finalScoreText = new Text(893, 50, "High Score: " + finalScore);
                finalScoreText.setColor(Color.RED);
                finalScoreText.grow(100, 40); //text box size
                finalScoreText.draw();
            } else {
                // If the final score is not greater, draw the high score
                if (finalScoreText != null) {
                    finalScoreText.delete();
                }
                finalScoreText = new Text(893, 50, "High Score: " + highScore);
                finalScoreText.setColor(Color.RED);
                finalScoreText.grow(100, 40);
                finalScoreText.draw();
            }
        }
    }

    public void gameRestart(){
        if (!gameStarted) {
            gameOverPic.delete();
            score.resetScore(); // reset the score
            car.changeToTaxi();
            obstacleFactory.removeObstacles();
            gameStarted = true;
        }
    }

    public void ExitGame(){
        //ExitGame = true;
        System.exit(0);
    }

    public void setUpScores(){
        Score score = new Score();
        score.startTimer();
        setScore(score); // set the score in the game
    }

    public void increaseScore(){
        score.upScore(10);
    }

    public void DrawControls(Background background){
        float centerPosX = background.getBackground().getWidth() /5;
        float centerPosY = background.getBackground().getHeight()/5;
        controlsPic = new Picture(centerPosX,centerPosY,Game.RESOURCES_PREFIX + "controls.png");
        controlsPic.draw();
    }

    public void RemoveControls(){
        if(controlsPic == null){
            return;
        }
        controlsPic.delete();
        controlsPic = null;

        gameStarted = true;
        setUpScores();
    }

    public void setCar(Car car){
        this.car = car;
    }

    public void setColissionDetector(CollisionDetector colissionDetector){
        this.colissionDetector = colissionDetector;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public static void setSpeed(int speed){ //static works here since there is only 1game1car we change class prop
        Game.SPEED = speed;
    }

}
