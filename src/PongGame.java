import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball pongBall;
    private Paddle userPaddle, pcPaddle;

    private int userMouseY;

    public PongGame() {

        pongBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);

        userMouseY = 0;
        addMouseMotionListener(this);

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

        // Moves the user's paddle towards their mouse position
        userPaddle.moveTowards(userMouseY);

        // Moves the PC's paddle so that it matches the Y position of the ball
        pcPaddle.moveTowards(pongBall.getY());

        if (pcPaddle.checkCollision(pongBall) ||
                userPaddle.checkCollision(pongBall)) {

            pongBall.reverseX();

        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {

        userMouseY = e.getY();

    }

}
