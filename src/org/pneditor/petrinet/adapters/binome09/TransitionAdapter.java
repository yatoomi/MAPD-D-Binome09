package org.pneditor.petrinet.adapters.binome09;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.binome09.Transition;

public class TransitionAdapter extends AbstractTransition {
	public Transition transition;
	
	public TransitionAdapter () {
		super("");
		transition = new Transition();
	}
	
	public TransitionAdapter (Transition t) {
		super("");
		transition = t;
	}
}