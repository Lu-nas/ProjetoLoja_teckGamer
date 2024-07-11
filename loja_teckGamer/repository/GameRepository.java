package com.generation.loja_teckGamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.loja_teckGamer.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
