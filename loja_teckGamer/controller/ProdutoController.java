package com.generation.loja_teckGamer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.loja_teckGamer.model.Produto;
import com.generation.loja_teckGamer.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	
	 @GetMapping
	    public List<Produto> getAllProdutos() {
	        return produtoService.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
	        Optional<Produto> produto = produtoService.findById(id);
	        if (produto.isPresent()) {
	            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @PostMapping
	    public Produto createProduto(@RequestBody Produto produto) {
	        return produtoService.save(produto);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
	        Optional<Produto> produtoExistente = produtoService.findById(id);
	        if (produtoExistente.isPresent()) {
	            produto.setId(id);
	            return new ResponseEntity<>(produtoService.save(produto), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
	        produtoService.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
