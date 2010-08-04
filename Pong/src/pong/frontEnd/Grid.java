/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.frontEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import pong.components.Background;
import pong.components.Ball;
import pong.components.Component;
import pong.constants.Constants;
import pong.util.CollisionDetector;
import pong.util.Point3D;

/** Singleton Grid Class.
 *
 * @author eric
 */
public class Grid {

    //Ya.. i made it a singleton for simplicity sake

    private static Grid INSTANCE = new Grid();
    private static Background BG = new Background();

    protected ArrayList<Component> list;

    private Grid () {
        this.list = new ArrayList<Component>();
    }

    public static Grid getInstance(){
        return Grid.INSTANCE;
    }

    public void paintAll(Graphics g) {
        Grid.BG.draw(g);
        for(Component item: list)
           item.draw(g);
    }
    
    public void addBall() {
        list.add((Component) new Ball());
    }

    /**
     * Iterate throught list stepping only the balls.
     */
    public void stepBalls(){
        for(Component item: this.list){
            if(item instanceof Ball)
                ((Ball)item).step();
        }
        checkCollisions();
    }

    protected void checkCollisions(){
        //TODO implement bouncing DONE TODO Test
        //Wow CJ is stupid.. The ball has no mass dumbass.. thats what you assume
        //Fixing
        for(Component item: this.list){
            if(item instanceof Ball){
                Point3D currentPoint = ((Ball) item).getPoint();

                //Check Z-Plane 0 - Constants.SCREEN_DEPTH
                //Check X-Plane 0 - Constants.SCREEN_WIDTH
                //Check Y-Plane 0 - Constants.SCREEN_HEIGHT

                //New Method
                int ballRadius = Ball.SIZE;
                if(CollisionDetector.distanceCompare(currentPoint.getZ(), Constants.SCREEN_DEPTH, ballRadius)
                        || CollisionDetector.distanceCompare(currentPoint.getZ(), 0, ballRadius)){
                    ((Ball) item).bounce(Constants.PLANE_Z);
                    //System.out.println("Heres a collision Z");
                }
                if(CollisionDetector.distanceCompare(currentPoint.getY(), Constants.SCREEN_HEIGHT, ballRadius)
                        || CollisionDetector.distanceCompare(currentPoint.getY(), 0, ballRadius)){
                    ((Ball) item).bounce(Constants.PLANE_Y);
                    //System.out.println("Heres a collision Y");
                }
                if(CollisionDetector.distanceCompare(currentPoint.getX(), Constants.SCREEN_WIDTH, ballRadius)
                        || CollisionDetector.distanceCompare(currentPoint.getX(), 0, ballRadius)){
                    ((Ball) item).bounce(Constants.PLANE_X);
                    //System.out.println("Heres a collision X");
                }

                //Old method below
                /*if(currentPoint.getZ() < 0 ||
                        currentPoint.getZ() > Constants.SCREEN_DEPTH ) {
                    ((Ball)item).bounce(Constants.PLANE_Z);
                    //System.out.println("Heres a collision Z");
                }
                if (currentPoint.getX() < 0 ||
                        currentPoint.getX() > Constants.SCREEN_WIDTH){
                    ((Ball) item).bounce(Constants.PLANE_X);
                    //System.out.println("Heres a collision X");
                }
                if(currentPoint.getY() < 0 ||
                        currentPoint.getY() > Constants.SCREEN_HEIGHT){
                    ((Ball) item).bounce(Constants.PLANE_Y);
                    //System.out.println("Heres a collision Y");
                }*/
            }
        }
    }








}
