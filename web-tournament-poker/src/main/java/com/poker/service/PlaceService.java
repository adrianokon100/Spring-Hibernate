package com.poker.service;

import java.util.List;

import com.poker.entity.Place;
import com.poker.entity.Tournament;

public interface PlaceService {

	public List<Place> getPlaces();

	public void savePlace(Place thePlace);

	public void deletePlace(int placeId);

	public Place getPlace(int placeId);

	public void updatePlace(Place thePlace);

	public List<Place> searchPlace(String theSearchName);

	public List<Tournament> getTournamentsForPlace(int thePlaceId);
	
}
