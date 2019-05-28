package br.edu.unifavip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifavip.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
