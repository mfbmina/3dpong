/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.frontEnd;

import java.util.ArrayList;
import pong.components.Ball;
import pong.components.Component;

/**
 *
 * @author eric
 */
public class Grid<Component> {

    ArrayList<Component> list = new ArrayList<Component>();

    public Grid () {

    }

    public void addBall() {
        list.add((Component) new Ball());
    }


}
