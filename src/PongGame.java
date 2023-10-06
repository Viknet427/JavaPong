import javax.swing.*;
import java.awt.*;

public class PongGame extends JPanel {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball pongBall;
    private Paddle userPaddle, pcPaddle;

    public PongGame() {

        pongBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);

    }

    /**
     * Updates and draws all the graphics on the screen
     */
    public void paintComponent(Graphics graphics) {

        // Draw the background
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Draw the ball
        pongBall.paint(graphics);

        // Draw the paddles
        userPaddle.paint(graphics);
        pcPaddle.paint(graphics);

    }

    public void gameLogic() {

        // Moves the ball
        pongBall.moveBall();

        // Checks for collision
        pongBall.bounceOffEdges(0, WINDOW_HEIGHT);

        userPaddle.moveTowards(0);
        pcPaddle.moveTowards(600);

    }

}
