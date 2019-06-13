package com.poker.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poker.entity.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Player> getPlayers(){
		
		// get the current hibernate session	
		Session currentSession = sessionFactory.getCurrentSession();
			
		Query<Player> theQuery = currentSession.createQuery("FROM Player", Player.class);
		
		List<Player> resultList = theQuery.getResultList();
			
		return resultList;
	}
		

	public void savePlayer(Player thePlayer) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(thePlayer);	
	}
	

	public void deletePlayer(int playerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<?> theQuery = currentSession.createQuery("Delete FROM Player where id=:playerId");
		theQuery.setParameter("playerId", playerId);		
				
		theQuery.executeUpdate();	
	}

	
	public Player getPlayer(int thePlayerId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Player tempPlayer = currentSession.get(Player.class, thePlayerId);
		
		return tempPlayer;	
	}
		

	public void updatePlayer(Player thePlayer) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query<?> theQuery =
				currentSession.createQuery("UPDATE Player SET firstName=:theFirstName"
						+ ", lastName=:theLastName, email=:theEmail,"
						+ " pesel=:thePesel, age=:theAge, city=:theCity where id=:thePlayerId");
		
		theQuery.setParameter("thePlayerId", thePlayer.getId());
		theQuery.setParameter("theFirstName", thePlayer.getFirstName());
		theQuery.setParameter("theLastName", thePlayer.getLastName());
		theQuery.setParameter("theEmail", thePlayer.getEmail());
		theQuery.setParameter("thePesel", thePlayer.getPesel());
		theQuery.setParameter("theAge", thePlayer.getAge());
		theQuery.setParameter("theCity", thePlayer.getCity());
		
		theQuery.executeUpdate();		
	}


	public List<Player> searchPlayer(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Player> theQuery;
		
		if(theSearchName != null  && theSearchName.trim().length() > 0) {
			
			theQuery = currentSession.createQuery("FROM Player"
					+ " WHERE lower(firstName) LIKE :tempSearchName"
					+ " OR lower(lastName) LIKE :tempSearchName", Player.class);
			
			theQuery.setParameter("tempSearchName","%" + theSearchName.toLowerCase() + "%");
						
		}
		
		else {
			
			theQuery = currentSession.createQuery("FROM Player", Player.class);	
		}
	
		List<Player> listOfPlayers = theQuery.getResultList(); 
		return listOfPlayers;

	}	
}
