import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongGame extends JPanel implements KeyListener {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball pongBall;
    private Paddle leftPaddle, rightPaddle;

    private int leftScore, rightScore, bounceCount, leftInput, rightInput;

    public PongGame() {

        pongBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
        leftPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        rightPaddle = new Paddle(610, 200, 75, 3, Color.RED);

        leftScore = rightScore = bounceCount = 0;

        leftInput = leftPaddle.getCentreY();
        rightInput = rightPaddle.getCentreY();

        this.setFocusable(true);
        addKeyListener(this);

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
        graphics.drawString("Score - User [ " + leftScore +  " ] PC [ " + rightScore + " ]", 250, 20);

        // Draw the ball
        pongBall.paint(graphics);

        // Draw the paddles
        leftPaddle.paint(graphics);
        rightPaddle.paint(graphics);

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

            rightScore++;
            reset();

            return;

        }

        if (pongBall.getX() > WINDOW_WIDTH) {

            leftScore++;
            reset();

        }

    }

    private void checkCollision() {

        if (rightPaddle.checkCollision(pongBall) ||
                leftPaddle.checkCollision(pongBall)) {

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

        // Moves the user's paddle towards their desired direction
        leftPaddle.moveTowards(leftInput, 0, WINDOW_HEIGHT);
        rightPaddle.moveTowards(rightInput, 0, WINDOW_HEIGHT);

        checkCollision();
        updateScores();

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {

            leftInput = 0;

            return;

        }

        if (key == KeyEvent.VK_S) {

            leftInput = WINDOW_HEIGHT;

            return;

        }

        if (key == KeyEvent.VK_UP) {

            rightInput = 0;

            return;

        }

        if (key == KeyEvent.VK_DOWN) {

            rightInput = WINDOW_HEIGHT;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {

            leftInput = leftPaddle.getCentreY();

        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {

            rightInput = rightPaddle.getCentreY();

        }

    }

}
