package com.poker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poker.entity.Place;
import com.poker.entity.Tournament;
import com.poker.service.PlaceService;

@Controller
@RequestMapping("place")
public class PlaceController {

	
	@Autowired
	public PlaceService placeService;
	

	
	@GetMapping("/placeList")
	public String getPlaces(Model theModel) {
		
		// get players from DAO
		List<Place> thePlaces = placeService.getPlaces();
		theModel.addAttribute("places", thePlaces);
		
		return "list-places";
	}
	
	@GetMapping("placeFormAdd")
	public String addPlaceForm(Model theModel) {
		
		theModel.addAttribute("place", new Place());
		
		return "place-form-add";
	}
	
	@PostMapping("savePlace")
	public String savePlace(@Valid @ModelAttribute("place") Place thePlace, BindingResult result) {
		
		if(result.hasErrors()) {
			return "place-form-add";	
		}	
		
		else {	
			
			placeService.savePlace(thePlace);
			return "redirect:/place/placeList";	
		
		}
	
	}
	
	@GetMapping("deletePlace")
	public String deletePlace(@RequestParam("placeId") int thePlaceId) {
		
		placeService.deletePlace(thePlaceId);
		
		return "redirect:/place/placeList";
	}
	
	
	@GetMapping("placeFormUpdate")
	public String updatePlaceForm(@RequestParam("placeId") int thePlaceId, Model theModel) {
		
		Place thePlace = new Place();
		thePlace = placeService.getPlace(thePlaceId);
		
		theModel.addAttribute("place", thePlace);
		return "place-form-update";
		
	}
	
	@PostMapping("updatePlace")
	public String updatePlace(@Valid @ModelAttribute("place") Place thePlace, BindingResult result) {
		
		if(result.hasErrors()) {
			return "place-form-update";
		}
		
		else {
			
			placeService.updatePlace(thePlace);
			return "redirect:/place/placeList";
			
		}	
	}
	
	@PostMapping("searchPlace")
	public String searchPlace(@RequestParam("theSearchName") String theSearchName, Model theModel) {
	
	List<Place> listOfPlaces = placeService.searchPlace(theSearchName);
	
	theModel.addAttribute("places", listOfPlaces);
	
	return "list-places";

	}
	
	@RequestMapping("takeTournamentsForPlace")
	public String takeTournaments(@RequestParam("placeId") int thePlaceId, Model theModel) {
		
		List<Tournament> listOfTournaments = placeService.getTournamentsForPlace(thePlaceId);
		theModel.addAttribute("tournamentsForPlace", listOfTournaments);
		
		return "list-tournaments-for-place";
	}
	
	
}
	
	
	
