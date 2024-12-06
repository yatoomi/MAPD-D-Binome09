package org.pneditor.petrinet.models.binome09;

public class Place {
	
	private int tokens;
	
	/**
     * Retourne le nombre actuel de jetons dans la place.
     *
     * @return Le nombre de jetons.
     */
	public int getTokens() {
		return this.tokens;
	}
	
	/**
     * Définit le nombre de jetons dans la place.
     *
     * @param n Le nombre de jetons à attribuer à la place.
     */
	public void setTokens(int n) {
		this.tokens = n;
	}
	
	/**
     * Met à jour le nombre de jetons dans la place.
     * Cette méthode permet d'ajouter ou de retirer des jetons de la place en fonction de la valeur passée.
     *
     * @param t Le nombre de jetons à ajouter (si t > 0) ou à retirer (si t < 0).
     */
	public void refresh(int t) {
		tokens += t; // Ajoute ou retire t jetons à la place selon la valeur de t
	}
}
