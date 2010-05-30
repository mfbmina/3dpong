/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.frontEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import pong.components.Ball;
import pong.components.Component;

/**
 *
 * @author eric
 */
public class Grid {

    ArrayList<Component> list = new ArrayList<Component>();

    public Grid () {

    }

    void paintAll(Graphics g) {
        for(Component item: list)
           item.draw(g);
    }

    public void addBall() {
        list.add((Component) new Ball());
    }






}
