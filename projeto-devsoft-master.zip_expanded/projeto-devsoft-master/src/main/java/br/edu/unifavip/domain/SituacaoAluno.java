package br.edu.unifavip.domain;

public enum SituacaoAluno {

	MATRICULADO(1, "Matriculado"),
	APROVADO(2, "Aprovado"),
	REPROVADO(3, "Reprovado");
	
	private int codigo;
	private String descricao;
	
	private SituacaoAluno(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static SituacaoAluno toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(SituacaoAluno o : SituacaoAluno.values()) {
			if(o.getCodigo() == codigo.intValue()) {
				return o;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + codigo);
	}
	
}
