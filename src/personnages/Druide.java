package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
		
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
			+ effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	// private Random random = SecureRandom.getInstanceStrong();
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMin, effetPotionMax);

		if (forcePotion > effetPotionMax && forcePotion < effetPotionMin) {
			parler("j'ai preparé une super potion de force " + forcePotion + ".");
		} else {
			parler("je n'ai pas trouvé tous les ingredients, ma potion est seulement de force" + forcePotion + ".");
		}
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() != null && gaulois.getNom().equals("Obélix")) {
			parler("Non ,Obélix !... tu n'auras pas de potion magique");
		} else {
			gaulois.boirePotion(forcePotion);
		}

	}
	
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("panoramix", 5, 10);
		panoramix.preparerPotion();

	}

}