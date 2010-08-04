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
 *  its own image. He's got life figured out. - Eric
 *
 * @author CJ
 */
public class Ball extends Component {

    protected Direction direction;
    protected Point3D point;
    public static int SIZE = Constants.MAX_BALL_RADIUS;

    public Ball () {
        //Hard Coded Defaults
        this.direction = new Direction(20, 0, 20);
        this.point  = new Point3D(Constants.MAX_BALL_RADIUS + 10,
                Constants.MAX_BALL_RADIUS + 10,
                Constants.MAX_BALL_RADIUS + 10);
    }

    public void draw(Graphics g) {
        //Scale is not 0-100, should be 100-Constants.MIN_BALL_RADIUS_PER
        //Old Scale 
        //double scale = (Constants.SCREEN_DEPTH - point.getZ())/((double)Constants.SCREEN_DEPTH);

        //Scale of Scale is needed
        double scaleOfScale = (double)point.getZ()/(Constants.SCREEN_DEPTH - Constants.MAX_BALL_RADIUS);
        double scale = (1 - (1 - Constants.MIN_BALL_RADIUS_PER) * scaleOfScale);
        int finalRadius = (int)(scale * Constants.MAX_BALL_RADIUS);
        int diameter = finalRadius * 2;
        g.setColor(Color.BLACK);
        Point3D temp = shift3DLook();
        g.fillOval(temp.getX() - finalRadius, temp.getY() - finalRadius, diameter, diameter);
    }

    protected Point3D shift3DLook(){
        //TODO HARDEST PART HERE

        //Find Middle of Screen
        int midX = Constants.SCREEN_WIDTH/2;
        int midY = Constants.SCREEN_HEIGHT/2;

        int tempX = this.point.getX();
        int tempY = this.point.getY();

        //X shift
        //Take into account the fact that lowest x value can only be the max radius of the ball
        double scaleFactorX = (((double)(Constants.SCREEN_WIDTH/2 - Constants.SCREEN_WIDTH_FAR/2 - Constants.MAX_BALL_RADIUS))
                / (Constants.SCREEN_DEPTH - Constants.MAX_BALL_RADIUS) ) * this.point.getZ();
        //Deadzone Calc
        //Yo Cj is stupid again .. don't even use the point xy eh?
        if(Math.abs(this.point.getX() - midX) < Constants.DEAD_ZONE_X){}
        else if(this.point.getX() > midX){
            //Shift to left
            tempX = Constants.SCREEN_WIDTH - Constants.MAX_BALL_RADIUS - (int)scaleFactorX;
        }else if(this.point.getX() < midX){
            //Shift right
            tempX = Constants.MAX_BALL_RADIUS + (int)scaleFactorX;
        }

        //Y shift
        double scaleFactorY = (((double) (Constants.SCREEN_HEIGHT/2 - Constants.SCREEN_HEIGHT_FAR/2 - Constants.MAX_BALL_RADIUS))
                / (Constants.SCREEN_DEPTH - 2 * Constants.MAX_BALL_RADIUS)) * this.point.getZ();
        //Deadzone Calc
        if(Math.abs(this.point.getY() - midY) < Constants.DELAY){}
        else if(this.point.getY() > midY){
            //Shift Up
            tempY = Constants.SCREEN_HEIGHT - Constants.MAX_BALL_RADIUS - (int)scaleFactorY;
        }else if(this.point.getY() < midY){
            //Shift Down
            tempY = Constants.MAX_BALL_RADIUS + (int)scaleFactorY;
        }

        //Return resulting Point, Z point really doesn't matter
        return new Point3D(tempX, tempY, this.point.getZ());

    }

    /**
     * Returns a copy of the point of the ball.
     * @return
     */
    public Point3D getPoint(){
        return this.point.clone();
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
        if(planeID == Constants.PLANE_Z){
            this.direction = new Direction(this.direction.getA(), this.direction.getB(),
                    -this.direction.getC());
        }
        else if(planeID == Constants.PLANE_X){
            this.direction = new Direction(-this.direction.getA(), this.direction.getB(),
                    this.direction.getC());
        }
        else if(planeID == Constants.PLANE_Y){
            this.direction = new Direction(this.direction.getA(), -this.direction.getB(),
                    this.direction.getC());
        }
    }
}
