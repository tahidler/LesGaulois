package personnages;

public class Romain {
    private String nom;
    private int force;

    public Romain(String nom, int force) {
        this.nom = nom;
        // Vérification de l'invariant
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

    public void recevoirCoup(int forceCoup) {
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
}
