import java.util.*;
/* @author ali et Moussa
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Joueur {
    
    ArrayList<ObjetZork> inventaire;
    ArrayList<Chien> ListeChien;
    private String nom;
    private int poids;
    Piece pieceJoueur;
    int score;
    
    
    
    public Joueur(String nom){
        this(nom,Zork.POIDSMAX);
//        this.nom=nom;
//        this.poids=Zork.POIDSMAX;
//        inventaire=new ArrayList<ObjetZork>();
//        ListeChien=new ArrayList<Chien>();
//        pieceJoueur = new Piece();
    }
    
    public Joueur(String nom,int poids){
        this.nom=nom;
        this.poids=poids;
        inventaire=new ArrayList<ObjetZork>();
        ListeChien=new ArrayList<Chien>();
        pieceJoueur = new Piece();
	this.score = 0;
    }
    
    
    public void ajouter(ObjetZork Objet){
        if(Objet.isTransportable()){
            if(poids+Objet.getpoids()<Zork.POIDSMAX){
                 poids=poids+Objet.getpoids();
                 inventaire.add(Objet);
            }   
        }
    }
    
    public void incrementeScore(){
	this.score++;
    }
    
    public void decrementeScore(){
	this.score--;
    }
    
    public void afficherScore(){
	System.out.println("score: " +this.score);	
    }
    
    public void retier(ObjetZork Objet){
        if(inventaire.remove(Objet)){
            poids=poids-Objet.getpoids();
        }
    }
    
    public String getnom(){
        return this.nom;
    }
    
    public void lesobjetjoueur(){
        for(ObjetZork ob: inventaire){
            System.out.println(ob.getnom());
        }
    }
    
    public void leschiensjoueur(){	

        for(Chien ch: ListeChien){
            System.out.println(ch.getnom());
        }
    }
    
    public int getpoids(){
        return this.poids;
    }
    
    /* fonction importante du jeu 
     * permet de deplacer le joueur d'une piece à une autre 
     * si la commande entrée est correcte
     */
    public void deplacerJoueurVersPiece(Commande commande,Joueur joueur) {
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Aller où ?");
			return;
		}

		String direction = commande.getSecondMot();
		Direction d = null;
		try {
		    d = Direction.valueOf(direction);
		  } catch (IllegalArgumentException e) {
		      System.out.println("Pour indiquer une direction entrez une des chaines de caractères suivantes:");
		      for (Direction dok : Direction.values()) {
		          System.out.println("-> \"" + dok + "\"");
		      }
		      return;
		  }

		// Tentative d'aller dans la direction indiqué.
                
		Piece pieceSuivante = pieceJoueur.pieceSuivante(d);

		if (pieceSuivante == null) {
			System.out.println("Il n'y a pas de porte dans cette direction!");
		} else  {
                        //int nb= pieceJoueur.nbObjets();
                        //int nbch= pieceJoueur.LesChiens.size();
                        
			pieceJoueur = pieceSuivante;
                        if(pieceJoueur.nbObjets() == 0 && joueur.ListeChien.isEmpty()&& joueur.pieceJoueur.LesChiens.isEmpty()){
                            int nbch= pieceJoueur.LesChiens.size();
                            int nb= pieceJoueur.nbObjets();
                            System.out.println(joueur.getnom()+ " est "+ pieceJoueur.descriptionLongue());
                            System.out.println("il y a "+nb+" Objet dans cette piece : ");
                            System.out.println("il y a "+nbch+" chien(s) dans cette piece : ");
                            
                        } else if(pieceJoueur.nbObjets() == 0 && joueur.ListeChien.isEmpty()&& !joueur.pieceJoueur.LesChiens.isEmpty()){
                            int nbch= pieceJoueur.LesChiens.size();
                            System.out.println(joueur.getnom()+ " est "+ pieceJoueur.descriptionlonguesansSorties());
                            System.out.println("il y a "+nbch+" chien(s) dans cette piece : ");
                            pieceJoueur.nomchien();
                            System.out.println(pieceJoueur.descriptionSorties());
                            
                        }else if(pieceJoueur.nbObjets()==0&& !joueur.ListeChien.isEmpty()&& joueur.pieceJoueur.LesChiens.isEmpty()){
                            System.out.print(joueur.getnom()+ " et ");
                            for(Chien ch:ListeChien){
                                System.out.print(ch.getnom()+" ,");
                            }
                            System.out.println(" sont "+pieceJoueur.descriptionLongue()+ "\n");
                            
                        }else if(pieceJoueur.nbObjets()==0 && !joueur.ListeChien.isEmpty()&& !joueur.pieceJoueur.LesChiens.isEmpty()){
                            int nbch= pieceJoueur.LesChiens.size();
                            System.out.print(joueur.getnom()+ " et ");
                            for(Chien ch:ListeChien){
                                System.out.print(ch.getnom()+" ,");
                            }
                            System.out.println(" sont "+pieceJoueur.descriptionlonguesansSorties());
                            System.out.println("il y a "+nbch+" chien(s) dans cette piece : ");
                            pieceJoueur.nomchien();
                            System.out.println(pieceJoueur.descriptionSorties());
                        }
                        else if(pieceJoueur.nbObjets()!=0 && joueur.ListeChien.isEmpty()&& joueur.pieceJoueur.LesChiens.isEmpty()){
                                int nbch= pieceJoueur.LesChiens.size();
                                int nb= pieceJoueur.nbObjets();
                                System.out.println(joueur.getnom()+" est "+pieceJoueur.descriptionlonguesansSorties()+ "il y a "+nb+" Objet(s) : ");
                                pieceJoueur.nom();
                                System.out.println("il y a "+nbch+" chien(s) dans cette piece. ");
                                
                                System.out.println(pieceJoueur.descriptionSorties());
                            
                        }else if(pieceJoueur.nbObjets()!=0 && joueur.ListeChien.isEmpty()&& !joueur.pieceJoueur.LesChiens.isEmpty()){
                                int nbch= pieceJoueur.LesChiens.size();
                                int nb= pieceJoueur.nbObjets();
                                System.out.println(joueur.getnom()+" est "+pieceJoueur.descriptionlonguesansSorties()+ "il y a "+nb+" Objet(s) :");
                                pieceJoueur.nom();
                                System.out.println("il y a "+nbch+" chien(s) dans cette piece : ");
                                pieceJoueur.nomchien();
                                System.out.println(pieceJoueur.descriptionSorties());
                            
                        }else if(pieceJoueur.nbObjets()!=0 && !joueur.ListeChien.isEmpty()&& joueur.pieceJoueur.LesChiens.isEmpty()){
                                int nbch= pieceJoueur.LesChiens.size();
                                int nb= pieceJoueur.nbObjets();
                                System.out.print(joueur.getnom()+ " et ");
                                for(Chien ch:ListeChien){
                                     System.out.print(ch.getnom()+" ,");
                                }
                                System.out.println(" sont "+pieceJoueur.descriptionlonguesansSorties()+ "il y a "+nb+" Objet(s) : ");
                                pieceJoueur.nom();
                                System.out.println("il y a "+nbch+" chien(s) dans cette piece. ");
                                
                                System.out.println(pieceJoueur.descriptionSorties());  
                                
                        }
                        else{
                            int nb= pieceJoueur.nbObjets();
                            int nbch= pieceJoueur.LesChiens.size();
                            System.out.print(joueur.getnom()+ " et ");
                                for(Chien ch:ListeChien){
                                System.out.print(ch.getnom()+" ,");
                                }
                            System.out.println(" sont "+pieceJoueur.descriptionlonguesansSorties()+ "il y a "+nb+" Objet(s): ");
                            pieceJoueur.nom();
                            System.out.println("il y a "+nbch+" chien(s) dans cette piece : ");
                            pieceJoueur.nomchien();
                            System.out.println(pieceJoueur.descriptionSorties());    
                        }
			
		}
	}
    /* fonction qui permet d'ajouter un objet a une listre */
    public void Transporter(Joueur joueur,ObjetZork objet){
        
        if(objet.isTransportable()){
            if(joueur.getpoids()+objet.getpoids()<=Zork.POIDSMAX){
                inventaire.add(objet);
		joueur.incrementeScore();
		
		joueur.poids = joueur.getpoids() + objet.getpoids();
                
                //joueur.ajouter(objet);
                joueur.pieceJoueur.LesObjets.remove(objet);
                System.out.println(objet.getnom()+" se trouve dans votre sac.\n");
		joueur.afficherScore();
                System.out.println("la liste des objets dans "+joueur.pieceJoueur.descriptionCourte()+" est :");
                joueur.pieceJoueur.nom();
		System.out.println(pieceJoueur.descriptionSorties()); 
            }
        }else{
            System.out.println("vous ne pouvez pas transporter cet objet. votre poids est : "+joueur.getpoids()+"kg + poids d'objet est : "+objet.getpoids()+"kg. la limite autorisé est: "+Zork.POIDSMAX+"kg.\n");
	    System.out.println(pieceJoueur.descriptionSorties()); 
        }
    }

    /* fonction qui retire un objet specifique d'une liste */
    public void Deposer(Joueur joueur,ObjetZork objet){
        inventaire.remove(objet);
	joueur.decrementeScore();
	joueur.poids = joueur.getpoids() - objet.getpoids();
        pieceJoueur.LesObjets.add(objet);
        System.out.println("vous avez déposé "+objet.getnom()+" avec succes.\n");
	joueur.afficherScore();
        System.out.println("la liste des objets dans "+joueur.pieceJoueur.descriptionCourte()+" est :");
        joueur.pieceJoueur.nom();
	System.out.println(pieceJoueur.descriptionSorties()); 
    }
    
   /* fonction qui permet de transporter un objet en l'ajoutant à la liste d'objet du joueur 
    * si le poids maximum est atteind, impossible de faire l'ajout
    */	 
    public void TransporterObjet(Commande commande,Joueur joueur) {
               
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Transporter quoi? " );
			
		}else{
                    for(ObjetZork ob : joueur.pieceJoueur.LesObjets){  
                       
                        if(ob.getnom().equals(commande.getSecondMot())){
                            Transporter(joueur,ob);
                            return;
                            
                        }
                    }
                 
                }
	}   
    
	
    /* fonction qui depose un objet dans une piece en le retirant de la liste des objets du joueur */
    public void DeposerObjet(Commande commande,Joueur joueur) {
               
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
                        if(joueur.inventaire.isEmpty()){
                            System.out.println("votre sac est vide, vous ne pouvez pas deposer d'objets ");
                        }else{
                            System.out.println("Deposer quoi? votre list d'objets est :");
                            joueur.lesobjetjoueur();
                        
                            
                        }
			
		}else{
                    for(ObjetZork ob: joueur.inventaire){      
                        if(ob.getnom().equals(commande.getSecondMot())){
                            joueur.Deposer(joueur, ob);
                            
                            return;
                        }
                    }
                 
                }
	}  
    /* fonction qui permet d'apopter un chien 
     * en le mettant dans la liste des chiens adoptés par le joueur
     * une fois adopté le chien se deplace en meme temps que le joueur 
     */
    public void AdopterChien(Commande commande,Joueur joueur){
        if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Adopter qui? " );
			
		}else{
                    for(Chien ch : joueur.pieceJoueur.LesChiens){  
                        if(ch.getnom().equals(commande.getSecondMot())){
                            joueur.ListeChien.add(ch);
                            joueur.pieceJoueur.LesChiens.remove(ch);
                            System.out.println(ch.getnom()+" se trouve a cote vous.\n");
                            System.out.println("le reste de(s) chien(s) "+joueur.pieceJoueur.descriptionCourte()+" est :");
                            joueur.pieceJoueur.nomchien();
                            System.out.println(pieceJoueur.descriptionSorties());
                            return;
                            
                        }
                    }
                 
                }
    }

    /* fonction qui retire un chien de la liste des chiens apotés*/
    public void LibereChien(Commande commande,Joueur joueur) {
               
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
                        if(joueur.ListeChien.isEmpty()){
                            System.out.println("vous n'avez pas de chien a liberer ");
                        }else{
                            System.out.println("liberer qui? votre liste de chien adopter :");
                            joueur.leschiensjoueur();
                        
                            
                        }
			
		}else{
                    for(Chien ch: joueur.ListeChien){      
                        if(ch.getnom().equals(commande.getSecondMot())){
                             joueur.ListeChien.remove(ch);
                             pieceJoueur.LesChiens.add(ch);
                             System.out.println("vous avez liberer "+ch.getnom()+" avec succes.\n");
                             System.out.println("la liste des chiens dans "+joueur.pieceJoueur.descriptionCourte()+" est :");
                             joueur.pieceJoueur.nomchien();
			     System.out.println(pieceJoueur.descriptionSorties()); 
                            
                            return;
                        }
                    }
                 
                }
	}  
    /* fonction qui permet d'ajouter un objet dans la liste des objets d'un chien */

     public void Ramasser(Commande commande, Joueur joueur){
        if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Ramasser quoi? " );
			
		}else{
                    for(ObjetZork ob : joueur.pieceJoueur.LesObjets){  
                       
                        if(ob.getnom().equals(commande.getSecondMot()) && ob.isTransportable()){
				// s'il n'y a qu'un seul chien adopté
				if(joueur.ListeChien.size()==1){
					joueur.ListeChien.get(0).ObjetChien.add(ob);
					joueur.incrementeScore();
					joueur.incrementeScore();
					joueur.pieceJoueur.LesObjets.remove(ob);
					System.out.println(ob.getnom()+ " ajouté au sac de "+ joueur.ListeChien.get(0).getnom()+ " avec succès");
					joueur.afficherScore();
					System.out.println(pieceJoueur.descriptionSorties()); 
				}else{


				}
                            
                            
                            return;
                            
                        }
                    }
                 
                }
    }

    /*public boolean gagner(Joueur joueur){
	if(joueur.score == 15){
		return true;
	}
	return false;
    }*/
    
    
}
