/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.constants;

/**Stores the Constants for the 3D Pong game.
 *
 * @author CJ
 */
public class Constants {
    public static int DELAY = 100;
    public static int NUM_BALLS = 1;

    public static int SCREEN_WIDTH = 400;
    public static int SCREEN_HEIGHT = 400;
    public static int SCREEN_DEPTH = 800;

    //Plane ID
    public static int PLANE_Z = 0;
    public static int PLANE_X = 1;
    public static int PLANE_Y = 2;

    public static int MAX_BALL_RADIUS = 50;
    public static double MIN_BALL_RADIUS_PER = 0.3;

    //3D Constants
    public static int SCREEN_WIDTH_FAR = 100;
    public static int SCREEN_HEIGHT_FAR = 100;
    public static int DEAD_ZONE_X = SCREEN_WIDTH_FAR/2;
    public static int DEAD_ZONE_Y = SCREEN_HEIGHT_FAR/2;
    
    private Constants(){}

}
