package br.edu.unifavip.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "disciplinas")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(length = 100, nullable = false)
	private String nome;

	@Lob
	@Column(nullable = true)
	private String ementa;

	@Column(name = "carga_horaria", nullable = false)
	private int cargaHoraria;

	@JsonBackReference
	@ManyToMany(mappedBy = "disciplinas")
	private List<Professor> professores = new ArrayList<Professor>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.disciplina")
	private Set<AlunoDisciplina> alunos = new HashSet<>();

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Aluno> getAlunos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		for(AlunoDisciplina alunoDisciplina : this.alunos) {
			alunos.add(alunoDisciplina.getId().getAluno());
		}
		return alunos;
	}

	public void setAlunos(Set<AlunoDisciplina> alunos) {
		this.alunos = alunos;
	}

}
