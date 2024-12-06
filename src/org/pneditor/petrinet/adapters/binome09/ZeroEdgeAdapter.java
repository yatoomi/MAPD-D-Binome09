package org.pneditor.petrinet.adapters.binome09;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.binome09.EmptyingEdge;
import org.pneditor.petrinet.models.binome09.ZeroEdge;

public class ZeroEdgeAdapter extends AbstractArc{ //inhibitory

	
	public ZeroEdge zeroEdge;
	private int weight;
	private AbstractPlace place;
	private AbstractTransition transition;
	

	public ZeroEdgeAdapter(AbstractPlace p, AbstractTransition t) {
		super();
		place = p;
		transition = t;
		PlaceAdapter pAdapt = (PlaceAdapter) p;
		TransitionAdapter tAdapt = (TransitionAdapter) t;
		weight = 1;
		zeroEdge = new ZeroEdge(tAdapt.transition, pAdapt.place);
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
		return false;
	}

	@Override
	public boolean isInhibitory() {
		return true;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return 0 ;
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		if (multiplicity != 0) {
			System.out.println("On ne peut pas modifier le poids d'un Arc Zero");
		}
	}

}
