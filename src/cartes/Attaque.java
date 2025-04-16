package cartes;

public class Attaque extends Bataille{
	private Type type;
	
	public Attaque(Type type) {
		super (type);
		this.type = type;
	}
	
	public String toString() {
		return type.getAttaque();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Attaque) {
			Attaque attaque = (Attaque) obj;
			return type.equals(attaque.type);
		}
		return false;
	}

}
