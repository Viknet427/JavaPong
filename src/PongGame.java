import javax.swing.*;
import java.awt.*;

public class PongGame extends JPanel {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball pongBall;

    public PongGame() {

        pongBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);

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

    }

}
