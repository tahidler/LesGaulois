package personnages;
import personnages.Musee;

public class Gaulois {
	private int effetPotion = 1;
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " << " + texte + " >> ");
	}

//	private String prendreParole() {
//		return "(" + nom + ")- ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup(force/ 3)*effetPotion;
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesGagnes = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesGagnes != null && i < tropheesGagnes.length; i++, nbTrophees++) {
			trophees[nbTrophees] = tropheesGagnes[i];

		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("merci Druide je sens que ma force est " + effetPotion + "fois decuplée ");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public void faireUneDonnation(Musee musee){

		if (trophees != null) {
			StringBuilder bld = new StringBuilder("Je donne au musee tous mes trophees:");
			
			for (int i= 0; i < nbTrophees; i++) {
				bld.append("\n-" + trophees[i].toString());
				musee.donnerTrophee(nom, trophees[i]);
			}
			String texte = bld.toString();

			parler(texte);
		}
			

	}
	


	public static void main(String[] args) {

		Gaulois asterix = new Gaulois("asterix", 8);
		Romain beta = new Romain("Beta", 6);
		asterix.parler("Salut mariama");
		System.out.println(asterix);
		System.out.println("le gaulois " + asterix.getNom() + " vient d'atterir sur terre merci à tous.");
		asterix.frapper(beta);
		asterix.boirePotion(6);
		asterix.faireUneDonnation(null);
	}
}
