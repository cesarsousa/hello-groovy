package dao;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ImcAtual {

	@Column(length = 50)
	private String nome;
	@Column
	private double imc;

	public ImcAtual(String nome, double imc) {
		super();
		this.nome = nome;
		this.imc = imc;
	}

	public ImcAtual() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

}
