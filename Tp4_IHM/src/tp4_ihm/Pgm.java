/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4_ihm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 */
public class Pgm {
    
    private int largeur, hauteur;
    private Integer[][] tab;
    
    public Pgm() {;}
    
    public Pgm (Pgm p) {
        this.hauteur = p.hauteur;
        this.largeur = p.largeur;
        
        tab = new Integer[this.hauteur][this.largeur];
        
        for (int i = 0; i < this.hauteur; i++) {     
            for (int j = 0; j < this.largeur; j++) {
            
                tab[i][j] = new Integer(p.tab[i][j]);
            } 
        }
    }
    
    public void load(String fichier) throws FileNotFoundException {
        
        File file = new File(fichier);
        Scanner scan = new Scanner(file);
        
        String ligne;
        int maxValue;
        
        ligne = new String(scan.nextLine());
        
        if (ligne.contains("P2")) {
            
            boolean valid = false; 
            
            while (valid == false) {
                ligne = new String(scan.nextLine());
                
                if (ligne.startsWith("#")) {
                    valid = false;
                } else {
                    valid = true;
                }
            }
            this.hauteur = Integer.parseInt(ligne.substring(0,4).trim());
            this.largeur = Integer.parseInt(ligne.substring(4,7).trim());
            maxValue = scan.nextInt();
            
            tab = new Integer[this.hauteur][this.largeur];
        
            for (int i = 0; i < this.hauteur; i++) {     
                for (int j = 0; j < this.largeur; j++) {

                    tab[i][j] = new Integer(scan.nextInt());
                } 
            }
            
        }
        
    }
    
}
