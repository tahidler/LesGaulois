package personnages;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;
    private String texte;

    public Romain(String nom, int force) {
        this.nom = nom;
        // Verification de l'invariant
        if (force < 0) {
            throw new IllegalArgumentException("La force doit être positive.");
        }
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + " : " + texte);
    }

    private String prendreParole() {
        return "Le romain " + nom;
    }

    public void recevoirCoup1(int forceCoup) {
        force -= forceCoup;
        if (force > 0) {
            parler("Aïe !");
        } else {
            parler("J'abandonne...");
        }
    }

    public static void main(String[] args) {
        // Exemple d'utilisation
        try {
            Romain romain = new Romain("Minus", 6);
            // Le constructeur générera une exception IllegalArgumentException
            // car la force doit être positive à la création de l'objet.
        } catch (IllegalArgumentException e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }
    
    public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("le soldat " + nom + " est deja bien protegé! ");
			break;
		}
		case 1: {
			if (equipements[0] == equipement) {
				System.out.println("le soldat " + nom + " posséde deja un " + equipement + "!");
				break;
			}

			else { 
				equipement(equipement);
				break;
			}
		}

		default: {
			equipement(equipement);
			break;

		}

		}

	}

    
    private void equipement(Equipement equipement) {
		// TODO Auto-generated method stub
		
	}

	public Equipement[] recevoirCoup(int forceCoup) {
    	Equipement[] equipementEjecte = null;
    	// Precondition
    	assert force > 0;
    	int oldForce = force;
    	forceCoup = CalculResistanceEquipement(forceCoup);
    	force -= forceCoup;
    	// if (force > 0) {
    	// Paler("Aïe");
    	// } else {
    	// equipementEjecte = ejecterEquipement();
    	// Paler("J'abandonne...");
    	// }
    	switch (force) {
    	case 0:
    	parler("Aïe");
    	default:
    		equipementEjecte = ejecterEquipement();
    		parler("J'abandonne...");
    		break;
    		}
    		// post condition la force a diminuée
    		assert force < oldForce;
    		return equipementEjecte;
    		}
    
    private int CalculResistanceEquipement(int forceCoup) {
    	texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
    	int resistanceEquipement = 0;
    	if (!(nbEquipement == 0)) {
    	texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
    	for (int i = 0; i < nbEquipement;) {
    	if ((equipements[i] != null &&
    	equipements[i].equals(Equipement.BOUCLIER)) == true) {
    	resistanceEquipement += 8;
    	} else {
    	System.out.println("Equipement casque");
    	resistanceEquipement += 5;
    	}
    	i++;
    	}
    	texte =+ resistanceEquipement + "!";
    	}
    	parler(texte);
    	forceCoup -= resistanceEquipement;
    	return forceCoup;
    	}
    	
    private Equipement[] ejecterEquipement() {
    	Equipement[] equipementEjecte = new Equipement[nbEquipement];
    	System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
    	//TODO
    	int nbEquipementEjecte = 0;
    	for (int i = 0; i < nbEquipement; i++) {
    		if (equipements[i] == null) {
    			continue;
    			} else {
    			equipementEjecte[nbEquipementEjecte] =
    			equipements[i];
    			nbEquipementEjecte++;
    			equipements[i] = null;
    			}
    			}
    			return equipementEjecte;
    			}
}
    
    
    
    
    
    
    


