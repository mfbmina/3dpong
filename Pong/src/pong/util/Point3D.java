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

    private int x, y, z;

    public Point3D (int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public Point3D clone(){
        return new Point3D(this.x, this.y, this.z);
    }

}
