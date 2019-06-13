package com.poker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poker.entity.Place;
import com.poker.entity.Tournament;

@Repository
public class PlaceDAOImpl implements PlaceDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Place> getPlaces(){
		
		// get the current hibernate session	
		Session currentSession = sessionFactory.getCurrentSession();
			
		Query<Place> theQuery = currentSession.createQuery("FROM Place", Place.class);
		
		List<Place> resultList = theQuery.getResultList();
			
		return resultList;
	}
	
	
	public void savePlace(Place thePlace) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(thePlace);	
	}

/* This function for delete is not working - why?	java.sql.SQLIntegrityConstraintViolationException:
 *  Cannot delete or update a parent row: a foreign key constraint
 *   fails (`tournament_poker`.`tournament`, CONSTRAINT `tournament_ibfk_1`
 *    FOREIGN KEY (`id_place`) REFERENCES `place` (`id_place`) ON UPDATE CASCADE)

	public void deletePlace(int placeId) {

		Session currentSession = sessionFactory.getCurrentSession();		
		
		Query<?> theQuery = currentSession.createQuery("Delete FROM Place where id=:placeId"); 
		theQuery.setParameter("placeId", placeId);
		
		theQuery.executeUpdate();			
	}
*/	
	//This function for delete working fine
	public void deletePlace(int placeId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Place thePlace = currentSession.get(Place.class, placeId);
		
		currentSession.delete(thePlace);
	
	}
	
	
	public Place getPlace(int placeId) {

		Session currentSession = sessionFactory.getCurrentSession();
	
		Place thePlace = currentSession.get(Place.class, placeId);
		
		return thePlace;
	}
	

	public void updatePlace(Place thePlace) {
		
		Session currentSesson = sessionFactory.getCurrentSession();
		
		Query<?> theQuery = currentSesson.createQuery("UPDATE Place SET"
				+ " name=:theName, city=:theCity, description=:theDescription WHERE id=:theId");
		
		theQuery.setParameter("theId", thePlace.getId());
		theQuery.setParameter("theName", thePlace.getName());
		theQuery.setParameter("theCity", thePlace.getCity());
		theQuery.setParameter("theDescription", thePlace.getDescription());
		
		theQuery.executeUpdate();
	}

	
	public List<Place> searchPlace(String theSearchName) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Place> theQuery;
		
		if(theSearchName != null && theSearchName.trim().length() >0) {
			
			theQuery = currentSession.createQuery("FROM Place"
					+ " WHERE lower(name) LIKE :tempSearchName", Place.class);
			theQuery.setParameter("tempSearchName", "%" + theSearchName.toLowerCase() + "%" );
			
			
		}
		
		else {
			
			theQuery = currentSession.createQuery("FROM Place", Place.class);
		}	
			
		List<Place> listOfPlaces = theQuery.getResultList();	
		return listOfPlaces;
	}


	public List<Tournament> getTournametsForPlace(int thePlaceId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Tournament> theQuery = currentSession.createQuery("FROM Tournament "
				+ "WHERE place.id=:theId", Tournament.class);
		theQuery.setParameter("theId", thePlaceId);
		
		List<Tournament> listOfTournaments = theQuery.getResultList();
		
		System.out.println("the list of tournamts is: ");
		for(int i=0; i<listOfTournaments.size(); i++) {
			System.out.println("is: " + listOfTournaments.get(i));
		}
		
		return listOfTournaments;
	}
	
}
