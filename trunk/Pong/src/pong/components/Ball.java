/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.components;

import java.awt.Color;
import java.awt.Graphics;
import pong.constants.Constants;
import pong.util.*;

/** A single ball in the game.  Knows where it's at and where it's going and is responsible for
 *  its own image. He's got life figured out.
 *
 * @author CJ
 */
public class Ball extends Component {

    protected Direction direction;
    protected Point3D point;

    public Ball () {
        this.direction = new Direction(5, 5, 5);
        this.point  = new Point3D(Constants.MAX_BALL_RADIUS,
                Constants.MAX_BALL_RADIUS,
                Constants.MAX_BALL_RADIUS);
    }

    public void draw(Graphics g) {
        double scale = (Constants.SCREEN_DEPTH - point.getZ())/((double)Constants.SCREEN_DEPTH);
        int finalRadius = (int)(scale * Constants.MAX_BALL_RADIUS);
        int diameter = finalRadius * 2;
        g.setColor(Color.BLACK);
        Point3D temp = shift3DLook();
        g.fillOval(temp.getX() - finalRadius, temp.getY() - finalRadius, diameter, diameter);
    }

    protected Point3D shift3DLook(){
        //TODO HARDEST PART HERE
        return this.point;
    }

    /**
     * Steps this ball by adding the directional vector to the currrent
     * location.
     */
    public void step(){
        int x = point.getX();
        int y = point.getY();
        int z = point.getZ();
        point = new Point3D(x + this.direction.getA(),
                y + this.direction.getB(),
                z + this.direction.getC());
    }

    public void bounce(int planeID){
        //TODO Implement
    }
}
