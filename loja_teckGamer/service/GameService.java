package com.generation.loja_teckGamer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.loja_teckGamer.model.Game;
import com.generation.loja_teckGamer.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<Game> findAll(){
		
		return gameRepository.findAll();
	}
	public Game save(Game game) {
		
		return gameRepository.save(game);
	}
	public void deleteById(Long id) {
		gameRepository.deleteById(id);
	}
}
