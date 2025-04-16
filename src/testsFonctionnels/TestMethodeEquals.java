package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Probleme;
import cartes.Type;

public class TestMethodeEquals {
	
	
	
	
	public static void main(String[] args) {
		Borne borne1 = new Borne(25);
		Borne boren2 = new Borne(25);
		System.out.println("2 cartes de 25 km sont le meme "+ borne1.equals(boren2));
		
		Attaque feuRouge1 = new Attaque(Type.FEU);
		Attaque feuRouge2 = new Attaque(Type.FEU);
		System.out.println("2 carte de feuRouge ont le meme type " + feuRouge1.equals(feuRouge2));
		
		Parade feuVert = new Parade(Type.FEU);
		System.out.println("2 Carte de feuVert et feuRouge sont egals ?"+feuRouge1.equals(feuVert));
	}
	

}
