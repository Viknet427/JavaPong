import javax.swing.*;

public class Main {

    // Declare and initialize the frame
    static JFrame frame = new JFrame("Pong");
    public static void main(String[] args) {

        // Make the program exits when the window is closed
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set the window size since the default window size of 480x640 is too small
        frame.setSize(650, 495);

        PongGame pongGame = new PongGame();

        frame.add(pongGame);

        // Makes the window visible
        frame.setVisible(true);

    }

}