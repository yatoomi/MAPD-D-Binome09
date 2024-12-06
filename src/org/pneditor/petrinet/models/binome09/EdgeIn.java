package org.pneditor.petrinet.models.binome09;

public class EdgeIn extends Edge{
	
	/**
     * Constructeur de la classe EdgeIn.
     * Initialise un arc entrant avec un poids, une transition cible et une place source.
     *
     * @param weight Le poids de l'arc (doit être positif).
     * @param t La transition associée à cet arc.
     * @param p La place associée à cet arc.
	 * @throws PetriExceptions 
     */
	public EdgeIn(int weight, Transition t, Place p) {
		super(weight);
		this.setP(p);
		this.setT(t);		
	}
	
	
	
	/**
     * Définit la transition associée à cet arc entrant.
     *
     * @param t La transition cible.
     */
	public void setT(Transition t) {
		this.t = t;
		t.getEdgesIn().add(this);
		}
	
	
	
	/**
     * Vérifie si l'arc est activable.
     * L'arc est activable si :
     * - Il possède assez de jetons dans la place source (>= poids de l'arc).
     * - Si l'arc est une instance de ZeroEdge ou EmptyingEdge, des vérifications spécifiques sont effectuées.
     *
     * @return true si l'arc est activable, false sinon.
     */
	public boolean isFireable() {
		boolean test = true;
		// Vérifie si l'arc est un ZeroEdge et si il est tirable
		if (this instanceof ZeroEdge) {
			test = ((ZeroEdge)this).isActive();
		}
		// Vérifie si l'arc est un EmptyingEdge et si il est tirable
		if (this instanceof EmptyingEdge) {
		test = ((EmptyingEdge)this).isActive();
		}
		 // Vérifie si le nombre de jetons est suffisant pour activer l'arc
		if (weight > p.getTokens()) {
			test = false;
		}
		return test;
	}

	/**
     * Effectue l'opération de tir de l'arc.
     * Consomme des jetons de la place source en fonction du poids de l'arc.
     * Si l'arc est un EmptyingEdge, le poids est ajusté automatiquement avant et après l'opération.
     */
	public void fire() {
		// Si l'arc est un EmptyingEdge, ajuste automatiquement le poids
		if (this instanceof EmptyingEdge) {
			((EmptyingEdge)this).autoWeight();
		}
		// Consomme des jetons dans la place source
		p.refresh(-weight);
		// Ajuste à nouveau le poids pour un EmptyingEdge
		if (this instanceof EmptyingEdge) {
			((EmptyingEdge)this).autoWeight();
		}
	}



	@Override
	public void deletedPlace(Place place) {
				System.out.println(t.getEdgesIn());
				t.getEdgesIn().remove(this);
				System.out.println(t.getEdgesIn());
		}
	}

