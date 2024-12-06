package org.pneditor.petrinet.adapters.binome09;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.binome09.EdgeIn;
import org.pneditor.petrinet.models.binome09.PetriExceptions;
import org.pneditor.petrinet.models.binome09.Place;

public class EdgeInAdapter extends AbstractArc {
	
	public EdgeIn edgeIn;
	private int weight;
	private AbstractPlace place;
	private AbstractTransition transition;
	
	public EdgeInAdapter (AbstractPlace p, AbstractTransition t) {
		super();
		place = p;
		transition = t;
		PlaceAdapter pAdapt = (PlaceAdapter) p;
		TransitionAdapter tAdapt = (TransitionAdapter) t;
		weight = 1;
		edgeIn = new EdgeIn(weight, tAdapt.transition, pAdapt.place);
	}

	@Override
	public AbstractNode getSource() {
		return place;
	}

	@Override
	public AbstractNode getDestination() {
		return transition;
	}

	@Override
	public boolean isReset() {
		return false;
	}

	@Override
	public boolean isRegular() {
		return true;
	}

	@Override
	public boolean isInhibitory() {
		return false;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return weight;
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		weight = multiplicity;
		edgeIn.setWeight(multiplicity);
	}

	
}
