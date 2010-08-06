/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.components;

import java.awt.Color;
import java.awt.Graphics;
import pong.constants.Constants;
import pong.util.Point2D;

/**
 *
 * @author eric, Cj
 */
public class Paddle extends Component {

    protected Point2D point;

    protected static Paddle thePaddle = new Paddle();

    private Paddle() {
        this.point = new Point2D(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);
    }

    public void setPoint(Point2D point){
        this.point = point;
    }

    public Point2D getPoint(){
        return this.point;
    }

    public static Paddle getInstance(){
        return Paddle.thePaddle;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawRect(this.point.getX() - Constants.PADDLE_SIZE/2, this.point.getY() - Constants.PADDLE_SIZE/2,
                Constants.PADDLE_SIZE, Constants.PADDLE_SIZE);
        g.drawLine(this.point.getX() - Constants.PADDLE_SIZE/2, this.point.getY() - Constants.PADDLE_SIZE/2,
                this.point.getX() + Constants.PADDLE_SIZE/2, this.point.getY() + Constants.PADDLE_SIZE/2);
        g.drawLine(this.point.getX() - Constants.PADDLE_SIZE/2, this.point.getY() + Constants.PADDLE_SIZE/2,
                this.point.getX() + Constants.PADDLE_SIZE/2, this.point.getY() - Constants.PADDLE_SIZE/2);
    }
}
