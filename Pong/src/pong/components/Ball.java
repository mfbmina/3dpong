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
        this.direction = new Direction(30, 30, 30);
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

        //X coord Shift
        //First Step: Find Width at that level
        double widthLevel = Constants.SCREEN_WIDTH - (((double)(Constants.SCREEN_WIDTH - Constants.SCREEN_WIDTH_FAR))/Constants.SCREEN_DEPTH * this.point.getZ());
        //Second Step: Find the percentage of the current X over the Total
        double pointXPercentofWhole = (double)this.point.getX()/Constants.SCREEN_WIDTH;
        //Third Step: Find the corrected width at that level
        int widthXCorrect = (int)(widthLevel * pointXPercentofWhole);

//        System.out.println(widthLevel + " " + pointPercentofWhole);

        //Shift right
            tempX = Constants.MAX_BALL_RADIUS + (int)scaleFactorX //That gives you the right hand side
                    + widthXCorrect;//That gives you the correct shift
        
        //Y shift
        double scaleFactorY = (((double) (Constants.SCREEN_HEIGHT/2 - Constants.SCREEN_HEIGHT_FAR/2 - Constants.MAX_BALL_RADIUS))
                / (Constants.SCREEN_DEPTH - 2 * Constants.MAX_BALL_RADIUS)) * this.point.getZ();

        //Y coord Shift
        //First Step: Find HEIGHT at that level
        double heightLevel = Constants.SCREEN_HEIGHT - (((double)(Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT_FAR))/Constants.SCREEN_DEPTH * this.point.getZ());
        //Second Step: Find the percentage of the current Y over the Total
        double pointYPercentofWhole = (double)this.point.getY()/Constants.SCREEN_HEIGHT;
        //Third Step: Find the corrected height at that level
        int heightYCorrect = (int)(heightLevel * pointYPercentofWhole);

        //Shift down
        tempY = Constants.MAX_BALL_RADIUS + (int) scaleFactorY //that gives you the top side
                + heightYCorrect; //That gives you the correct shift

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
