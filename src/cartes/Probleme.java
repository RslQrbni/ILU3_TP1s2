package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	public Probleme(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
//	public boolean equals(Object obj) {
//		return obj  ((Probleme) obj).getType() && super.equals(obj);
//	}

}
