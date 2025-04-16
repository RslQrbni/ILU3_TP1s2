package cartes;

public class Borne extends Carte{
	private int km;
	
	public Borne(int km) {
		this.km = km;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return km + " km ";
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Borne) {
			Borne borne25 = (Borne) obj;
			return km==borne25.getKm() &&super.equals(obj);
		}
		return false;
	}

	

}
