package br.edu.unifavip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifavip.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
