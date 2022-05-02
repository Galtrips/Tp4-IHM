/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4_ihm;

import java.io.FileNotFoundException;

/**
 * 
 */
public class Tp4_IHM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Windows win = new Windows();
        win.setVisible(true);
        */
        
        Pgm test = new Pgm();
        test.load("./images/image1.pgm");
        
    }
    
}
