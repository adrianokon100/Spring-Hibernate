package com.poker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.dao.PlayerDAO;
import com.poker.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDao;
	
	
	@Transactional
	public List<Player> getPlayers() {	
		return playerDao.getPlayers();
		
	}

	@Transactional
	public void savePlayer(Player thePlayer) {
		playerDao.savePlayer(thePlayer);
	
	}

	@Transactional
	public void deletePlayer(int playerId) {
		playerDao.deletePlayer(playerId);
		
	}

	@Transactional
	public Player getPlayer(int thePlayerId) {
		return playerDao.getPlayer(thePlayerId);
		
	}
	
	@Transactional
	public void updatePlayer(Player thePlayer) {
		playerDao.updatePlayer(thePlayer);
		
	}

	@Transactional
	public List<Player> searchPlayer(String theName) {
		return playerDao.searchPlayer(theName);
	
	}

}
