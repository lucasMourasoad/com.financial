package br.edu.unifavip.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricula;

	@Column(length = 80, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_matricula")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataMatricula;

	@Column(unique = true, nullable = false)
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "curso_codigo")
	private Curso curso;

	@ElementCollection
	@CollectionTable(name = "alunos_telefones")
	private Set<String> telefones = new HashSet<>();

	@OneToMany(mappedBy = "id.aluno")
	private Set<AlunoDisciplina> disciplinas = new HashSet<>();

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public Set<AlunoDisciplina> getDisciplinas() {
		for(AlunoDisciplina a : disciplinas) {
			a.getId().setAluno(null);
		}
		return disciplinas;
	}

	public void setDisciplinas(Set<AlunoDisciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
