package cartes;

public class Botte extends Probleme{
	private Type type;

	public Botte(Type type) {
		super (type);
		this.type = type; // why her we have this.type we had allready super(type)
	}
	
	public String toString() {
		return type.getBotte();
	}
}
