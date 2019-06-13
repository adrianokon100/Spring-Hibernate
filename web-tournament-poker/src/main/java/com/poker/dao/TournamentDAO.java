package com.poker.dao;

import java.util.List;

import com.poker.entity.Tournament;

public interface TournamentDAO {

	public List<Tournament> getTournaments();

	public void saveTournament(Tournament theTournament);

	public void deleteTournament(int tournamentId);

	public Tournament getTournament(int tournamentId);

	public void updateTournament(Tournament theTournament);

	public List<Tournament> searchTournament(String theSearchName);

	public void addTournamentForPlayer(int theIdPlayer);

}
