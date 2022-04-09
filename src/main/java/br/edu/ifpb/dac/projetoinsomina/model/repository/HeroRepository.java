package br.edu.ifpb.dac.projetoinsomina.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.projetoinsomina.model.entity.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer>{

}
