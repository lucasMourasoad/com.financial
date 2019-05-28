package br.edu.unifavip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifavip.domain.AlunoDisciplina;
import br.edu.unifavip.domain.AlunoDisciplinaPK;

public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina, AlunoDisciplinaPK> {

}
