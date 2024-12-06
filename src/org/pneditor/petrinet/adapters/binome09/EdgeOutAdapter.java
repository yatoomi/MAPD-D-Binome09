package org.pneditor.petrinet.adapters.binome09;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.binome09.EdgeOut;

public class EdgeOutAdapter extends AbstractArc {
	
	public EdgeOut edgeOut;
	private int weight;
	private AbstractTransition transition;
	private AbstractPlace place;
	
	
	public EdgeOutAdapter(AbstractPlace p, AbstractTransition t) {
		super();
		place = p;
		transition = t;
		PlaceAdapter pAdapt = (PlaceAdapter) p;
		TransitionAdapter tAdapt = (TransitionAdapter) t;
		weight = 1;
		edgeOut = new EdgeOut(weight, tAdapt.transition, pAdapt.place);
	}	
	
	
	@Override
	public AbstractNode getSource() {
		return transition;
	}
	@Override
	public AbstractNode getDestination() {
		return place;
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
		edgeOut.setWeight(multiplicity);
	}

}
