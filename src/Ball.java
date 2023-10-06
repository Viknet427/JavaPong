import java.awt.*;

public class Ball {

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

}
