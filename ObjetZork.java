/*@author ali et moussa
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class ObjetZork {
    private int poids;
    private String nom;
    private String description;
    
    
    // constructeur avec le nom de l'objet
    public ObjetZork(String nom){
        poids=Zork.POIDSMAX;
        this.nom=nom;
        description = "je suis un objet nontransportable";
    }
    
    // constructeur avec le nom et le poids de l'objet
    public ObjetZork(String nom,int poids){
        this.nom=nom;
        this.poids=poids;
        description = "cet objet est partiellement transportable";
    }
    
    // fonction de renvoie du poids
    public int getpoids(){
        return poids;
    }
    
    // fonction de renvoie du nom
    public String getnom(){
        return nom;
    }
    
    // fonction de renvoie du statu "trabsportable ou non"
    public boolean isTransportable(){
        return poids!=Zork.POIDSMAX;
        
    }
    
    
}
