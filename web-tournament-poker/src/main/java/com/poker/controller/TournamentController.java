package com.poker.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poker.entity.Place;
import com.poker.entity.Tournament;
import com.poker.service.PlaceService;
import com.poker.service.TournamentService;

@Controller
@RequestMapping("tournament")
public class TournamentController {

	@Autowired
	public TournamentService tournamentService;
	
	@Autowired
	public PlaceService placeService;

	@GetMapping("/tournamentList")
	public String getTournaments(Model theModel) {
		
		List<Tournament> listTournaments = tournamentService.getTournaments();
		theModel.addAttribute("tournaments", listTournaments);
		
		return "list-tournaments";
		
	}
	
	@GetMapping("/tournamentFormAdd")
	public String addTournamentForm(Model theModel) {
		
		Tournament theTournament = new Tournament();
		List<Place> listPlaces = placeService.getPlaces();
		
		theModel.addAttribute("tournament", theTournament);
		theModel.addAttribute("places", listPlaces);

		return "tournament-form-add";
	}
	
	
	@PostMapping("/saveTournament")
	public String saveTournament(@ModelAttribute("tournament") @Valid Tournament theTournament, 
			BindingResult result, @RequestParam("placeTournament") int idPlace, Model theModel) {

		
		if(result.hasErrors()) {
			
			// First I need to take again list of places - select list need this
			List<Place> listPlaces = placeService.getPlaces();
			theModel.addAttribute("places", listPlaces);
			return "tournament-form-add";
		}
		
		else {
			
			
			Place thePlace = placeService.getPlace(idPlace);
			theTournament.setPlace(thePlace);
			
			tournamentService.saveTournament(theTournament);
			return "redirect:/tournament/tournamentList";
			
		}
	}
	
	@GetMapping("/deleteTournament")
	public String deleteTournament(@RequestParam("tournamentId") int theTournamentId) {
		
		tournamentService.deleteTournament(theTournamentId);
		
		return "redirect:/tournament/tournamentList";
		
	}
	
	@GetMapping("/tournamentFormUpdate")
	public String updateTournament(@RequestParam("tournamentId") int theTournamentId, Model theModel) {

		List<Place> listPlaces = placeService.getPlaces();
		Tournament theTournament = tournamentService.getTournament(theTournamentId);
		theModel.addAttribute("tournament", theTournament);
		theModel.addAttribute("places", listPlaces);
		
		return "tournament-form-update";
		
	}
	
	@PostMapping("/updateTournament")
	public String updateTournament(@Valid @ModelAttribute("tournament") Tournament theTournament, 
			BindingResult result, @RequestParam("placeTournament") int idPlace, Model theModel) {
	
		if(result.hasErrors()) {
			List<Place> listPlaces = placeService.getPlaces();
			theModel.addAttribute("places", listPlaces);
			return "tournament-form-update";
		}
		
		else {
			
			tournamentService.updateTournament(theTournament, idPlace);	
			return "redirect:/tournament/tournamentList";			
			
		}	
	}
	
	@PostMapping("/searchTournament")
	public String searchTournament(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		List<Tournament> listOfTournaments = tournamentService.searchTournament(theSearchName);
		theModel.addAttribute("tournaments", listOfTournaments);
		
		return "list-tournaments";
	}
	
	@PostMapping("/addTournamentForPlayer")
	public String addTournamentForPlayer(@RequestParam("idPlayer") int theIdPlayer,
			 @RequestParam("tournamentId") int theIdTournament) {
		
			System.out.println("idPlayer is: " + theIdPlayer);
			System.out.println("\n\n idTournament is: " + theIdTournament);
			
			//tournamentService.addTournamentForPlayer(theIdPlayer);
		
		return "list-tournaments";
	}
}
