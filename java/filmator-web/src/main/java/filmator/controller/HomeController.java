package filmator.controller;

import java.util.Arrays;

import org.mockito.InjectMocks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//DAO = data acess object
		FilmeDao dao = new FilmeDao();
		model.addAttribute("filmes",  dao.buscaTodosFilmes());
		return "nomeDoArquivo";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar (Filme filme, Model model) {
		System.out.println(filme.getNome());
		return "nomeDoArquivo";
	}
}

