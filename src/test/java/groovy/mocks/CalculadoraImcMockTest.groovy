package groovy.mocks

import enums.FaixaImc
import enums.Sexo
import modelo.CalculadoraImc
import modelo.PedidoImc
import spock.lang.Specification

class CalculadoraImcMockTest extends Specification{

	def 'deveria ser um homem acima do peso'(){
		
		given:
		def pedido = Mock(PedidoImc)
		
		pedido.getNome() >> "Zé Fofinho"
		pedido.getSexo() >> Sexo.MASCULINO
		pedido.getPeso() >> 72
		pedido.getAltura() >> 1.50
		
		when:
		def resultado = new CalculadoraImc().verificarCondicaoImc(pedido)
		
		then:
		resultado.imc == 72
		resultado.condicao == FaixaImc.ACIMA.descricao
		
	}
	
	/*
	 * O operador >> pode ser usado também para	indicar todo o corpo do método de um Mock.
	 */
	def 'deveria ser um homem acima do peso 2'(){
		
		given:
		def pedido = Mock(PedidoImc)
		
		pedido.getNome() >> {
			if(pedido.getSexo() == Sexo.MASCULINO) {
				"Zé Fofinho"
			}else {
				"Maria Fofinha"
			}
		}
		pedido.getSexo() >> Sexo.MASCULINO
		pedido.getPeso() >> 72
		pedido.getAltura() >> 1.50
		
		when:
		def resultado = new CalculadoraImc().verificarCondicaoImc(pedido)
		
		then:
		resultado.imc == 72
		resultado.condicao == FaixaImc.ACIMA.descricao
		
	}
	
	
	
	
	
	
	
}
