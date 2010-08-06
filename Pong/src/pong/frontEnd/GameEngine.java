/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.frontEnd;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import pong.components.Paddle;
import pong.constants.Constants;
import pong.util.Point2D;

/** Main Game Engine that controls majority of the interactions between classes.
 *
 * @author CJ
 */
public class GameEngine extends JPanel implements MouseMotionListener {

    protected Grid grid;

    public GameEngine() {

       initInput();
       initGame();
       initGraphics();
    }

    /**
     * Starts the game.  The loop will terminated upon game completion.
     */
    public void run() {
        while (true) {
            stepBalls();
            repaint();
        try { Thread.sleep(Constants.DELAY); } catch (InterruptedException ex) {}
        }
    }

    protected void initGame() {
        this.grid = Grid.getInstance();
       for (int i = 0; i < Constants.NUM_BALLS; ++i) grid.addBall();
    }

    protected void initInput(){
        this.addMouseMotionListener(this);
    }

    protected void initGraphics(){
        this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
        this.setFocusable(true);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.paintAll(g);
    }

    protected void stepBalls(){
        grid.stepBalls();
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        Point2D point = new Point2D((int)e.getPoint().getX(), (int)e.getPoint().getY());
        Paddle.getInstance().setPoint(point);
    }
}
