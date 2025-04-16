package cartes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JeuDeCartes extends Carte {
	private Configuration[] listDesCartes;
	//private Type type;
	
	
	public JeuDeCartes() {
		 
		this.listDesCartes = new Configuration[19];
		
		//Borne
		listDesCartes[0] = new Configuration(new Borne(25), 10); //25km
		listDesCartes[1] = new Configuration(new Borne(50), 10); // 50km
		listDesCartes[2] = new Configuration(new Borne(75), 10); //75km
		listDesCartes[3] = new Configuration(new Borne(100), 12); //100km
		listDesCartes[4] = new Configuration(new Borne(200), 4); //200km
		
		//Feu
		listDesCartes[5] = new Configuration(new Parade(Type.FEU), 14); //Feu vert
		listDesCartes[6] = new Configuration(new Attaque(Type.FEU), 5); //Feu Rouge
		listDesCartes[7] = new Configuration(new Botte(Type.FEU), 1); //vehicule prioritaire
		
		//Essence
		listDesCartes[8] = new Configuration(new Parade(Type.ESSENCE), 6); //Bidon c'essance
		listDesCartes[9] = new Configuration(new Attaque(Type.ESSENCE), 3); //Panne d'essance
		listDesCartes[10] = new Configuration(new Botte(Type.ESSENCE), 1); // Citerne
		
		//crevaison
		
		listDesCartes[11] = new Configuration(new Parade(Type.CREVAISON), 6); //Rou de secour
		listDesCartes[12] = new Configuration(new Attaque(Type.CREVAISON), 3); // crevaison
		listDesCartes[13] = new Configuration(new Botte(Type.CREVAISON), 1); //increvable
		
		//Accident
		listDesCartes[14] = new Configuration(new Parade(Type.ACCIDENT), 6); //Reparation
		listDesCartes[15] = new Configuration(new Attaque(Type.ACCIDENT), 3); //Accident
		listDesCartes[16] = new Configuration(new Botte(Type.ACCIDENT), 1); //As du volant
		
		//Limite
		listDesCartes[17] = new Configuration(new DebutLimte(), 4); //limite 50
		listDesCartes[18] = new Configuration(new FinLimite(), 6); //finlimite
	}
	
    public Carte[] donnerCartes() {
        Carte[] listeCarteReplique;
        int totalCartes = 0;
        
        for(int i = 0; i < listDesCartes.length; i++) {
            totalCartes += listDesCartes[i].nbExemplaire;
        }
        listeCarteReplique = new Carte[totalCartes];
        int nbCartes = 0;
        for(int i = 0; i < listDesCartes.length; i++) {
            for(int j = 0; j < listDesCartes[i].nbExemplaire; j++) {
                listeCarteReplique[nbCartes] = listDesCartes[i].carte;
                nbCartes += 1;
            }
        }
        return listeCarteReplique;
    } // fin donnerCarte
	
	//Afichage
	public String affichageJeuCartes() {
		String affichage = "";
		for(Configuration config : listDesCartes) {
			affichage += config.getNbExemplaire() + " " + config.getCarte().toString() + "\n";
		}
		return affichage;
	}
	
	
	
	
	private class Configuration{
		private Carte carte;
		private int nbExemplaire ;
		
		public Configuration(Carte carte,int nbExemplaire) {
			this.carte = carte;
			this.nbExemplaire = nbExemplaire;
			
		}
		
		public Carte getCarte() {
			return carte;
		}
		
		public int getNbExemplaire() {
			return nbExemplaire;
		}
		

	}
	
	//TP2 1 JeuDeCarte
	public boolean checkCount() {
		int actualCartes =0;
		int expectedCartes = 0;
		Carte[] cartesEnvoye = donnerCartes();
		ArrayList<Carte> cartesRecue = new ArrayList<>();
		
		Collections.addAll(cartesRecue, cartesEnvoye);
		for(Configuration config :listDesCartes) {
			Carte configCarte = config.getCarte();
			 expectedCartes = config.getNbExemplaire();
			 actualCartes = Collections.frequency(cartesRecue, configCarte);
			
			
		}
		return actualCartes == expectedCartes;
	}

	
	
}
