package filmator.controller;

import java.util.Arrays;

import javax.inject.Inject;

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
	
	@Inject
	private FilmeDao filmeDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastraFilme() {		
		return "cadastro";
	}
	
	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String consultaFilme(Model model){
		model.addAttribute("Filmes", filmeDao.consultaFilme());		
		return "consulta";		
	}
	
}

