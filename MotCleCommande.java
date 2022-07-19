import java.util.*;
/**
 *  <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Classe rأ©pertoriant l'ensemble des mots-clأ© utilisables comme commande dans
 *  le jeu. Elle est utilisأ©e pour vأ©rifier la validitأ© des commandes de
 *  l'utilisateur.
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @version    1.0
 * @since      July 1999
 */



public class MotCleCommande {
	/**
	 *  Un tableau constant contenant tous les mots-clأ© valides comme commandes.
	 */
	private final static String commandesValides[] = {"aller", "quitter", "aide","transporter","deposer","adopter","liberer","ramasser"};
        //private Joueur joueur;
        //ArrayList<Chien> ListeChien;

	/**
	 *  Initialise la liste des mots-clأ© utilisables comme commande.
	 */
	public MotCleCommande() { }


	/**
	 *  Teste si la chaine de caractأ¨res spأ©cifiأ©e est un mot-clأ© de commande
	 *  valide. Check whether a given String is a valid command word. Return true
	 *  if it is, false if it isn't.
	 *
	 * @param  aString  Chaine de caractأ¨res a tester
	 * @return          true si le paramأ¨tre est une commande valide, false sinon
	 */
	public boolean estCommande(String aString) {
		for (int i = 0; i < commandesValides.length; i++) {
			if (commandesValides[i].equals(aString)) {
				return true;
			}
		}
                /*for(Chien ch: joueur.pieceJoueur.LesChiens){
                    if(ch.getnom().equals(aString)){
                        return true;
                    }
                }
                for (int i = 0; i < les.LesObjets.size() ; i++){
                    if(aString=)
                }*/
		return false;
	}


	/**
	 *  Affiche toutes les commandes (i.e. les mots-clأ©) valides.
	 */
	public void afficherToutesLesCommandes() {
		for (int i = 0; i < commandesValides.length; i++) {
			System.out.print(commandesValides[i] + "  ");
		}
		System.out.println();
	}
}

