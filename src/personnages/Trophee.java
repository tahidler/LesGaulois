package personnages;

public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement ;
	
	
	

	public Gaulois getGaulois() {
		return gaulois;
	}

	public Trophee(Gaulois gaulois, Equipement equipement) {
		this.gaulois = gaulois;
		this.equipement = equipement;
	}

	public Equipement getEquipement() {
		return equipement;
	}

public String donnerNom() {
	return getGaulois().getNom();
	
}

}
