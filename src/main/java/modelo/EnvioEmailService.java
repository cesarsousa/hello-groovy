package modelo;

import java.util.List;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class EnvioEmailService {
	
	private Email email;
	
	private int enviados;

	public EnvioEmailService(Email email) {
		super();
		this.email = email;
	}
	
	public void enviarEmail(String assunto, String conteudo, List<String> destinatarios) throws EmailException {
		
		this.email.setSubject(assunto);
		this.email.setMsg(conteudo);
		this.email.addTo(destinatarios.toArray(new String[destinatarios.size()]));
		
		this.email.send();
		
		this.enviados++;
		
	}
	
	public int getEnviados() {
		return enviados;
	}

}
