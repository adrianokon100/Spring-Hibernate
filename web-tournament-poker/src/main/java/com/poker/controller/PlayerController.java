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

import com.poker.entity.Player;
import com.poker.service.PlayerService;


@Controller
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	public PlayerService playerService;

	@GetMapping("/playerList")
	public String getPlayers(Model theModel) {
		
		// get players from DAO
		List<Player> thePlayers = playerService.getPlayers();
		theModel.addAttribute("players", thePlayers);
		
		
		return "list-players";
	}
	
	@GetMapping("/playerFormAdd")
	public String addPlayerForm(Model theModel) {
		
		theModel.addAttribute("player", new Player()); 
		
		return "player-form-add";
	}
	
	@PostMapping("/savePlayer")
	public String savePlayer(@Valid @ModelAttribute("player") Player thePlayer, BindingResult result) {		
		
		if (result.hasErrors()) {
            // w przypadku b³êdów wyœwietl ponownie formularz z komunikatami b³êdów
            return "player-form-add";
        
		} else {
        	
            // brak b³êdów umo¿liwia dalsze przetwarzanie, np. zapis do bazy danych
    		playerService.savePlayer(thePlayer);
            return "redirect:/player/playerList";
        }
		
	}
	
	@GetMapping("/playerFormUpdate")
	public String updatePlayerForm(@RequestParam("playerId") int thePlayerId, Model theModel) {

		Player tempPlayer = playerService.getPlayer(thePlayerId);
		theModel.addAttribute("player", tempPlayer);
		
		return "player-form-update";
	}
	
	@PostMapping("/updatePlayer")
	public String updatePlayer(@Valid @ModelAttribute("player") Player thePlayer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "player-form-update";
		}
		
		else {
		
			playerService.updatePlayer(thePlayer);
			return "redirect:/player/playerList";
		
		}
	}
	
	@GetMapping("/deletePlayer")
	public String deletePlayer(@RequestParam("playerId") int thePlayerId ) {
		
		
		playerService.deletePlayer(thePlayerId);
		return "redirect:/player/playerList";
	}
	
	@PostMapping("/searchPlayer")
	public String searchPlayer(@RequestParam("thisName") String theName, Model theModel) {	
		
		List<Player> thePlayers = playerService.searchPlayer(theName);;
		theModel.addAttribute("players", thePlayers);
		
		
		return "list-players";
	}
	
	
}
