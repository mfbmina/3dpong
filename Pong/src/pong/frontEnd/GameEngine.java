/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.frontEnd;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import pong.constants.Constants;
import pong.components.*;

/** Main Game Engine that controls majority of the interactions between classes.
 *
 * @author CJ
 */
public class GameEngine extends JPanel implements MouseListener, MouseMotionListener {

    public GameEngine() {

       addMouseListener(this);
       addMouseMotionListener(this);

       initGame();
    }

    public void run() {
        try {
            Thread.sleep(Constants.DELAY);

        } catch (InterruptedException ex) {}
    }

    public void initGame() {

    }


    public void PaintComponent(Graphics g) {

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
