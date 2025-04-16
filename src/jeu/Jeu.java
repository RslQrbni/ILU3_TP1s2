package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot ;
	private JeuDeCartes jeuDeCarte;
	
	public Jeu(JeuDeCartes jeuDecarte) {
		Carte[] tabCarte = jeuDecarte.donnerCartes();
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, tabCarte);
		
		List<Carte> listTrasforme = GestionCartes.melanger(listeCartes);
		this.sabot = new Sabot(listTrasforme.toArray(new Carte[0]));
		
	}

	
}
