package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void salvarAvaliacao(String login, int idFilme, int nota){
		jdbcTemplate.update("INSERT INTO Avaliacao (login, id_filme, nota) VALUES (?, ?, ?)", 
				login,
				idFilme,
				nota
				);
	}

	public void alterarAvalicao(String login, int idFilme, int nota){
		jdbcTemplate.update("UPDATE Avaliacao SET nota = ? WHERE login = ? AND id_filme = ?", 
				nota,
				login,
				idFilme
				);
	}

	public List<Integer> getNota(int idFilme, String login) {
		return jdbcTemplate.query("SELECT nota FROM Avaliacao WHERE login = ? AND id_filme = ?",
				(ResultSet results, int rowNum) -> {	
					return results.getInt("nota");
				},
				login,
				idFilme
				);
	}

}
