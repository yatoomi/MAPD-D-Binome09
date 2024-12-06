package org.pneditor.petrinet.models.binome09;

public class EdgeOut extends Edge {
	
	 /**
     * Constructeur de la classe EdgeOut.
     * Initialise un arc sortant avec un poids, une transition source, et une place cible.
     *
     * @param weight Le poids de l'arc (doit être positif).
     * @param t La transition associée à cet arc.
     * @param p La place associée à cet arc.
	 * @throws PetriExceptions 
     */
	public EdgeOut(int weight, Transition t,Place p) /*throws PetriExceptions*/ {
		super(weight);
		this.setP(p);
		this.setT(t);
	}


	/**
     * Définit la transition associée à cet arc sortant.
     *
     * @param t La transition source.
     */
	public void setT(Transition t) {
		this.t = t;
		t.getEdgesOut().add(this);
	}
	
	/**
     * Effectue l'opération de tir de l'arc.
     * Produit des jetons dans la place cible en fonction du poids de l'arc.
     */
	public void fire() {
		p.refresh(weight);// Ajoute des jetons dans la place cible
		
	}


	@Override
	public void deletedPlace(Place place) {
		t.getEdgesOut().remove(this);
	
	}
}
