package br.edu.unifavip;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unifavip.domain.Aluno;
import br.edu.unifavip.domain.AlunoDisciplina;
import br.edu.unifavip.domain.Curso;
import br.edu.unifavip.domain.Disciplina;
import br.edu.unifavip.domain.Professor;
import br.edu.unifavip.domain.SituacaoAluno;
import br.edu.unifavip.domain.TitulacaoProfessor;
import br.edu.unifavip.repositories.AlunoDisciplinaRepository;
import br.edu.unifavip.repositories.AlunoRepository;
import br.edu.unifavip.repositories.CursoRepository;
import br.edu.unifavip.repositories.DisciplinaRepository;
import br.edu.unifavip.repositories.ProfessorRepository;

@SpringBootApplication
public class ProjetoDevsoftApplication implements CommandLineRunner {

	@Autowired
	private CursoRepository cursoRep;
	
	@Autowired
	private AlunoRepository alunoRep;
	
	@Autowired
	private DisciplinaRepository disciplinaRep;
	
	@Autowired
	private ProfessorRepository professorRep;
	
	@Autowired
	private AlunoDisciplinaRepository alunoDisciplinaRep;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoDevsoftApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Curso curso = new Curso();
		curso.setNome("Analise e Desenvolvimento de Sistemas");
		curso.setDuracao(3);
		
		Curso curso2 = new Curso();
		curso2.setNome("Ciências da Computação");
		curso2.setDuracao(4);
		
		cursoRep.saveAll(Arrays.asList(curso, curso2));
		
		Aluno aluno = new Aluno();
		aluno.setNome("Lucas Lima");
		aluno.setDataMatricula(new Date());
		aluno.setCpf("666.666.666-66");
		aluno.setCurso(curso);
		aluno.getTelefones().add("81987456985");
		aluno.getTelefones().add("81998745698");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Alexandre");
		aluno2.setDataMatricula(new Date());
		aluno2.setCpf("111.111.111-11");
		aluno2.setCurso(curso);
		aluno2.getTelefones().add("81996857412");
		
		alunoRep.save(aluno);
		alunoRep.save(aluno2);
		
		Professor professor = new Professor();
		professor.setTitulacao(TitulacaoProfessor.MESTRE);
		professor.setNome("Wolney");
		
		Professor professor2 = new Professor();
		professor2.setNome("Rodrigo");
		professor2.setTitulacao(TitulacaoProfessor.MESTRE);
		
		Professor professor3 = new Professor();
		professor3.setNome("Sérgio");
		professor3.setTitulacao(TitulacaoProfessor.DOUTOR);
		
		Disciplina disciplina = new Disciplina();
		disciplina.setNome("Desenvolvimento de Software");
		disciplina.setCargaHoraria(60);
		disciplina.getProfessores().add(professor);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Algoritmos Computacionais");
		disciplina2.setCargaHoraria(60);
		disciplina2.getProfessores().add(professor);
		disciplina2.getProfessores().add(professor2);
		
		disciplinaRep.save(disciplina);
		disciplinaRep.save(disciplina2);
		
		professor.getDisciplinas().add(disciplina);
		professor.getDisciplinas().add(disciplina2);
		professor2.getDisciplinas().add(disciplina2);
		
		professorRep.save(professor);
		professorRep.save(professor2);
		professorRep.save(professor3);
		
		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
		alunoDisciplina.getId().setAluno(aluno);
		alunoDisciplina.getId().setDisciplina(disciplina);
		alunoDisciplina.setFaltas(3);
		alunoDisciplina.setNota1(7.5d);
		alunoDisciplina.setNota2(8d);
		alunoDisciplina.setNota3(6.5d);
		alunoDisciplina.setSituacao(SituacaoAluno.APROVADO);
		
		AlunoDisciplina alunoDisciplina2 = new AlunoDisciplina();
		alunoDisciplina2.getId().setAluno(aluno);
		alunoDisciplina2.getId().setDisciplina(disciplina2);
		alunoDisciplina2.setFaltas(1);
		alunoDisciplina2.setNota1(5d);
		alunoDisciplina2.setNota2(4d);
		alunoDisciplina2.setNota3(5.5d);
		alunoDisciplina2.setSituacao(SituacaoAluno.REPROVADO);
		
		AlunoDisciplina alunoDisciplina3 = new AlunoDisciplina();
		alunoDisciplina3.getId().setAluno(aluno2);
		alunoDisciplina3.getId().setDisciplina(disciplina);
		alunoDisciplina3.setFaltas(4);
		alunoDisciplina3.setNota1(9d);
		alunoDisciplina3.setNota2(8.5d);
		alunoDisciplina3.setNota3(9.5d);
		alunoDisciplina3.setSituacao(SituacaoAluno.APROVADO);
		
		alunoDisciplinaRep.save(alunoDisciplina);
		alunoDisciplinaRep.save(alunoDisciplina2);
		alunoDisciplinaRep.save(alunoDisciplina3);
		
	}

}
