/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pong.constants.Constants;


/**
 *
 * @author eric
 */
public class Background extends Component {

    Image bg;

    public Background() {
        try {
            bg = ImageIO.read(new File("src/pong/resources/background.jpg"));
        } catch(IOException e) {System.out.println(e.getMessage());}
    }
    
    public void draw(Graphics g) {
        //g.drawImage(bg, 0, 0, null);
        g.setColor(Color.black);
        g.drawRect(Constants.SCREEN_WIDTH/2-Constants.SCREEN_WIDTH_FAR/2, Constants.SCREEN_HEIGHT/2 - Constants.SCREEN_HEIGHT_FAR/2,
                Constants.SCREEN_WIDTH_FAR, Constants.SCREEN_HEIGHT_FAR);
    }

}
