package my.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.project.dao.AthleteDAO;
import my.project.dao.AthleteDAOImpl;
import my.project.entity.Athlete;
import my.project.service.AthleteService;

@Controller
@RequestMapping("/athlete")
public class AthleteController {
	
	@Autowired
	private AthleteService athleteService;
	
	@RequestMapping("/list")
	private String listAthletes(Model theModel) {
		
		System.out.println("I am in listAthletes");
		// get athletes from the dao
		List<Athlete> resultList = athleteService.getAthletes();
		
		// add athletes to the model
		theModel.addAttribute("athletes", resultList);
		
		return "list-athletes";
	}
	

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
	
		System.out.println("I am in showFormForAdd");
		Athlete theAthlete = new Athlete();
		theModel.addAttribute("athlete", theAthlete);
		
		return "athlete-save";
	}	
	
	
	@RequestMapping("/saveAthlete")
	public String saveAthlete(@ModelAttribute ("athlete") Athlete theAthlete) {
		
		System.out.println("I am in saveAthlete");
		athleteService.saveAthlete(theAthlete);
		
		return "redirect:/athlete/list";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("athleteId") int theId, Model theModel) {
	
		System.out.println("I am in showFormForUpdate");
		Athlete theAthlete = athleteService.getAthlete(theId);
		theModel.addAttribute("athlete", theAthlete);
		
		return "athlete-save";
	}

	@RequestMapping("/deleteAthlete")
	public String deleteAthlete(@RequestParam("athleteId") int theId) {
		
		System.out.println("I am in deleteAthlete");
		athleteService.deleteAthlete(theId);
		
		return "redirect:/athlete/list";
	}
	
	@PostMapping("/searchAthlete")
	public String searchAthlete(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		List<Athlete> theAthletes = athleteService.searchAthletes(theSearchName);
		theModel.addAttribute("athletes", theAthletes);
		
		return "list-athletes";
	}

}
