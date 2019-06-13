package com.poker.service;

import java.util.List;

import com.poker.entity.Player;

public interface PlayerService {

	
	public List<Player> getPlayers();
	
	public void savePlayer(Player thePlayer);

	public void deletePlayer(int playerId);
	
	public Player getPlayer(int thePlayerId);

	public void updatePlayer(Player thePlayer);

	public List<Player> searchPlayer(String theName);
	
	
	
}
