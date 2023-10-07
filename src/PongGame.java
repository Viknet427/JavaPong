import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball pongBall;
    private Paddle userPaddle, pcPaddle;

    private int userScore, pcScore, bounceCount;

    private int userMouseY;

    public PongGame() {

        pongBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);

        userScore = pcScore = bounceCount = 0;

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

        // Draw the scores
        graphics.setColor(Color.WHITE);
        graphics.drawString("Score - User [ " + userScore +  " ] PC [ " + pcScore + " ]", 250, 20);

        // Draw the ball
        pongBall.paint(graphics);

        // Draw the paddles
        userPaddle.paint(graphics);
        pcPaddle.paint(graphics);

    }

    public void reset() {

        try {

            Thread.sleep(1000);

        } catch (Exception e) {

            e.printStackTrace();

        }

        pongBall.setX(300);
        pongBall.setY(300);
        pongBall.setChangeX(3);
        pongBall.setChangeY(3);
        pongBall.setSpeed(3);
        bounceCount = 0;

    }

    private void updateScores() {

        if (pongBall.getX() < 0) {

            pcScore++;
            reset();

            return;

        }

        if (pongBall.getX() > WINDOW_WIDTH) {

            userScore++;
            reset();

        }

    }

    private void checkCollision() {

        if (pcPaddle.checkCollision(pongBall) ||
                userPaddle.checkCollision(pongBall)) {

            pongBall.reverseX();
            bounceCount++;

        }

        if (bounceCount == 5) {

            bounceCount = 0;
            pongBall.increaseSpeed();

        }

    }

    public void gameLogic() {

        // Moves the ball
        pongBall.moveBall();

        // Checks if the ball has hit a wall
        pongBall.bounceOffEdges(0, WINDOW_HEIGHT);

        // Moves the user's paddle towards their mouse position
        userPaddle.moveTowards(userMouseY);

        // Moves the PC's paddle so that it matches the Y position of the ball
        pcPaddle.moveTowards(pongBall.getY());

        checkCollision();

        updateScores();

    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {

        userMouseY = e.getY();

    }

}
