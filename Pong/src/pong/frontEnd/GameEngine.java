/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.frontEnd;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import pong.constants.Constants;

/** Main Game Engine that controls majority of the interactions between classes.
 *
 * @author CJ
 */
public class GameEngine extends JPanel implements MouseListener, MouseMotionListener {

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
            repaint();
        try { Thread.sleep(Constants.DELAY); } catch (InterruptedException ex) {}
        }
    }

    protected void initGame() {
        this.grid = Grid.getInstance();
       for (int i = 0; i < Constants.NUM_BALLS; ++i) grid.addBall();
    }

    protected void initInput(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    protected void initGraphics(){
        grid.setBackground();
        this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
        this.setFocusable(true);
    }


    public void paintComponent(Graphics g) {
        grid.paintAll(g);
    }





/*
 * Mouse Methods implemented from MouseListener and MouseMotionListener
 */
    
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
