package br.edu.ifpb.dac.projetoinsomina.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Weapon read(int id) {
		return weaponDAO.findById(id).get();
	}
	
	public List<Weapon> readAll(){
		return (List<Weapon>) weaponDAO.findAll();
	}
	
	public Weapon update(Weapon weapon) {
		return weaponDAO.save(weapon);
	}
	
	public void delete(int id) {
		weaponDAO.deleteById(id);
	}
}
