package br.edu.unifavip.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "aluno_disciplina")
public class AlunoDisciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoDisciplinaPK id = new AlunoDisciplinaPK();
	private Integer faltas;
	private Double nota1;
	private Double nota2;
	private Double nota3;
	private Integer situacao;

	public AlunoDisciplinaPK getId() {
		return id;
	}

	public void setId(AlunoDisciplinaPK id) {
		this.id = id;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getNota3() {
		return nota3;
	}

	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}

	public SituacaoAluno getSituacao() {
		return SituacaoAluno.toEnum(situacao);
	}

	public void setSituacao(SituacaoAluno situacao) {
		this.situacao = situacao.getCodigo();
	}

}
