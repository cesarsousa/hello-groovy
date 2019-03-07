package dao.imp;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import dao.ImcAtual;
import modelo.ResultadoImc;

public class ImcAtualService {

	private static final String CONSULTA_IMC = "SELECT i FROM ImcAtual i WHERE nome = ?0";

	private EntityManager entityManager;

	private ImcAtual imcExistente(ResultadoImc resultado) {
		try {
			return this.entityManager.createQuery(CONSULTA_IMC, ImcAtual.class).setParameter(0, resultado.getNome()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public int registrarImc(List<ResultadoImc> resultados) throws SQLException {
		int inseridos = 0;
		for (ResultadoImc resultado : resultados) {
			ImcAtual imcExistente = this.imcExistente(resultado);
			if (imcExistente != null) {
				imcExistente.setImc(resultado.getImc());
				continue;
			}
			ImcAtual imcAtual = new ImcAtual(resultado.getNome(), resultado.getImc());
			this.entityManager.persist(imcAtual);
			inseridos++;
		}
		return inseridos;
	}

}
