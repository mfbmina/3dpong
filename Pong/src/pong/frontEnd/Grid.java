/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.frontEnd;

import java.util.ArrayList;
import pong.components.Ball;

/**
 *
 * @author eric
 */
public class Grid<E> {

    ArrayList<E> list = new ArrayList<E>();

    public Grid () {

    }

    public void addBall() {
        list.add((E) new Ball());
    }


}
