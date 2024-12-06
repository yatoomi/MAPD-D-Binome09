package org.pneditor.petrinet.adapters.binome09;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.binome09.EdgeIn;
import org.pneditor.petrinet.models.binome09.EmptyingEdge;

public class EmptyingEdgeAdapter extends AbstractArc{ //reset

	public EmptyingEdge emptyingEdge;
	private int weight;
	private AbstractPlace place;
	private AbstractTransition transition;
	
	
	public EmptyingEdgeAdapter (AbstractPlace p, AbstractTransition t) {
		super();
		place = p;
		transition = t;
		PlaceAdapter pAdapt = (PlaceAdapter) p;
		TransitionAdapter tAdapt = (TransitionAdapter) t;
		weight = 1;
		emptyingEdge = new EmptyingEdge(tAdapt.transition, pAdapt.place);
	}
	
	public AbstractNode getSource() {
		return place;
	}

	@Override
	public AbstractNode getDestination() {
		return transition;
	}

	@Override
	public boolean isReset() {
		return true;
	}

	@Override
	public boolean isRegular() {
		return false;
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
		emptyingEdge.setWeight(multiplicity);		
	}

}
