package br.edu.ifpb.dac.projetoinsomina.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.projetoinsomina.model.entity.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long>{

	
}
