package br.edu.ifpb.dac.projetoinsomina.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.projetoinsomina.model.entity.Hero;
import br.edu.ifpb.dac.projetoinsomina.model.repository.HeroRepository;

@Service
public class HeroService {

	@Autowired
	private HeroRepository heroDAO;
	
	
	public void save(Hero hero) {
		heroDAO.save(hero);
	}
	
	public Hero read(int id) {
		return heroDAO.findById(id).get();
	}
	
	public List<Hero> readAll(){
		return (List<Hero>) heroDAO.findAll();
	}
	
	public Hero update(Hero hero) {
		return heroDAO.save(hero);
	}
	
	public void delete(int id) {
		heroDAO.deleteById(id);
	}
	
}
