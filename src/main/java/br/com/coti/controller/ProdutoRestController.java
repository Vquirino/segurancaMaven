package br.com.coti.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.coti.entity.Produto;
import br.com.coti.repository.ProdutoRepository;

@RestController
@CrossOrigin()
public class ProdutoRestController {
	
	@Autowired
	ProdutoRepository dao;
	
	@GetMapping("/produto")
	public List<Produto> findAll() {
		return dao.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto findByCode(@PathVariable @Min(1) Long id) {
		return dao.findById(id).orElseThrow(() -> 
		new IllegalArgumentException(" Produto não encontrado"));
	}
	
	@PostMapping("/produto")
	public ResponseEntity<?> newProduto(@Valid @RequestBody Produto produto) {
		try {
			Produto p = dao.save(produto);
			
			if (p.getId() == null) {
				new IllegalAccessException("Produto não encontrado");
			}
			return ResponseEntity.status(200).body(p);
		}
		catch (Exception ex) {
			return ResponseEntity.status(500).body("Produto não gravado");
		}
	}

}
