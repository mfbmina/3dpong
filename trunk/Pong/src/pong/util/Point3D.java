/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.util;

/** A representation of a 3D point in space.
 *
 * @author CJ
 */
public class Point3D {

    private int x;
    private int y;
    private int z;

    private Point3D() {
    }

    public Point3D (int a, int b, int c) {
        x = a;
        y = b;
        z = c;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

}
