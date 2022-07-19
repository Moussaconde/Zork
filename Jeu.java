import java.util.*;

/**
 *  Classe principale du jeu "Zork". <p>
 *
 *  Zork est un jeu d'aventure trأ¨s rudimentaire avec une interface en mode
 *  texte: les joueurs peuvent juste se dأ©placer parmi les diffأ©rentes pieces.
 *  Ce jeu nأ©cessite vraiment d'etre enrichi pour devenir intأ©ressant!</p> <p>
 *
 *  Pour jouer a ce jeu, crأ©er une instance de cette classe et appeler sa
 *  mأ©thode "jouer". </p> <p>
 *
 *  Cette classe crأ©e et initialise des instances de toutes les autres classes:
 *  elle crأ©e toutes les pieces, crأ©e l'analyseur syntaxique et dأ©marre le jeu.
 *  Elle se charge aussi d'exأecuter les commandes que lui renvoie l'analyseur
 *  syntaxique.</p>
 *
 * 
 */

public class Jeu {
	private AnalyseurSyntaxique analyseurSyntaxique;
	//private Piece pieceCourante;
        //private ObjetZork Objet;
        //private Joueur Joueur;
        
        
        ObjetZork ob,ob1,ob2,ob3,ob4,ob5,ob6,ob7,ob8,ob9,ob10,ob11,ob12;
        Chien ch1,ch2,ch3,ch4;
        
        Joueur joueur=new Joueur("Joueuer 1",30);
	/**
	 *  Cree le jeu et initialise la carte du jeu (i.e. les pièces).
	 */
	public Jeu() {
                
		creerPieces();
		analyseurSyntaxique = new AnalyseurSyntaxique();
	}
        
        
        public void creerchien(){
            ch1 = new Chien("milou",7);
            ch2 = new Chien("medor",12);
            ch3 = new Chien("Toupass",10);
            ch4 = new Chien("champion",5);
        }
        
        public void creerObjet(){
            
            ob=new ObjetZork("robinet");
            ob1=new ObjetZork("savon",15);
            ob2=new ObjetZork("Notes");
            ob3=new ObjetZork("fauteuil");
            ob4=new ObjetZork("fleur");
	    ob5=new ObjetZork("livres",3);
	    ob6=new ObjetZork("distributeur");
	    ob7=new ObjetZork("stylo",2);
	    ob8=new ObjetZork("chaise",2);
	    ob9=new ObjetZork("poubelle",2);
	    ob10=new ObjetZork("Tableau");
	    ob11=new ObjetZork("assiettes",1);
	    ob12=new ObjetZork("fourchettes",1);
	
        }
	/**
	 *  Cree toutes les pieces et relie leurs sorties les unes aux autres.
	 */
	public void creerPieces() {
		Piece dehors;
		Piece salleTD;
		Piece taverne;
		Piece batimentC;
		Piece burreau;
                Piece wc;
		Piece sallProf;
		Piece bde;
		Piece gymnase;
		Piece restoU;
                creerObjet();
                creerchien();
		// creation des pieces
                
                
		dehors = new Piece("devant le batiment C");
		restoU = new Piece("le restaurant Universitaire");
		salleTD = new Piece("une salle de TD dans le batiment G");
		taverne = new Piece("la taverne");
		batimentC = new Piece("le batiment C");
		burreau = new Piece("le secrétariat");
                wc=new Piece ("les toillettes");
		sallProf = new Piece("le bureau des professeurs");
		bde = new Piece ("le bureau des etudiants");
		gymnase = new Piece(" le gymnase de la fac");
                wc.ajouter(ob);
                wc.ajouter(ob1);
		burreau.ajouter(ob7);
                sallProf.ajouter(ob2);
		sallProf.ajouter(ob5);
                bde.ajouter(ob3);
		batimentC.ajouter(ob10);	
		salleTD.ajouter(ob9);
                dehors.ajouter(ob4);
		gymnase.ajouter(ob6);
		gymnase.ajouter(ob8);
		restoU.ajouter(ob11);
		restoU.ajouter(ob12);
                dehors.ajouterchien(ch1);
                dehors.ajouterchien(ch2);
                taverne.ajouterchien(ch3);
		gymnase.ajouterchien(ch4);
		// initialise les sorties des pieces
		dehors.setSorties(gymnase, salleTD, batimentC, taverne);
		salleTD.setSorties(sallProf, null, burreau, dehors);
		sallProf.setSorties(null,null,salleTD,gymnase);
		taverne.setSorties(restoU, dehors, wc, bde);
		bde.setSorties(null,taverne,null,null);
		gymnase.setSorties(null,sallProf,dehors,restoU);
		batimentC.setSorties(dehors, burreau, null, wc);
		burreau.setSorties(salleTD, null, null, batimentC);
                wc.setSorties(taverne, batimentC, null, null);
		restoU.setSorties(null,gymnase,taverne,null);
              
		// le jeu commence dehors
		joueur.pieceJoueur = dehors;
                
	}
        
     
	/**
	 *  Pour lancer le jeu. Boucle jusqu'a la fin du jeu.
	 */
	public void jouer() {
		afficherMsgBienvennue();
                joueur.pieceJoueur.nomchien();
		// Entree dans la boucle principale du jeu. Cette boucle lit
		// et execute les commandes entrأ©es par l'utilisateur, jusqu'a
		// ce que la commande choisie soit la commande "quitter"
		boolean termine = false;
		while (!termine && (joueur.score < 10)) {
			Commande commande = analyseurSyntaxique.getCommande();
			termine = traiterCommande(commande,joueur);
			if(joueur.score>=10){
				System.out.println("Felicitation vous venez de gagner !!!!!!!!");
				termine = true;
			}
		}
		System.out.println("Merci d'avoir jouer.  Au revoir.");
                
                
	}


