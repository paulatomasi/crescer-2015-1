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



import filmator.model.Filme;
import filmator.model.Usuario;

@Component
public class UsuarioDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void salvarUsuario(Usuario usuario){
		jdbcTemplate.update("INSERT INTO Usuario (login, senha) VALUES (?, ?)", 
				usuario.getLogin(),
				usuario.getSenha()
				);
	}
}
