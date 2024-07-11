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

import com.generation.loja_teckGamer.model.Categoria;
import com.generation.loja_teckGamer.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> getAllCategorias(){
		return categoriaService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria.isPresent()) {
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }
	
	
	@PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Optional<Categoria> categoriaExistente = categoriaService.findById(id);
        if (categoriaExistente.isPresent()) {
            categoria.setId(id);
            return new ResponseEntity<>(categoriaService.save(categoria), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
	        categoriaService.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
}
