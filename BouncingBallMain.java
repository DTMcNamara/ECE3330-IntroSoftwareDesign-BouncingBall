import javax.swing.*;

/**
 * The BouncingBallMain is used
 * to test the bouncingBall.
 */
public class BouncingBallMain{

    /**
     * The main method declares a new
     * jframe and a new bouncing ball that
     * it adds to the jframe. The main also
     * sets all the frame parameters.
     *
     * @param args No args are passed to
     *             the main method.
     */
    public static void main(String[] args) {
        BouncingBall ball = new BouncingBall();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(ball);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}