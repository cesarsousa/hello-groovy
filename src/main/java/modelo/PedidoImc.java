package modelo;

import enums.Sexo;

public interface PedidoImc {
	
	String getNome();
	
	double getPeso();
	
	double getAltura();
	
	Sexo getSexo();
	
	String getNome(String pronomeTratamento);
	
	String getNome(String pronomeTratamento, String apelido);

}
