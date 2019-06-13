package my.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.project.dao.AthleteDAO;
import my.project.entity.Athlete;

@Service
public class AthleteServiceImpl implements AthleteService {

	@Autowired
	private AthleteDAO athleteDAO;
	
	@Transactional
	public List<Athlete> getAthletes() {
		List<Athlete> athletes = athleteDAO.getAthletes();	
		return athletes;
	}

	@Override
	@Transactional
	public void saveAthlete(Athlete theAthlete) {
		athleteDAO.saveAthlete(theAthlete);
	}

	@Override
	@Transactional
	public Athlete getAthlete(int theId) {	
		Athlete theAthlete = athleteDAO.getAthlete(theId);
		return theAthlete;
	}

	@Override
	@Transactional
	public void deleteAthlete(int theId) {
		athleteDAO.athleteDelete(theId);
	}

	@Override
	@Transactional
	public List<Athlete> searchAthletes(String theSearchName) {
		return athleteDAO.searchAthletes(theSearchName);
	}
	
	

}
