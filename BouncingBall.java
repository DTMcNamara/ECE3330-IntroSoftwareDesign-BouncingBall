import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The bouncingBall inherits from JPanel
 * and implements Runnable to allow for
 * multithreading.
 */
public class BouncingBall extends JPanel implements Runnable {

    /**
     * The color is used to store the
     * color of the ball for the gui
     * to display.
     */
    private Color color;

    /**
     * The int Diameter is used to
     * store the size of the ball
     * to draw.
     */
    private int diameter=45;

    /**
     * The int x is used to store the
     * x position of the ball in the gui.
     */
    private int x=1;

    /**
     * The int y is used to store the
     * y position of the ball in the gui.
     */
    private int y=1;

    /**
     * The int dx is used to control
     * the x direction and x direction
     * speed of the ball in the gui.
     */
    private int dx=5;

    /**
     * The int dy is used to control
     * the y direction and y direction
     * speed of the ball in the gui.
     */
    private int dy=5;

    /**
     * The boolean EnableMovement is
     * used to determine if movement
     * has began based on the mouse
     * listener.
     */
    private boolean enableMovement;

    /**
     * The bouncingBall constructor
     * creates a new bouncingBall
     * object.
     */
    public BouncingBall() {
        color=Color.BLUE;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(enableMovement==false){
                    start();
                    enableMovement=true;
                }
            }
            @Override
            public void mousePressed(MouseEvent e){}

            @Override
            public void mouseReleased(MouseEvent e){}

            @Override
            public void mouseEntered(MouseEvent e){}

            @Override
            public void mouseExited(MouseEvent e){}
        });
    }

    /**
     * The paintComponent is used
     * to redraw the ball each time
     * it is called.
     *
     * @param g The param g is used to
     *          pass the object being drawn.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(color);
        g.fillOval(x,y,25,25); //adds color to circle
        g.setColor(Color.black);
        g2.drawOval(x,y,25,25); //draws circle
    }

    /**
     * The run method is used to control how
     * often the ball is updated using the
     * paint method. Making the tread sleep
     * less increases the speed.
     */
    public void run() {
        while(isVisible()) {
            try {
                Thread.sleep(50);
            } catch(InterruptedException e){}
            moveBall();
            repaint();
        }
    }

    /**
     * The moveBall function is used to move the
     * ball around the jpanel. It checks each bound
     * to make sure the ball doesnt go out of the
     * jpanel. If it were to go out of bounds it
     * reverses direction.
     */
    public void moveBall() {
        if(x + dx < 0){
            dx=(dx*-1);
        }
        if(x + diameter + dx > getWidth()){
            dx=(dx*-1);
        }
        if(y + dy < 0){
            dy=(dy*-1);
        }
        if(y + diameter + dy > getHeight()){
            dy=(dy*-1);
        }
        x += dx;
        y += dy;
    }

    /**
     * The start method is used to create a new
     * thread to run the ball on to allow the gui
     * to update.
     */
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }
}