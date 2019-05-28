package br.edu.unifavip.domain;

public enum TitulacaoProfessor {
	
	ESPECIALISTA(1, "Especialista"),
	MESTRE(2, "Mestre"),
	DOUTOR(3, "Doutor");
	
	private int codigo;
	private String descricao;
	
	private TitulacaoProfessor(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TitulacaoProfessor toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(TitulacaoProfessor o : TitulacaoProfessor.values()) {
			if(o.getCodigo() == codigo.intValue()) {
				return o;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + codigo);
	}

}
