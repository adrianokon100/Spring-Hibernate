package my.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.project.entity.Athlete;

@Repository
public class AthleteDAOImpl implements AthleteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Athlete> getAthletes() {

	// get the current hibernate session	
	Session session = sessionFactory.getCurrentSession();
	
	// create a query
	Query<Athlete> myQuery = session.createQuery("FROM Athlete ORDER BY lastName", Athlete.class);
	
	
	// execute query and get result list
	List<Athlete> resultList = myQuery.getResultList();
	
	return resultList;
	}
	
	@Override
	public void saveAthlete(Athlete theAthlete) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theAthlete);
	}

	@Override
	public Athlete getAthlete(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Athlete theAthlete = currentSession.get(Athlete.class, theId);
		
		return theAthlete;
	}

	@Override
	public void athleteDelete(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Athlete> theQuery = currentSession.createQuery("DELETE FROM Athlete WHERE id=:athleteId");
		theQuery.setParameter("athleteId", theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Athlete> searchAthletes(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Athlete> theQuery = null;
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			
			theQuery = currentSession.createQuery("FROM Athlete where lower(firstName) like :athleteName OR"
					+ " lower(lastName) like :athleteName", Athlete.class);
			theQuery.setParameter("athleteName", "%" + theSearchName.toLowerCase() + "%");			
		}
		
		else {
			//theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("FROM Athlete", Athlete.class);
		}
		
		List<Athlete> theAthletes = theQuery.getResultList();
		return theAthletes;
	}

	
	

}
