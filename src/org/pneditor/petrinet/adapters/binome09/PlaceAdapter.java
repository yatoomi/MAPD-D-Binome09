package org.pneditor.petrinet.adapters.binome09;

import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.models.binome09.Place;

public class PlaceAdapter extends AbstractPlace{
	public Place place;
	
	public PlaceAdapter() {
		super("");
		place = new Place();
	}
	
	public PlaceAdapter(Place p) {
		super("");
		place = p;
	}
	

	@Override
	public void addToken() {
		place.refresh(1);
	}

	@Override
	public void removeToken() {
		place.refresh(-getTokens());		
	}

	@Override
	public int getTokens() {
		return place.getTokens();
	}

	@Override
	public void setTokens(int tokens) {
		place.setTokens(tokens);
	}

}
