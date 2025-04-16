package cartes;

public class Parade extends Bataille{
	private Type type;
	
	public Parade(Type type) {
		super(type);
		this.type = type;
	}
	
	public String toString() {
		Type type =getType();
		return type.getParade();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Parade) {
			Parade parade = (Parade) obj;
			return type.equals(parade.getType());
		}
		return false;
	}

}
