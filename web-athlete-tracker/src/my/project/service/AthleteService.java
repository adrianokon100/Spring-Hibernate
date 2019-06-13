package my.project.service;

import java.util.List;

import my.project.entity.Athlete;

public interface AthleteService {

	public List<Athlete> getAthletes();

	public void saveAthlete(Athlete theAthlete);

	public Athlete getAthlete(int theId);

	public void deleteAthlete(int theId);

	public List<Athlete> searchAthletes(String theSearchName);
	
	
}
