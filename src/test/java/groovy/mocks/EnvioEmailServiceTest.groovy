package groovy.mocks

import com.sun.mail.util.MailConnectException
import com.sun.mail.util.SocketConnectException
import javax.mail.AuthenticationFailedException

import org.apache.commons.mail.Email
import org.apache.commons.mail.EmailException

import modelo.EnvioEmailService
import spock.lang.Specification

class EnvioEmailServiceTest extends Specification{
	
	Email email
	EnvioEmailService service
	
	def setup() {
		this.email = Mock(Email)
		this.service = new EnvioEmailService(this.email)
	}
	
	def 'deveria lancar erro de autenticacao'(){
		
		given:
		def msgErro = 'Falha de autenticação! Sorry :('
		
		this.email.send() >> {
			throw new EmailException(new AuthenticationFailedException(msgErro))
		}
		
		when:
		this.service.enviarEmail('assunto', 'conteudo', ['em@t.com'])
		
		then:
		def ex = thrown(EmailException)
		ex.cause.class == AuthenticationFailedException.class
		ex.cause.message == msgErro		
		!this.service.enviados		
		
	}
	
	def 'deveria lançar erro de conexão'() {
		
		given:
		def servidor = 'teste.com'
		def porta = 7777
		def timeout = 1
		
		this.email.send() >> {
			def sce = new SocketConnectException("", null, servidor, porta, timeout)
			throw new EmailException(new MailConnectException(sce))
		}
		
		when:
		this.service.enviarEmail('assunto', 'conteudo', ['em@t.com'])
		
		then:
		def ex = thrown(EmailException)
		ex.cause.class == MailConnectException.class
		ex.cause.message.contains(servidor)
		ex.cause.message.contains(porta.toString())
		!this.service.enviados
		
	}	
}
