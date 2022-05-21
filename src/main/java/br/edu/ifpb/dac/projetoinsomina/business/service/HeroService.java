package br.edu.ifpb.dac.projetoinsomina.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
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
	
	public Hero read(Long id) {
		return heroDAO.findById(id).get();
	}
	
	
	public Hero update(Hero hero) {
		return heroDAO.save(hero);
	}
	
	public void delete(Long id) {
		heroDAO.deleteById(id);
	}

	public Iterable<Hero> findAll(){
		return heroDAO.findAll();
	}
	
	public List<Hero> find(Hero filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return heroDAO.findAll(example);
	}
	
}
