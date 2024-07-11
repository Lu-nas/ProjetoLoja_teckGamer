package com.generation.loja_teckGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.loja_teckGamer.model.Game;
import com.generation.loja_teckGamer.service.GameService;

@RestController
@RequestMapping("/api/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<Game> getAllGames(){
		return gameService.findAll();
	}
	
	@PostMapping
	public Game createGame(@RequestBody Game game) {
		return gameService.save(game);
	}
	
	@DeleteMapping("/{id}")
		public void deleteGame(@PathVariable Long id) {
			gameService.deleteById(id);
		}
	}


