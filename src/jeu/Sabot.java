package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	private Carte[] cartes ;
	private int nbCarte ;
	private int modCount = 0 ;
	
	public Sabot(Carte[] carteDejeu) {
		//verifier si le tab de carte est vide
		if (carteDejeu == null || carteDejeu.length == 0) {
	        throw new IllegalArgumentException("Le tableau de cartes est vide ou null !");
	    }
		this.cartes = carteDejeu;
		this.nbCarte = carteDejeu.length;
	}

	//a  si la piche est vide
	public boolean estVide() {
		return nbCarte == 0;
	}
	
	//b ajouter un carte et une exeption en cas depassement de capacite de tab
	public void ajouterCarte(Carte carte) {
		if(nbCarte >= cartes.length) {
			throw new IllegalStateException("la capacite est pleine");
		}
		cartes[nbCarte] = carte;
		nbCarte ++;	
		modCount ++;
	}
	

	

	@Override
	public Iterator<Carte> iterator() {
		
		return new SabotIterator();
	}
	
	// c rendre la classe iterable
	public class SabotIterator implements Iterator<Carte>{
		private int expectedCount = modCount;
		private int indexIterator =0;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			if(modCount != expectedCount) {
				throw new ConcurrentModificationException("la collection a été modifié");
			}
			return indexIterator < nbCarte;
		}

		@Override
		public Carte next() {
			if(modCount != expectedCount) {
				throw new ConcurrentModificationException("la collection a été modifié");
			}
			if(!hasNext()) {
				throw new IllegalStateException("il n'y a pas de next => no hasNext()");
			}else {
			//Carte nextCart = cartes[indexIterator];
			//indexIterator ++;
			nextEffectue = true;
			return cartes[indexIterator++];
		}
		
		}
		
		@Override
		public void remove() {
			if(! nextEffectue) {
				throw new IllegalStateException("next n'a pas ete appele");
			}
			if(modCount != expectedCount) {
				throw new ConcurrentModificationException("concurent exeption");
			}
			
//			if(nbCarte < 1 || !hasNext()) {
//				throw new IllegalStateException("no carte no hasnext!");
//			}
			for(int i = indexIterator -1; i< nbCarte -1; i++) {
				cartes[i] = cartes[i+1];
			}
				nextEffectue = false;
				indexIterator --;
				nbCarte --;
				expectedCount++; modCount++;
		}
		
	}//iterator class
	
	
	public Carte piocher() {
		Iterator<Carte> cartIter =  iterator();
		if(estVide()) {
			throw new IllegalStateException("la tab de carte est vide");
		}
		if(cartIter.hasNext()) {
			Carte carteTosend = cartIter.next();
			
			cartIter.remove();
			modCount ++;
			return carteTosend;
		}else {
			throw new IllegalStateException("piocher has no cart no next");
		}
	}
	
	
}
