// Classe Gaulois
public class Gaulois {
    private String nomGaulois;
    private int force;

    public Gaulois(String nomGaulois, int force) {
        this.nomGaulois = nomGaulois;
        this.force = force;
    }

    public String getNomGaulois() {
        return nomGaulois;
    }

    public int getForce() {
        return force;
    }
}

// Classe Chef
	public class Chef extends Gaulois {
		public Chef(String nomGaulois, int force) {
			super(nomGaulois, force);
		}
	}

// Classe Village
public class Village {
    private String nom;
    private Chef chef;
    private Gaulois[] villageois;
    private int nbVillageois;
    private int nbVillageoisMax;

    public Village(String nom, int nbVillageoisMax) {
        this.nom = nom;
        this.nbVillageoisMax = nbVillageoisMax;
        this.villageois = new Gaulois[nbVillageoisMax];
        this.nbVillageois = 0;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterHabitant(Gaulois gaulois) {
        if (nbVillageois < nbVillageoisMax) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
        } else {
            System.out.println("Nombre de villageois max atteint.");
        }
    }

    public Gaulois trouverHabitant(int numVillageois) {
        if (numVillageois >= 0 && numVillageois < nbVillageois) {
            return villageois[numVillageois];
        } else {
            System.out.println("Le numéro n'est pas correct.");
            return null;
        }
    }

    public void afficherVillageois() {
        if (chef != null) {
            System.out.println("Chef : " + chef.getNomGaulois());
        } else {
            System.out.println("Pas de chef dans le village.");
        }

        if (nbVillageois > 0) {
            System.out.println("Villageois :");
            for (int i = 0; i < nbVillageois; i++) {
                System.out.println(villageois[i].getNomGaulois());
            }
        } else {
            System.out.println("Aucun villageois dans le village.");
        }
    }
}

// Classe VillageMain
//public class VillageMain {
    public static void main(String[] args) {
        Village village = new Village("Village des Irréductibles", 30);

        try {
            Gaulois gaulois = village.trouverHabitant(30);
            System.out.println("Gaulois : " + gaulois.getNomGaulois());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception : Gaulois non trouvé");
        }

        Gaulois chef_abraracourcix = new Gaulois("Abraracourcix", 6);
        village.setChef(chef_abraracourcix);

        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterHabitant(asterix);

        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterHabitant(obelix);

        // Appeler la méthode afficherVillageois pour vérifier
        village.afficherVillageois();
    }
//}
