package com.poker.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poker.entity.Place;
import com.poker.entity.Player;
import com.poker.entity.Tournament;

@Repository
public class TournamentDAOImpl implements TournamentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Tournament> getTournaments(){
		
		// get the current hibernate session	
		Session currentSession = sessionFactory.getCurrentSession();
			
		Query<Tournament> theQuery = currentSession.createQuery("FROM Tournament", Tournament.class);
		
		List<Tournament> resultList = theQuery.getResultList();
		
		return resultList;
	}
	

	public void saveTournament(Tournament theTournament) {

		Session currentSession = sessionFactory.getCurrentSession();
		
	      SimpleDateFormat ft = 
	      new SimpleDateFormat("yyyy-mm-dd");

	      ft.format(theTournament.getStartDate());
	      
	      //theTournament.setStartDate(ft.format(theTournament.getStartDate()));
	      System.out.println("The date is: " + theTournament.getStartDate());
	      
		currentSession.save(theTournament);
	}
	
 
	public void deleteTournament(int tournamentId) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<?> theQuery = currentSession.createQuery("Delete From Tournament where id=:tournamentId");
		theQuery.setParameter("tournamentId", tournamentId);
		
		theQuery.executeUpdate();
	}
	

	
	public Tournament getTournament(int tournamentId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Tournament theTournament = currentSession.get(Tournament.class, tournamentId);
		
		return theTournament;
	}
	
	
	
	public void updateTournament(Tournament theTournament) {

		Session currentSession = sessionFactory.getCurrentSession();


		Query<?> theQuery = currentSession.createQuery("UPDATE Tournament"
				+ " SET name=:theName, maxPlayers=:theMaxPlayers, minPlayers=:theMinPlayers"
				+ ", startDate=:theStartDate, startTime=:theStartTime, place=:thePlace"
				+ " WHERE id=:theId");
		
		
		theQuery.setParameter("theName", theTournament.getName());
		theQuery.setParameter("theMaxPlayers", theTournament.getMaxPlayers());
		theQuery.setParameter("theMinPlayers", theTournament.getMinPlayers());
		theQuery.setParameter("theStartDate", theTournament.getStartDate());
		theQuery.setParameter("theStartTime", theTournament.getStartTime());
		theQuery.setParameter("theId", theTournament.getId());
		theQuery.setParameter("thePlace", theTournament.getPlace());
		
		theQuery.executeUpdate();

	
	}
	
	
	
	

	
	
	public List<Tournament> searchTournament(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Tournament> theQuery;
		
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			
			theQuery = currentSession.createQuery("FROM Tournament"
					+ " WHERE lower(name) LIKE :tempSearchName", Tournament.class);
			theQuery.setParameter("tempSearchName", "%" + theSearchName.toLowerCase() + "%");
			
		}
		
		else {
			
			theQuery = currentSession.createQuery("FROM Tournament", Tournament.class);
		}	
		
			List<Tournament> listOfTournaments = theQuery.getResultList();
			return listOfTournaments;
		}


	public void addTournamentForPlayer(int theIdPlayer) {
		Session currentSession = sessionFactory.getCurrentSession();

		Player thePlayer = currentSession.get(Player.class,theIdPlayer);
		List<Tournament> tournaments = thePlayer.getTournaments();
		//currentSession.tournaments.add(e);
		//thePlayer.setTournaments(tournaments);
		
	}
		

}