	/**
	 *  Affiche le message d'accueil pour le joueur.
	 */
	public void afficherMsgBienvennue() {
		System.out.println();
		System.out.println("Bienvennue dans le monde de Zork !");
		System.out.println("Zork est un nouveau jeu d'aventure, terriblement enuyeux.");
		System.out.println("Tapez 'aide' si vous avez besoin d'aide.");
		
		System.out.println();
		joueur.afficherScore();
		System.out.println(joueur.getnom()+" "+joueur.pieceJoueur.descriptionLongue());
                
	}


	/**
	 *  Execute la commande specifiee. Si cette commande termine le jeu, la valeur
	 *  true est renvoyee, sinon false est renvoyee
	 *
	 * @param  commande  La commande a executer
	 * @return           true si cette commande termine le jeu ; false sinon.
	 */
	public boolean traiterCommande(Commande commande,Joueur Joueur) {
		if (commande.estInconnue()) {
			System.out.println("Je ne comprends pas ce que vous voulez...");
			return false;
		}

		String motCommande = commande.getMotCommande();
		if (motCommande.equals("aide")) {
			afficherAide();
		} else if (motCommande.equals("aller")) {
			Joueur.deplacerJoueurVersPiece(commande,Joueur);
		} else if(motCommande.equals("transporter")){
                        Joueur.TransporterObjet(commande,Joueur);
                } else if(motCommande.equals("deposer")){
                        Joueur.DeposerObjet(commande, Joueur);
                } else if(motCommande.equals("adopter")){
                        Joueur.AdopterChien(commande, Joueur);
                } else if(motCommande.equals("liberer")){
                        Joueur.LibereChien(commande, Joueur);
                } else if(motCommande.equals("ramasser")){
                        Joueur.Ramasser(commande,Joueur);
                }   
                else if (motCommande.equals("quitter")) {
			if (commande.aSecondMot()) {
				System.out.println("Quitter quoi ?");
			} else {
				return true;
			}
		}
		return false;
	}


	// implementations des commandes utilisateur:

	/**
	 *  Affichage de l'aide. Affiche notament la liste des commandes utilisables.
	 */
	public void afficherAide() {
		System.out.println("Vous etes perdu. Vous etes seul. Vous errez");
		System.out.println("sur le campus de l'Universitأ© Paris 13.");
		System.out.println();
		System.out.println("Les commandes reconnues sont:");
		analyseurSyntaxique.afficherToutesLesCommandes();
	}


	/**
	 *  Tente d'aller dans la direction specifiee par la commande. Si la piece
	 *  courante possede une sortie dans cette direction, la piece correspondant a
	 *  cette sortie devient la piece courante, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot specifie la direction a suivre
	 */
	/*public void deplacerVersAutrePiece(Commande commande) {
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Aller oأ¹ ?");
			return;
		}

		String direction = commande.getSecondMot();
		Direction d = null;
		try {
		    d = Direction.valueOf(direction);
		  } catch (IllegalArgumentException e) {
		      System.out.println("Pour indiquer une direction entrez une des chaأ®nes de caractأ¨res suivantes:");
		      for (Direction dok : Direction.values()) {
		          System.out.println("-> \"" + dok + "\"");
		      }
		      return;
		  }

		// Tentative d'aller dans la direction indiquأ©e.
		Piece pieceSuivante = pieceCourante.pieceSuivante(d);

		if (pieceSuivante == null) {
			System.out.println("Il n'y a pas de porte dans cette direction!");
		} else {
                        
			pieceCourante = pieceSuivante;
                        if(pieceCourante.nbObjets() == 0){
                            
                            System.out.println(pieceCourante.descriptionLongue());
                            
                        }
                        else{
                            int nb= pieceCourante.nbObjets();
                            
                            System.out.println(pieceCourante.descriptionLongue()+ "\n il y a: "+nb+" Objet " +"de type: ");
                            pieceCourante.nom();
                            
                            
                        }
			
		}
	}*/
}


