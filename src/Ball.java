import java.awt.*;

public class Ball {

    static final int MAX_SPEED = 7;
    private int x, y, changeX, changeY, speed, size;
    private Color color;

    public Ball(int x, int y, int changeX, int changeY, int speed, Color color, int size) {

        this.x = x;
        this.y = y;
        this.changeX = changeX;
        this.changeY = changeY;
        this.speed = speed;
        this.color = color;
        this.size = size;

    }

    public void paint(Graphics graphics) {

        // Set the brush color to the ball color
        graphics.setColor(color);

        // Paint the ball at x, y with a width and height of the ball size
        graphics.fillOval(x, y, size, size);

    }

    public void moveBall() {

        x += changeX;
        y += changeY;

    }

    public void bounceOffEdges(int top, int bottom) {

        if (y > bottom - size || y < top) {

            reverseY();

        }

    }

    public void reverseX() {

        changeX *= -1;

    }

    public void reverseY() {

        changeY *= -1;

    }

    public void increaseSpeed() {

        if (speed >= MAX_SPEED) {

            return;

        }

        speed++;

        changeX = changeX / Math.abs(changeX) * speed;
        changeY = changeY / Math.abs(changeY) * speed;

    }

    public int getY() {

        return y;

    }

    public int getX() {

        return x;

    }

    public int getSize() {

        return size;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setChangeX(int changeX) {
        this.changeX = changeX;
    }

    public void setChangeY(int changeY) {
        this.changeY = changeY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
