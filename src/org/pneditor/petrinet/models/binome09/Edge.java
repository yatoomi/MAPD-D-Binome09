package org.pneditor.petrinet.models.binome09;

public abstract class Edge {
	
	protected int weight;
	protected Place p;
	protected Transition t;
	
	
	/**
     * Constructeur de la classe Edge.
     * Initialise un arc avec un poids donné.
     * @param weight Le poids de l'arc (doit être positif).
	 * @throws PetriExceptions 
     */
	public Edge(int weight) {
		//if (weight>=0) {
			this.weight = weight;
	//	}
		//else {
			//throw new PetriExceptions("le poids doit être positif");
		//}
	}
	
	/**
     * Définit un nouveau poids pour l'arc.
     * @param weight Le nouveau poids de l'arc (doit être positif).
	 * @throws PetriExceptions 
     */
	public void setWeight(int weight) {
	//	if (weight>=0) {
			this.weight = weight;
		//}
		//else {
			//throw new PetriExceptions("le poids doit être positif");
	//	}
	}
	
	/**
     * Retourne le poids actuel de l'arc.
     * @return Le poids de l'arc.
     */
	public int getWeight() {
		return this.weight;
	}
	
	/**
     * Retourne la place associée à cet arc entrant.
     *
     * @return La place source.
     */
	public Place getP() {
		return p;
	}

	/**
     * Définit la place associée à cet arc entrant.
     *
     * @param p La place source.
     */
	public void setP(Place p) {
		this.p = p;
	}
	/**
	    * Retourne la transition associée à cet arc entrant.
	    *
	    * @return La transition cible.
	    */
		public Transition getT() {
			return t;
		}

	public abstract void deletedPlace(Place place);


}
