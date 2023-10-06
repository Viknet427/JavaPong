import java.awt.*;

public class Paddle {

    private int height, x, y, speed;
    private Color color;

    static final int PADDLE_WIDTH = 15;


    public Paddle(int x, int y, int height, int speed, Color color) {

        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;

    }

    public void paint(Graphics graphics) {

        graphics.fillRect(x, y, PADDLE_WIDTH, height);

    }



}
