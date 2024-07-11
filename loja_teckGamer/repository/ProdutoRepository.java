package com.generation.loja_teckGamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.loja_teckGamer.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
