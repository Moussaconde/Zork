import java.util.Map;
import java.util.*;
import java.util.HashMap;

/**
 *  Une piece dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Une "Piece" represente un des lieux dans lesquels se dأ©roule l'action du
 *  jeu. Elle est reliأ©e a au plus quatre autres "Piece" par des sorties. Les
 *  sorties sont أ©tiquettأ©es "nord", "est", "sud", "ouest". Pour chaque
 *  direction, la "Piece" possأ¨de une rأ©fأ©rence sur la piece voisine ou null
 *  s'il n'y a pas de sortie dans cette direction.</p>
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @version    1.2
 * @since      August 2000
 */

public class Piece {
 	private String description;
	// memorise les sorties de cette piece.
	private Map<Direction, Piece> sorties;
        // objet qui sera contenu dans les pieces.
        ArrayList<ObjetZork> LesObjets;
        ArrayList<Chien> LesChiens;
	
              
        
        

        
	/**
	 *  Initialise une piece dأ©crite par la chaine de caractأ¨res spأ©cifiأ©e.
	 *  Initialement, cette piece ne possأ¨de aucune sortie. La description fournie
	 *  est une courte phrase comme "la bibliothأ¨que" ou "la salle de TP".
	 *
	 * @param  description  Description de la piece.
	 */
	public Piece(String description) {
		this.description = description;
		sorties = new HashMap<Direction, Piece>();
                LesObjets=new ArrayList<ObjetZork>();
                LesChiens=new ArrayList<Chien>();
	}
        public Piece(){
            
        }

        public int nbObjets(){
            return LesObjets.size();
        }
        
        public void ajouter(ObjetZork Objet){
            LesObjets.add(Objet);
        }
        
        public void ajouterchien(Chien chien){
        LesChiens.add(chien);
    }
        
        public boolean retier(ObjetZork Objet){
            return LesObjets.remove(Objet);
        }
        
        public boolean contient(ObjetZork Objet){
            return LesObjets.contains(Objet);
        }
        
        
        //fonction qui affiche la liste des objets present dans une piece avec leur statut "transportable ou non"\
        
        public void nom(){
            for(ObjetZork ob: LesObjets){
                if(ob.isTransportable()){
                    System.out.println(ob.getnom()+" {Transportable}.");
                }
                else{
                    System.out.println(ob.getnom()+" {NON Transportable}.");
                }
            } 
        }
        /* affiche le nom des chiens se trouvant dans une pièce*/
        public void nomchien(){

		System.out.println("la liste des chiens dans cette pièce est : ");
            	for(Chien ch:LesChiens){
            	    System.out.println(ch.getnom());
            	}
        }
        
        
        
        public int contientcombiende(ObjetZork Objet){
            int res=0;
            for(ObjetZork obj : LesObjets){
                if(obj.equals(Objet)){
                    res++;
                }
            }
             return res;
        }
        
       /* public String nom(){
           
        }*/
	/**
	 *  Dأ©finie les sorties de cette piece. A chaque direction correspond ou bien
	 *  une piece ou bien la valeur null signifiant qu'il n'y a pas de sortie dans
	 *  cette direction.
	 *
	 * @param  nord   La sortie nord
	 * @param  est    La sortie est
	 * @param  sud    La sortie sud
	 * @param  ouest  La sortie ouest
	 */
	public void setSorties(Piece nord, Piece est, Piece sud, Piece ouest) {
		if (nord != null) {
			sorties.put(Direction.NORD, nord);
		}
		if (est != null) {
			sorties.put(Direction.EST, est);
		}
		if (sud != null) {
			sorties.put(Direction.SUD, sud);
		}
		if (ouest != null) {
			sorties.put(Direction.OUEST, ouest);
		}
	}


	/**
	 *  Renvoie la description de cette piece (i.e. la description spأ©cifiأ©e lors
	 *  de la crأ©ation de cette instance).
	 *
	 * @return    Description de cette piece
	 */
	public String descriptionCourte() {
		return description;
	}


	/**
	 *  Renvoie une description de cette piece mentionant ses sorties et
	 *  directement formatأ©e pour affichage, de la forme: <pre>
	 *  Vous etes dans la bibliothأ¨que.
	 *  Sorties: nord ouest</pre> Cette description utilise la chaine de caractأ¨res
	 *  renvoyأ©e par la mأ©thode descriptionSorties pour dأ©crire les sorties de
	 *  cette piece.
	 *
	 * @return    Description affichable de cette piece
	 */
	public String descriptionLongue() {
              return "dans " + description + ".\n"+ descriptionSorties() ;
 
	}

        public String descriptionlonguesansSorties(){
            return "dans " + description + ".\n" ;
        }
	/**
	 *  Renvoie une description des sorties de cette piece, de la forme: <pre>
	 *  Sorties: nord ouest</pre> Cette description est utilisأ©e dans la
	 *  description longue d'une piece.
	 *
	 * @return    Une description des sorties de cette piأ¨ce.
	 */
	public String descriptionSorties() {
		String resulString = "Sorties:";
		for (Direction sortie :  sorties.keySet()) {
			resulString += " " + sortie;
		}
		return resulString;
	}
      

	/**
	 *  Renvoie la piece atteinte lorsque l'on se dأ©place a partir de cette piece
	 *  dans la direction spأ©cifiأ©e. Si cette piece ne possأ¨de aucune sortie dans cette direction,
	 *  renvoie null.
	 *
	 * @param  direction  La direction dans laquelle on souhaite se dأ©placer
	 * @return            Piece atteinte lorsque l'on se dأ©place dans la direction
	 *      spأ©cifiأ©e ou null.
	 */
	public Piece pieceSuivante(Direction d) {
		return sorties.get(d);
	}
        
        
}

