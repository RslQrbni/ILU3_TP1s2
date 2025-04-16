package jeu;

import cartes.Carte;
import cartes.Borne;

public class Joueur {
	private String nomJoueur;
	private ZoneDeJeu zonedeJeu;
	private MainJoueur mainJoueur ;
	
	public Joueur(String nom,ZoneDeJeu zonedeJeu) {
		this.nomJoueur = nom;
		this.zonedeJeu = zonedeJeu;
		
	}
	
	public void  setNomJoueur() {
		this.nomJoueur = nomJoueur;
	}
	
	public String getNomJoueur() {
		return nomJoueur;
	}
	public ZoneDeJeu getZonDeJeu() {
		return zonedeJeu;
	}
	
	@Override
	public String toString() {
		return nomJoueur;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur ) {
			Joueur joueur = (Joueur) obj;
			return nomJoueur.equals(joueur.getNomJoueur());
		}
		return false;
	}
	
	public void donner(Carte carte) {
		mainJoueur.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		if(carte !=null) {
			donner(carte);
		}
		return carte;
	}
	
	public int donnerKmParcourus() {
		int kmParcouru = 0;
		for(Borne borne : getZonDeJeu().getCollectionBorne()) {
			kmParcouru += borne.getKm();
			}
		return kmParcouru;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		return zonedeJeu.estDepotAutorise(carte);
		
	}
	

}
