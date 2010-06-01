/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;

import javax.swing.JFrame;
import pong.frontEnd.GameEngine;

/**
 *
 * @author CJ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("3D Pong - By Eric + CJ");

        GameEngine engine = new GameEngine();

        frame.setContentPane(engine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setFocusable(true);
        frame.setVisible(true);

        engine.run();

    }

}
