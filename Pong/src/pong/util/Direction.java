/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.util;

/** For purpose of a 3-Dimensional Vector that can return its magnitude.
 *
 * @author eric, cj
 */
public class Direction {
    
    protected int a, b, c;

    public Direction() {
    }

    public Direction(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getMagnitude(){
        //Magnitude = sqrt(a^2 + b^2 + c^2)
        return (int)(Math.sqrt(a * a + b * b + c * c));
    }

    @Override
    public Direction clone(){
        return new Direction(this.a, this.b, this.c);
    }

    @Override
    public String toString(){
        return "3D-Vector: a = " + this.a
                + " | b = " + this.b
                + " | c = " + this.c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
