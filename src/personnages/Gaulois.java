package personnages;

public class Gaulois {
	
	private String nom;
	private int force;
	private int effetPotion =1;
	private int forces, nb_trophees;
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}


	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesGagnes = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesGagnes != null && i < tropheesGagnes.length; i++, nb_trophees++) {
			trophees[nb_trophees] = tropheesGagnes[i];

		}
		
	}
	
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("merci Druide je sens que ma force est " + effetPotion + "fois decuplée ");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
				+ ", effetPotion=" + effetPotion + "]";
	}
	
	public void faireUneDonnation(Musee musee){

		if (trophees != null) {
			StringBuilder bld = new StringBuilder("Je donne au musee tous mes trophees:");
			
			for (int i= 0; i < nbTrophees; i++) {
				bld.append("\n-" + trophees[i].toString());
				musee.donnerTrophees(this, trophees[i]);
			}
			String texte = bld.toString();

			parler(texte);
		}
			

	}
	
	public static void main(String[] args) {
		//TODO cr�er un main permettant de tester la classe Gaulois
		Gaulois asterix = new Gaulois("asterix", 8);
		System.out.println(asterix);
		
		
	}
	
	
}

