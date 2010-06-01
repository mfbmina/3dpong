/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.frontEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import pong.components.Background;
import pong.components.Ball;
import pong.components.Component;

/** Singleton Grid Class.
 *
 * @author eric
 */
public class Grid {

    //Ya.. i made it a singleton for simplicity sake

    private static Grid INSTANCE = new Grid();

    protected ArrayList<Component> list;

    private Grid () {
        this.list = new ArrayList<Component>();
    }

    public static Grid getInstance(){
        return Grid.INSTANCE;
    }

    public void paintAll(Graphics g) {
        for(Component item: list)
           item.draw(g);
    }

    public void setBackground() {
        list.add((Component) new Background());
    }
    
    public void addBall() {
        list.add((Component) new Ball());
    }

    /**
     * Iterate throught list stepping only the balls.
     */
    public void stepBalls(){
        for(Component item: this.list){
            if(item instanceof Ball)
                ((Ball)item).step();
        }
        checkCollisions();
    }

    protected void checkCollisions(){
        //TODO implement bouncing
    }






}
