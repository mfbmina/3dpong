/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.util;

/**
 *
 * @author CJ
 */
public class Point2D {

    protected int x;
    protected int y;

    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Point2D clone(){
        return new Point2D(this.x , this.y);
    }

}
