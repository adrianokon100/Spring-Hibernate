package com.poker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.dao.TournamentDAO;
import com.poker.entity.Place;
import com.poker.entity.Tournament;

@Service
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	private TournamentDAO tournamentDao;
	
	@Autowired
	private PlaceService placeService;
	
	@Transactional
	public List<Tournament> getTournaments() {
		return tournamentDao.getTournaments();
		
	}

	
	@Transactional
	public void saveTournament(Tournament theTournament) {
		tournamentDao.saveTournament(theTournament);
		
	}

	
	@Transactional
	public void deleteTournament(int tournamentId) {
		tournamentDao.deleteTournament(tournamentId);
		
	}

	
	@Transactional
	public Tournament getTournament(int tournamentId) {
		return tournamentDao.getTournament(tournamentId);
		
	}

	
	@Transactional
	public void updateTournament(Tournament theTournament, int idPlace) {
		
		Place thePlace = placeService.getPlace(idPlace);			
		theTournament.setPlace(thePlace);
		
		tournamentDao.updateTournament(theTournament);
		
	}

	
	@Transactional	
	public List<Tournament> searchTournament(String theSearchName) {
		return tournamentDao.searchTournament(theSearchName);
		
	}


	public void addTournamentForPlayer(int theIdPlayer) {

		tournamentDao.addTournamentForPlayer(theIdPlayer);
	}

}
