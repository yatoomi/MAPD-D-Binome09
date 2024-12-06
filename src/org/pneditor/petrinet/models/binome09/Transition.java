package org.pneditor.petrinet.models.binome09;
import java.util.LinkedList;

public class Transition {
	
	private LinkedList<EdgeIn> edgesIn;
	private LinkedList<EdgeOut> edgesOut;
	
	 /**
     * Constructeur de la classe Transition.
     * Initialise les listes des arcs entrants et sortants.
     */
	public Transition() {
		edgesIn = new  LinkedList<EdgeIn>();  // Initialise la liste des arcs entrants
		edgesOut = new  LinkedList<EdgeOut>(); // Initialise la liste des arcs sortants
	}
	
	/**
     * Vérifie si la transition peut être tirée.
     * La transition est tirable si tous les arcs entrants sont tirables.
     *
     * @return true si la transition est tirable, false sinon.
     */
	public boolean isFireable() {
		boolean test = true;
		// Vérifie si tous les arcs entrants sont tirables
		for (EdgeIn ei : edgesIn) {
			if (!ei.isFireable()) { // Si un arc entrant n'est pas tirable, la transition ne l'est pas
				test = false;
				break;  // On peut sortir tôt si un arc est déjà non tirable
			}
		}
		return test;
	}

	/**
     * Retourne la liste des arcs entrants de la transition.
     *
     * @return La liste des arcs entrants (EdgeIn).
     */
	public LinkedList<EdgeIn> getEdgesIn() {
		return edgesIn;
	}

	/**
     * Définit la liste des arcs entrants de la transition.
     *
     * @param edgesIn La nouvelle liste des arcs entrants.
     */
	public void setEdgesIn(LinkedList<EdgeIn> edgesIn) {
		this.edgesIn = edgesIn;
	}
	
	/**
     * Retourne la liste des arcs sortants de la transition.
     *
     * @return La liste des arcs sortants (EdgeOut).
     */
	public LinkedList<EdgeOut> getEdgesOut() {
		return edgesOut;
	}

	 /**
     * Définit la liste des arcs sortants de la transition.
     *
     * @param edgesOut La nouvelle liste des arcs sortants.
     */
	public void setEdgesOut(LinkedList<EdgeOut> edgesOut) {
		this.edgesOut = edgesOut;
	}

	/**
     * Effectue l'opération de tir de la transition.
     * Tous les arcs entrants et sortants sont activés, modifiant ainsi les jetons dans les places.
     */
	public void fire() {
		for (EdgeIn ei : edgesIn) { // Active tous les arcs entrants
			ei.fire();
		}
		for (EdgeOut eo : edgesOut) {// Active tous les arcs sortants
			eo.fire();
		}
	}
	

}
