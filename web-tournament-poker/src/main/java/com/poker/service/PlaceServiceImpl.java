package com.poker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.dao.PlaceDAO;
import com.poker.entity.Place;
import com.poker.entity.Tournament;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceDAO placeDao;
	
	
	@Transactional
	public List<Place> getPlaces() {
		return placeDao.getPlaces();
		
	}

	
	@Transactional
	public void savePlace(Place thePlace) {
		placeDao.savePlace(thePlace);
		
	}

	
	@Transactional
	public void deletePlace(int placeId) {
		placeDao.deletePlace(placeId);
			
	}

	
	@Transactional
	public Place getPlace(int placeId) {
		return placeDao.getPlace(placeId);
	
	}

	
	@Transactional
	public void updatePlace(Place thePlace) {
		placeDao.updatePlace(thePlace);
	
	}

	
	@Transactional
	public List<Place> searchPlace(String theSearchName) {
		return placeDao.searchPlace(theSearchName);
		
	}

	@Transactional
	public List<Tournament> getTournamentsForPlace(int thePlaceId) {

		return placeDao.getTournametsForPlace(thePlaceId);
	}

}
