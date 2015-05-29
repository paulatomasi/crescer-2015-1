package filmator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;
import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;


import filmator.model.Filme;import filmator.model.Genero;


@Component
public class FilmeDao {


	@Inject
	private JdbcTemplate jdbcTemplate;

	public void salvarFilme(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (nome, genero, ano_lancamento, diretor, sinopse, imagem) VALUES (?, ?, ?, ?, ?, ?)", 
				filme.getNome(),
				filme.getGenero().name(),
				filme.getAnoLancamento(),
				filme.getDiretor(), 
				filme.getSinopse(),
				filme.getImagem()
				);
	}

	public List<Filme> consultaFilme(){
		return jdbcTemplate.query("SELECT * FROM Filme", (ResultSet rs, int rowNum) -> {	
			Filme filme = new Filme();
			filme.setIdFilme(rs.getInt("id_filme"));
			filme.setNome(rs.getString("nome"));
			filme.setGenero(Genero.valueOf(rs.getString("genero")));
			filme.setAnoLancamento(rs.getInt("ano_lancamento"));
			filme.setDiretor(rs.getString("diretor"));
			filme.setSinopse(rs.getString("sinopse"));
			filme.setImagem(rs.getString("imagem"));
			return filme;
		});

	}

}
