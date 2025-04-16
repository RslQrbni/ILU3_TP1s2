package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import cartes.Carte;

public class GestionCartes {
	
	//premier methode avec boocle direct sur la liste
	public static Carte extraire(List<Carte> liste) throws IllegalStateException {
		Random random = new Random();
		if(liste.isEmpty()) {
			throw new IllegalStateException("la liste est vide il ne faut pas");
		}
		
		int index = random.nextInt(liste.size());
		return liste.remove(index);
		
	}
	
	//deuxieme methode avec iterator
	public static Carte extraireIterator(List<Carte> liste) throws IllegalStateException{
		Random random = new Random();
		if(liste.isEmpty()) {
			throw new IllegalStateException("la liste est vide");
		}
		int indexTodelt = random.nextInt(liste.size());
		int curentIndex = 0 ;
		ListIterator<Carte> iterList =  liste.listIterator();
		Carte carte = null ;
		while(iterList.hasNext()) {
			carte = iterList.next();
			if(curentIndex == indexTodelt) {
			 iterList.remove();
			}
			curentIndex ++;
		}
		return carte;	
	}
	
	// b melanger
	public static List<Carte> melanger(List<Carte> liste) {
		if(liste == null ||liste.isEmpty()) {
			throw new IllegalStateException("la liste donne est vide");
		}
		List<Carte> melangeList = new ArrayList<>();
		while(!liste.isEmpty()) {
			Carte carte = extraire(liste);
			melangeList.add(carte);
		}
		return melangeList;
	}
	
	//verifer melanger
	public static boolean verifierMelange(List<Carte> list1,List<Carte> list2) {
		if(list1.size() != list2.size()) {
			return false;
		}
		
		for(Carte carte: list1) {
			if(Collections.frequency(list1, carte) != Collections.frequency(list2, carte))
				return false;
		}
		return true;
	}//verifier melanger
	
	public static List<Carte> rassembler(List<Carte> liste){
		List<Carte> listeRassemble = new ArrayList<>();
		int index = 0;
		for(Carte carte : liste) {
			index = listeRassemble.lastIndexOf(carte);
			if(index == -1) {
				index = 0;
			}
			listeRassemble.add(index, carte);
		}
		return listeRassemble;
	}//rassembler
	
	public static boolean verifierRassemblement(List<Carte> liste) {
		if(liste.isEmpty()) {
			return true;
		}
		
		ListIterator<Carte> iter1 = liste.listIterator();
		Carte oldCard = iter1.next();
		while(iter1.hasNext()) {
			Carte newcard = iter1.next();
			if(!oldCard.equals(newcard)) {
				ListIterator<Carte> iter2 = iter1;
				while(iter2.hasNext()) {
					newcard = iter2.next();
					if(newcard.equals(oldCard)) {
						return false;
					}
				}
				oldCard = newcard;
			}
			
		}
		return true;
	}
	
}//la classe
