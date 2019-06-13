package com.poker.service;

import java.util.List;

import com.poker.entity.Tournament;

public interface TournamentService {

	public List<Tournament> getTournaments();

	public void saveTournament(Tournament theTournament);

	public void deleteTournament(int tournamentId);

	public Tournament getTournament(int tournamentId);

	public void updateTournament(Tournament theTournament, int idPlace);

	public List<Tournament> searchTournament(String theSearchName);

	public void addTournamentForPlayer(int theIdPlayer);

	
	
}
