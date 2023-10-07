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

        graphics.setColor(color);
        graphics.fillRect(x, y, PADDLE_WIDTH, height);

    }

    public int getCentreY() {

        return y + height/2;

    }

    public void moveTowards(int moveToY, int top, int bottom) {

        // Get the location of the paddle's centre
        int centreY = getCentreY();
        int bottomY = y + height;

        if (Math.abs(moveToY - centreY) <= speed) {

            return;

        }

        if ((y - speed <= top && moveToY < centreY) ||
                (bottomY + speed >= bottom && moveToY > centreY)) {

            return;

        }

        // Check if the centre position is greater than the location it needs to get to
        if (centreY > moveToY) {

            // Moves the paddle towards the destination by its speed
            y -= speed;

            return;

        }

        // Otherwise move the other way
        y += speed;

    }

    public boolean checkCollision(Ball pongBall) {

        int bottomY, rightX, leftX;
        bottomY = y + height;
        rightX = x + PADDLE_WIDTH;
        leftX = x - pongBall.getSize();

        return pongBall.getX() < rightX && pongBall.getX() > leftX &&
                pongBall.getY() < bottomY && pongBall.getY() > y;

    }

}
