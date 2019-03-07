package enums;

public enum FaixaImc {
	
	ABAIXO("Abaixo do peso", 19, 21),
	NORMAL ("Peso normal", 26, 27),
	ACIMA("Acima do peso", 100, 100);
		
	private FaixaImc(String descricao, double limiteMaximoFeminino, double limiteMaximoMasculino) {
		this.descricao = descricao;
		this.limiteMaximoFeminino = limiteMaximoFeminino;
		this.limiteMaximoMasculino = limiteMaximoMasculino;
	}

	protected String descricao;
	protected double limiteMaximoFeminino;
	protected double limiteMaximoMasculino;
	
	public static FaixaImc getFaixa(double imc, Sexo sexo) {
		
		FaixaImc retorno = values()[0];
		
		for (int i=1; i < values().length; i++) {
			
			FaixaImc atual = values()[i];
			FaixaImc anterior = values()[i-1];
			double limiteInferior = (sexo == Sexo.FEMININO) ? anterior.limiteMaximoFeminino : anterior.limiteMaximoMasculino;
			double limiteSuperior = (sexo == Sexo.FEMININO) ? atual.limiteMaximoFeminino : atual.limiteMaximoMasculino;
			if (imc >= limiteInferior && imc < limiteSuperior) {
			retorno = atual;
			
			}
			
		}
		
		return retorno;
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getLimiteMaximoFeminino() {
		return limiteMaximoFeminino;
	}
	
	public double getLimiteMaximoMasculino() {
		return limiteMaximoMasculino;
	}

}
