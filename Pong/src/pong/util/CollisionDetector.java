/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.util;

/**
 * Class containing static methods to help the collision detection
 * @author CJ
 */
public class CollisionDetector {
    private CollisionDetector(){}//Haha you can't make me

    /**
     * Should be used to compare against a wall, can be modified too lazy right
     * now.
     * @param point
     * @param wall
     * @return
     */
    public static boolean distanceCompare(int point, int wall, int minDistance){
        if(point < 0 || wall < 0){
            throw new IllegalArgumentException("In distanceCompare: point/wall is neg.");
        }
        if(Math.abs(point - wall) < minDistance){
            return true;
        }
        return false;
    }

}
