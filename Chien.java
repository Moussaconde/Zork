import java.util.*;
/*@author ali et moussa
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Chien {
    
    private String nom;
    ArrayList<ObjetZork> ObjetChien;
    private int PoidsMax;
    
    private int nbObjet;
    
    
    public Chien(String nom, int PoidsMax){
        this.nom=nom;
        this.PoidsMax=PoidsMax;
        ObjetChien = new ArrayList<ObjetZork>();
    }
    
    
    public String getnom(){
        return nom;
    }
    
    public int getpoids(){
        return PoidsMax;
    }
    
   
        
        
        
        
    
    
    
    
    
    
    
    
}
