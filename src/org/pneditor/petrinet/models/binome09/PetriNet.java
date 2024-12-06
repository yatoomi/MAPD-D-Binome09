package org.pneditor.petrinet.models.binome09;
import java.util.LinkedList;
import java.util.Random;

public class PetriNet implements IPetriNet{
	
	private LinkedList<Place> places;
	private LinkedList<Transition> transitions;
	private LinkedList<EdgeIn> edgesIn;
	private LinkedList<EdgeOut> edgesOut;
	
	
	public PetriNet() {
		places = new  LinkedList<Place>();
		transitions = new LinkedList<Transition>() ;
		edgesIn = new LinkedList<EdgeIn>() ;
		edgesOut = new LinkedList<EdgeOut>();
		
	}
	
	/**
     * Ajoute une nouvelle place au réseau.
     * @return La place créée et ajoutée.
     */
	public Place addPlace() {
		Place p = new Place();
		this.places.add(p);
		return p;
	}
	
	/**
     * Ajoute une nouvelle transition au réseau.
     * @return La transition créée et ajoutée.
     */
	public Transition addTransition() {
		Transition t = new Transition();
		this.transitions.add(t);
		return t;
	}
	
	/**
     * Ajoute des jetons à une place existante.
     * @param p La place à laquelle ajouter les jetons.
     * @param n Le nombre de jetons à ajouter (doit être positif).
	 * @throws PetriExceptions 
     */
	public void addTokens(Place p, int n) throws PetriExceptions {
		if (n>=0) {
			p.setTokens(p.getTokens()+n);
		}
		else {
			throw new PetriExceptions("le nombre de jetons à ajouter doit être positif");
		}
	}
	
	/**
     * Ajoute un arc entre une transition et une place.
     * @param t La transition associée à l'arc.
     * @param p La place associée à l'arc.
     * @param weight Le poids de l'arc (doit être positif).
     * @param typeOfEdge Le type d'arc ("in" pour entrant, "out" pour sortant).
     * @return L'arc créé ou une exception si l'ajout échoue.
	 * @throws PetriExceptions 
     */
	public Edge addEdge(Transition t, Place p, int weight, String typeOfEdge)/* throws PetriExceptions*/ {
//		if (weight < 0) {
//			throw new PetriExceptions("le poid doit être positif");
//		}
		if (typeOfEdge == "in") {// Arc entrant
			boolean test = false;
			for (EdgeIn ei : edgesIn) {// Vérifie si un tel arc existe déjà
				if (ei.getP() == p && ei.getT() == t) {
					test = true;
				}
			}
			if (test == false) {// Si l'arc n'existe pas, on le crée
				EdgeIn e = new EdgeIn(weight,t,p);
				edgesIn.add(e);
				return e;
			}
//			else {
//				throw new PetriExceptions("Cet arc existe déjà!");
//			}
		}
	
		
		if (typeOfEdge == "out") {// Arc sortant
			boolean test = false;
			for (EdgeOut eo : edgesOut) {// Vérifie si un tel arc existe déjà
				if (eo.getP() == p && eo.getT() == t) {
					test = true;
				}
			}
			if (test == false) {// Si l'arc n'existe pas, on le crée
				EdgeOut e = new EdgeOut(weight,t,p);
				edgesOut.add(e);
				return e;
			}
			else {
				System.out.println("Cet arc existe déjà!");
				return null;
			}
		}
		else {// Si le type d'arc n'est pas valide
		//	throw new PetriExceptions("Ce typeOfEdge n'existe pas");
		return null;
		}
		
	}
	
	public Edge addEdge(Edge edge, String typeOfEdge)/* throws PetriExceptions*/ {
		Place p = edge.getP();
		Transition t = edge.getT();
		int weight = edge.getWeight();
		
		if (typeOfEdge == "in") {// Arc entrant
			boolean test = false;
			for (EdgeIn ei : edgesIn) {// Vérifie si un tel arc existe déjà
				if (ei.getP() == p && ei.getT() == t) {
					test = true;
				}
			}
			if (test == false) {// Si l'arc n'existe pas, on le crée
				edgesIn.add((EdgeIn) edge);
				return edge;
			}
//			else {
//				throw new PetriExceptions("Cet arc existe déjà!");
//			}
		}
	
		
		if (typeOfEdge == "out") {// Arc sortant
			boolean test = false;
			for (EdgeOut eo : edgesOut) {// Vérifie si un tel arc existe déjà
				if (eo.getP() == p && eo.getT() == t) {
					test = true;
				}
			}
			if (test == false) {// Si l'arc n'existe pas, on le crée
				edgesOut.add((EdgeOut)edge);
				return edge;
			}
			else {
				System.out.println("Cet arc existe déjà!");
				return null;
			}
		}
			else {// Si le type d'arc n'est pas valide
		//	throw new PetriExceptions("Ce typeOfEdge n'existe pas");
				System.out.println("rien");
				return null;
		}
	}
	
	/**
     * Modifie le poids d'un arc existant.
     * @param e L'arc à modifier.
     * @param weight Le nouveau poids (doit être positif).
	 * @throws PetriExceptions 
     */
	public void setWeight(Edge e, int weight) throws PetriExceptions {
		if (weight>=0) {
			e.setWeight(weight);
		}
		else {
			throw new PetriExceptions("le nouveau poids doit être positif");
		}
	}
	
	/**
     * Récupère un certain nombre de jetons d'une place.
     * @param p La place cible.
     * @param n Le nombre de jetons à retirer.
     *          Doit être inférieur ou égal au nombre de jetons présents.
	 * @throws PetriExceptions 
     */
	public void recoverTokens(Place p, int n) throws PetriExceptions {
		int value = p.getTokens();
		if (value >= n) {
			p.setTokens(value-n);
		}
		else {
			throw new PetriExceptions("Il y a moins de "+ n +" tokens dans cette place.");
		}
	}
	
	/**
     * Exécute une transition si elle est tirable.
     * Met à jour l'état du réseau en consommant et produisant des jetons.
     * @param t La transition à exécuter.
	 * @throws PetriExceptions 
     */
	public void step(Transition t)/* throws PetriExceptions*/ {
		if (t.isFireable()) {
			t.fire();
		}
		else {
			System.out.println("Cette transition n'est pas tirable");
		}
//		throw new PetriExceptions("Cette transition n'est pas tirable");
//		}
	}
	
	public void step() {
		Random random = new Random();
		Transition transition = transitions.get(random.nextInt(transitions.size()));
		if (transition.isFireable()) {
		step(transition);
		}
		else {
			step();
		}
	}

	public void removePlace(Place place) {
		places.remove(place);
		for (Edge e : edgesIn) { 
			if (e.getP()==place) {
				System.out.println("place trouvée");
				e.deletedPlace(place);
				edgesIn.remove(e);
				}
			}
			
		for (Edge e : edgesOut) {
			if (e.getP()==place) {
				e.deletedPlace(place);
				edgesOut.remove(e);
				System.out.println("place trouvée");

				}	
			}
	}
	
	public void removeTransition(Transition transition) {
		transitions.remove(transition);
		for (Edge e : transition.getEdgesIn()) {
			removeEdge(e);
		}
		for (Edge e : transition.getEdgesOut()) {
			removeEdge(e);
		}
	}
	
	public void removeEdge (Edge edge) {
		edgesIn.remove(edge);
		edgesOut.remove(edge);
		for (Transition t : transitions) {
			t.getEdgesIn().remove(edge);
		}
	}
	
	}

