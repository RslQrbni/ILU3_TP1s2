package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

public class ZoneDeJeu {
	private LinkedList<Limite> pilleLimite ;
	private LinkedList<Bataille> pilleFinLimite;
	private LinkedList<Borne> collectionBorne;
	private String nom;
	//for Q 3
	private Borne borne;
	private Limite limite;
	private Bataille bataille;
	private Set<Botte> bottes = new HashSet<>();
	
	public ZoneDeJeu() {
		this.pilleLimite = new LinkedList<>();
		this.pilleFinLimite = new LinkedList<>();
		this.collectionBorne = new LinkedList<>();
		
		
	}
	
	public List<Limite> getPilleLimite() {
		return pilleLimite;
	}
	public List<Bataille> getPilleFinLimit(){
		return pilleFinLimite;
	}
	
	public LinkedList<Borne> getCollectionBorne(){
		return collectionBorne;
	}
	//2em partie
	public boolean estPrioritare() {
		return bottes.contains(Cartes.PRIORITAIRE);
	}
	
	
	//1
	// pour le rp 3 le code est copie en bas est verifier
//		public int donnerLimitationVitesse() {
//			if(pilleLimite.isEmpty()|| pilleLimite.get(0) instanceof FinLimite||estPrioritaire()) {
//				return 200;
//			}
//			return 50;
//			
//		}
		
	//2
		public int donnerKmParcourus() {
			int kmParcourus = 0;
			for(Borne borne : collectionBorne) {
				kmParcourus+= borne.getKm();
			}
			return kmParcourus;
		}
		
		//3 
		public void deposer(Carte carte) {
			if(carte instanceof Borne) {
				collectionBorne.add((Borne)carte);
			}
			else if(carte instanceof Limite|| carte instanceof DebutLimte) {
				pilleLimite.add(0,(Limite)carte);
		}
			if(carte instanceof Bataille) {
				pilleFinLimite.add(0,(Bataille)carte);
			}
			if(carte instanceof Botte botte) {
				bottes.add(botte);
			}
		}
		
//Partie 3

		public boolean peutAvancer() {
			if (pilleFinLimite.isEmpty()) {
	            return false;
	        }
	       
	        	Bataille cartBat = pilleFinLimite.get(0);
	        	return (cartBat.equals(Cartes.FEU_VERT));              
	    }
		
		private boolean estDepotFeuVerAutorise() {
			if(estPrioritaire()) return false;
			if(pilleFinLimite.isEmpty()) return true;
					
			return ( pilleFinLimite.get(0).equals(Cartes.FEU_ROUGE) || 
			           (!pilleFinLimite.get(0).equals(Cartes.FEU_VERT) && 
			            !pilleFinLimite.get(0).equals(Cartes.FEU_ROUGE)));
			

		
		}
		
		private boolean estDepotBorneAutorise(Borne borne) {
			return borne != null && 
			           peutAvancer() && 
			           borne.getKm() <= donnerLimitationVitesse() &&
			           borne.getKm() <= 1000;
		}
		
		private boolean estDepotLimiteAutorise(Limite limite) {
			if(estPrioritaire()) {
				return false;
			}
			 if(limite == null) {
				   return false;
			   }
			    
			 if(limite instanceof DebutLimte) {
			        return pilleLimite.isEmpty() || pilleLimite.get(0) instanceof FinLimite;
			    }
			     if(limite instanceof FinLimite) {
			        return !pilleLimite.isEmpty() && pilleLimite.get(0) instanceof DebutLimte;
			    }
			    return false;
		}
		//
		private boolean estDepotBatailleAutorise(Bataille bataille) {
			if(bataille instanceof Attaque) {
				return peutAvancer();
			}
			else  {
				if(bataille.equals(Cartes.FEU_VERT)) {
					return estDepotFeuVerAutorise();
				}else {
					if(!pilleFinLimite.isEmpty()) {
						Bataille top = pilleFinLimite.get(0);
						return (top instanceof Attaque && top.getType()==(bataille.getType()));
					}
					return false;
				}
			}
				
				
		}
		
	
		 public boolean estDepotAutorise(Carte carte) {

		        if (carte instanceof Borne borne) {
		            return estDepotBorneAutorise(borne);
		        }
		        if (carte instanceof Bataille bataille) {
		            return estDepotBatailleAutorise(bataille);
		        }
		        if (carte instanceof Limite limite) {
		            return estDepotLimiteAutorise(limite);
		        }
		        return false;
		    }
		 
		 //TP3
		 //1
		 public Set<Botte> bottes() {
			 return bottes;
			 
		 }
		 public boolean possedeBotte(Botte botte) {
			 return bottes.contains(botte);
		 }
		 public boolean retirerBotte(Botte botte) {
			 return bottes.remove(botte);
		 }
		 public int nombreBotte() {
			 return bottes.size();
		 }
		 
		 public boolean estPrioritaire() {			 
			 return (bottes.contains(Cartes.PRIORITAIRE));		 
		 }
		 
		 

}
