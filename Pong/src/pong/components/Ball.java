/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.components;

import java.awt.Graphics;
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
        this.direction = new Direction();
        this.point  = new Point3D();
    }

    public void draw(Graphics g) {
        
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
}
