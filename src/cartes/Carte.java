package cartes;

public abstract class Carte {
	private Carte carte;
	
	
	
	
	public Carte getCarte() {
		return carte;
	}
	
	public boolean equals(Object obj) {
		return obj != null && getClass() == obj.getClass();
	}
	
}
