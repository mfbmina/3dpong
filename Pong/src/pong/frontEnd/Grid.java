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
import pong.components.Paddle;
import pong.constants.Constants;
import pong.util.CollisionDetector;
import pong.util.Point2D;
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
        Paddle.getInstance().draw(g);
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

                if(currentPoint.getZ() < 0)
                    throw new IllegalStateException("Game Over");

                //New Method
                int ballRadius = Ball.SIZE;
                if(CollisionDetector.distanceCompare(currentPoint.getZ(), Constants.SCREEN_DEPTH, ballRadius)){
                    ((Ball) item).bounce(Constants.PLANE_Z);
                    //System.out.println("Heres a collision Z");
                }else if(CollisionDetector.distanceCompare(currentPoint.getZ(), 0, ballRadius)){
                    //Need to check if intercepted by paddle
                    Point2D paddlePoint = Paddle.getInstance().getPoint();
                    if (CollisionDetector.distanceCompare(currentPoint.getX(), paddlePoint.getX(), Constants.PADDLE_SIZE / 2)
                         && CollisionDetector.distanceCompare(currentPoint.getY(), paddlePoint.getY(), Constants.PADDLE_SIZE / 2)) {
                        ((Ball) item).bounce(Constants.PLANE_Z);
                        System.out.println("Paddle Bounce");
                    }

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
            }
        }
    }








}
