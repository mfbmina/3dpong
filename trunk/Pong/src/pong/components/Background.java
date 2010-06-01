/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong.components;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


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
        g.drawImage(bg, 0, 0, null);
    }

}
