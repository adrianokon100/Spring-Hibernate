package my.project.dao;

import java.util.List;

import my.project.entity.Athlete;

public interface AthleteDAO {
	
		public List<Athlete> getAthletes();
		public void saveAthlete(Athlete theAthlete);
		public Athlete getAthlete(int theId);
		public void athleteDelete(int theId);
		public List<Athlete> searchAthletes(String theSearchName);


}
