package jeu;


import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	private List<Carte> carteEnMain ;


	public MainJoueur() {
		carteEnMain = new ArrayList<>();
	}

	public void prendre(Carte carte) {
		assert(carteEnMain.contains(carte));
		carteEnMain.add(carte);
		
	}
	
	public void jouer(Carte carte) {
		assert(carteEnMain.contains(carte));
		carteEnMain.remove(carte);
		
	}
	
	public String toString() {
		StringBuilder cartToprint = new StringBuilder();
		for(Carte carte: carteEnMain) {
			cartToprint.append(carte.toString()).append("\n");
		}
		return cartToprint.toString();
	}

}
