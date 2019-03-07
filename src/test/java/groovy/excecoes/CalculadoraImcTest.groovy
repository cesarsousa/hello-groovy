package groovy.excecoes;

import modelo.CalculadoraImc
import spock.lang.Specification

class CalculadoraImcTest extends Specification {

	def 'lancar excecao com peso invalido'(){
		
		when:
			boolean houveExcecao
			try {
				new CalculadoraImc().calcularImc(0, 1.70)
				houveExcecao = false
			}catch(IllegalArgumentException e) {
				houveExcecao = true
			}
	
		then:
			houveExcecao		
	}
	
	def 'lancar excecao com peso invalido exception conditions'(){
		
		when:
			new CalculadoraImc().calcularImc(0, 1.70)
		
		then:
			thrown(IllegalArgumentException)
	}
	
	def 'lanchar excecao com peso invalido multi cenarios'(){
		
		when:
			new CalculadoraImc().calcularImc(0, 1.70)
			
		then:
			thrown(IllegalArgumentException)
		
		when:
			new CalculadoraImc().calcularImc(-1, 1.70)
		
		then:
			thrown(IllegalArgumentException)		
		
	}
	
def 'lanchar excecao com altura invalida multi cenarios'(){
		
		when:
			new CalculadoraImc().calcularImc(1.70, 0)
			
		then:
			thrown(IllegalArgumentException)
		
		when:
			new CalculadoraImc().calcularImc(1.70, 0)
		
		then:
			thrown(IllegalArgumentException)		
		
	}

	def 'lancar exceção c/ mensagem correta p/ peso inválido'() {
		when:
			def peso = -1
			new CalculadoraImc().calcularImc(peso, 1.70)
		
		then:
			def ex = thrown(IllegalArgumentException)
			ex.message == "Peso inválido: ${peso.toDouble()}"
	}
	
}