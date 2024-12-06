package org.pneditor.petrinet.models.binome09;

public class EmptyingEdge extends EdgeIn{
	
	/**
     * Constructeur de la classe EmptyingEdge.
     * Initialise un arc entrant qui prend tous les jetons d'une place donnée.
     * Le poids de cet arc correspond initialement au nombre actuel de jetons dans la place.
     *
     * @param t La transition associée à cet arc.
     * @param p La place associée à cet arc.
	 * @throws PetriExceptions 
     */
	public EmptyingEdge(Transition t, Place p) /*throws PetriExceptions*/ {
		super(p.getTokens(),t,p);// Appel au constructeur d'EdgeIn avec le nombre de jetons actuel
	}
	
	/**
     * Met à jour le poids de l'arc pour qu'il corresponde au nombre actuel de jetons dans la place.
     * Cette méthode est utilisée pour ajuster dynamiquement le poids en fonction de l'état de la place.
     */
	public void autoWeight() {
		weight = p.getTokens();// Définit le poids égal au nombre de jetons actuels
	} 
	
	/**
     * Vérifie si l'arc est activable.
     * Un EmptyingEdge est activable si la place associée contient au moins un jeton.
     *
     * @return true si la place contient des jetons, false sinon.
     */
	public boolean isActive() {
		return (p.getTokens() != 0);
	}
}
