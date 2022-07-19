/**
 *  <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Cette classe rأ©pertorie les informations liأ©es a une commande entrأ©e par
 *  l'utilisateur. Une commande est constituأ©e de deux chaines de caractأ¨res: un
 *  mot-clأ© de commande et un second mot apportant un complأ©ment (un paramأ¨tre)
 *  au mot-clأ© indiquant la commande a exأ©cuter (par exemple, si la commande
 *  entrأ©e par l'utilisateur est "prendre carte", alors les deux chaines de
 *  caractأ¨res sont "prendre" et "carte").</p> <p>
 *
 *  Les mots utilisأ©s lors de l'initialisation d'une instance de cette classe
 *  sont supposأ©s venir d'une commande utilisateur dont la validitأ© a dأ©jأ  أ©tأ©
 *  testأ©e:
 *  <ul>
 *    <li> si le mot commande entrأ© par l'utilisateur ne correspond pas a une
 *    commande valide, alors la valeur du mot commande donnأ© a l'initialisation
 *    doit etre null</li>
 *    <li> si la commande entrأ©e par l'utilisateur ne contient pas d'autre mot
 *    que le mot commande, alors la valeur du second mot donnأ© a
 *    l'initialisation doit etre null</li>
 *  </ul>
 *  La validitأ© du second mot n'est pas testأ©e, sa valeur peut etre quelconque.
 *  </p>
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @version    1.0
 * @since      July 1999
 */

public class Commande {
	private String motCommande;
	private String secondMot;


	/**
	 *  Initialise une Commande a partir des deux mots spأ©cifiأ©s. <p>
	 *
	 *  Le premier argument reprأ©sente un mot commande, sa valeur peut etre null si
	 *  le mot commande ne correspond pas a une commande valide. Le second mot peut
	 *  أ©galement etre null dans le cas ou l'utilisateur n'aurait pas fourni de
	 *  second mot dans sa commande.</p>
	 *
	 * @param  motCommande  Le mot commande de la commande utilisateur ou null
	 * @param  secondMot    Le second mot de la commande utilisateur ou null
	 */
	public Commande(String motCommande, String secondMot) {
		this.motCommande = motCommande;
		this.secondMot = secondMot;
	}

        

	/**
	 *  Renvoie le mot commande (le premier mot) de cette Commande. Si cette
	 *  commande n'est pas une commande valide, la valeur renvoyأ©e est null.
	 *
	 * @return    Le mot commande de cette Commande ou null
	 */
	public String getMotCommande() {
		return motCommande;
	}


	/**
	 *  Renvoie le second mot de cette Commande ou null si cette commande ne
	 *  possأ¨de pas de second mot.
	 *
	 * @return    le second mot de cette Commande ou null
	 */
	public String getSecondMot() {
		return secondMot;
	}


	/**
	 *  Teste si cette commande est une commande reconnue par le jeu.
	 *
	 * @return    true si cette commande est valide ; false sinon
	 */
	public boolean estInconnue() {
		return (motCommande == null);
	}


	/**
	 *  Teste si cette commande possأ¨de un second mot.
	 *
	 * @return    true si cette commande possأ¨de un second mot ; false sinon
	 */
	public boolean aSecondMot() {
		return (secondMot != null);
	}
}

