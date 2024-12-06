package org.pneditor.petrinet.models.binome09;

public interface IPetriNet {
	
	// constructeur implicite présent
	public Place addPlace();
	public Transition addTransition();
	public void addTokens(Place p, int n) throws PetriExceptions;
	public Edge addEdge(Transition t, Place p, int weight, String typeOfEdge) throws PetriExceptions;
	public void setWeight(Edge e, int weight) throws PetriExceptions;
	public void recoverTokens(Place p, int n) throws PetriExceptions;
	public void step(Transition t) throws PetriExceptions;
	public void step() throws PetriExceptions;
	
}
