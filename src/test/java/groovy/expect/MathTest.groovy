package groovy.expect;

import spock.lang.Specification

class MathTest extends Specification {
	
	def '2 ao quadrado deve ser 4'() {
		expect:
			Math.pow(2,2) == 4
			Math.sqrt(4) == 2
			Math.sqrt(25) == 5
			Math.sqrt(144) == 12
	}
	
	
	def 'listas devem ser iguais'() {
		expect:
		def lista1 = ['café','leite','açucar']
		def lista2 = ['café','leite','açucar']
		lista1 == lista2
	}
	
	
	def 'mapas devem ser iguais'() {
		expect:
		def mapa1 = [PA:'Pará', SP:'São Paulo', MG:'Minas Gerais']
		def mapa2 = [PA:'Pará', SP:'São Paulo', MG:'Minas Gerais']
		mapa1 == mapa2
	}
	
	def 'listas devem ser ter o mesmo tamanho'() {
		expect:
		def lista1 = ['uva','morango','amora']
		def lista2 = ['uva','morango','amora']
		lista1.size() == lista2.size()
	}
}