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
import br.edu.ifpb.dac.projetoinsomina.business.service.WeaponService;
import br.edu.ifpb.dac.projetoinsomina.model.entity.Weapon;

@RestController
@RequestMapping("/api/weapon")
public class WeaponController {
	@Autowired
	private WeaponService weaponService;

	@PostMapping
	public ResponseEntity save(@RequestBody Weapon weapon) {
		try {
			weaponService.save(weapon);
			return new ResponseEntity(weapon, HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") int id,@RequestBody Weapon weapon) {
		System.out.println(weapon.getName());
		try {
			weapon = weaponService.update(weapon);
			return ResponseEntity.ok(weapon);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") int id){
		try {
			System.out.println(id);
			weaponService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity find( @RequestParam(value = "id", required = false) int id) {
		try {
			Weapon weapon = weaponService.read(id);
			return ResponseEntity.ok(weapon);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
