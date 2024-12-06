package org.pneditor.petrinet.adapters.binome09;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.binome09.PetriNet;
import org.pneditor.petrinet.models.binome09.Place;
import org.pneditor.petrinet.models.binome09.Transition;



public class PetriNetAdapter extends PetriNetInterface{
	private PetriNet petriNet;
	
	public PetriNetAdapter() {
		petriNet = new PetriNet();
	}

	@Override
	public AbstractPlace addPlace() {
		Place place = petriNet.addPlace();
		return (AbstractPlace) new PlaceAdapter(place);
	}

	@Override
	public AbstractTransition addTransition() {
		Transition transition = petriNet.addTransition();
		return (AbstractTransition) new TransitionAdapter(transition);
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		if(source.isPlace()) {
			PlaceAdapter pAdapat = (PlaceAdapter) source;
			TransitionAdapter tAdapt = (TransitionAdapter) destination;
			EdgeInAdapter edge = new EdgeInAdapter(pAdapat, tAdapt);
			petriNet.addEdge(edge.edgeIn, "in");
			return (AbstractArc) edge;
		}
		else {
			PlaceAdapter pAdapat = (PlaceAdapter) destination;
			TransitionAdapter tAdapt = (TransitionAdapter) source;
			EdgeOutAdapter edge = new EdgeOutAdapter(pAdapat, tAdapt);
			petriNet.addEdge(edge.edgeOut, "out");
			return (AbstractArc) edge;
		}
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition) {
		PlaceAdapter pAdapat = (PlaceAdapter) place;
		TransitionAdapter tAdapt = (TransitionAdapter) transition;
		ZeroEdgeAdapter edge = new ZeroEdgeAdapter(pAdapat, tAdapt);
		petriNet.addEdge(edge.zeroEdge, "in");
		return (AbstractArc) edge;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition) {
	PlaceAdapter pAdapat = (PlaceAdapter) place;
	TransitionAdapter tAdapt = (TransitionAdapter) transition;
	EmptyingEdgeAdapter edge = new EmptyingEdgeAdapter(pAdapat, tAdapt);
	petriNet.addEdge(edge.emptyingEdge, "in");
	return (AbstractArc) edge;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		PlaceAdapter pAdapt = (PlaceAdapter) place;
	   petriNet.removePlace(pAdapt.place);
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		TransitionAdapter tAdapt = (TransitionAdapter) transition;
		petriNet.removeTransition(tAdapt.transition);
	}

	@Override
	public void removeArc(AbstractArc edge) {
		if(edge.isSourceAPlace() && edge.isRegular()) {
			EdgeInAdapter eAdapt = (EdgeInAdapter) edge;
			petriNet.removeEdge(eAdapt.edgeIn);
			return;
		}
		if(edge.isSourceAPlace() && edge.isInhibitory()) {
			ZeroEdgeAdapter eAdapt = (ZeroEdgeAdapter) edge;
			petriNet.removeEdge(eAdapt.zeroEdge);
			return;
		}
		if(edge.isSourceAPlace() && edge.isReset()) {
			EmptyingEdgeAdapter eAdapt = (EmptyingEdgeAdapter) edge;
			petriNet.removeEdge(eAdapt.emptyingEdge);
			return;
		}
		else {
			EdgeOutAdapter eAdapt = (EdgeOutAdapter) edge;
			petriNet.removeEdge(eAdapt.edgeOut);
			return;
		}
		
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		TransitionAdapter tAdapt = (TransitionAdapter) transition;
		return tAdapt.transition.isFireable();
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		if (isEnabled(transition)) {
			TransitionAdapter tAdapt = (TransitionAdapter) transition;
			petriNet.step(tAdapt.transition);
		}
		
	}

}
