package br.edu.ifpb.dac.projetoinsomina.presentation.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifpb.dac.projetoinsomina.business.service.HeroService;
import br.edu.ifpb.dac.projetoinsomina.model.entity.Hero;

@RestController
@RequestMapping("/api/hero")
public class HeroController{

	@Autowired
	private HeroService heroService;

	@PostMapping
	public ResponseEntity save(@RequestBody Hero hero) {
		try {
			heroService.save(hero);
			return new ResponseEntity(hero, HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") int id,@RequestBody Hero hero) {
		try {
			hero = heroService.update(hero);
			return ResponseEntity.ok(hero);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") int id){
		try {
			heroService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity find( @RequestParam(value = "id", required = false) int id) {
		try {
			Hero hero = heroService.read(id);
			return ResponseEntity.ok(hero);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
