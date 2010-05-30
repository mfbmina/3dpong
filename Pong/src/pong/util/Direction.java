/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.util;

/**
 *
 * @author eric
 */
public class Direction {
    
    protected int a, b, c;

    public Direction(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getMagnitude(){
        //Magnitude = sqrt(a^2 + b^2 + c^2)
        return (int)(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
    }
}
