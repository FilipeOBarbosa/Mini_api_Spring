package br.edu.ifpb.dac.projetoinsomina.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.projetoinsomina.model.entity.Weapon;
import br.edu.ifpb.dac.projetoinsomina.model.repository.WeaponRepository;

@Service
public class WeaponService {
	
	@Autowired
	private WeaponRepository weaponDAO;
	
	
	public void save(Weapon weapon) {
		weaponDAO.save(weapon);
	}
	
	public Weapon read(Long id) {
		return weaponDAO.findById(id).get();
	}
	
	
	public Weapon update(Weapon weapon) {
		return weaponDAO.save(weapon);
	}
	
	public void delete(Long id) {
		weaponDAO.deleteById(id);
	}

	public Iterable<Weapon> findAll(){
		return weaponDAO.findAll();
	}
	
	public List<Weapon> find(Weapon filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return weaponDAO.findAll(example);
	}
}
