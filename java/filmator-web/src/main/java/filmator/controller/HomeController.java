package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;

@Controller
public class HomeController {

	@Inject
	private FilmeDao filmeDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {		
		return "login";
	}

	@RequestMapping(value = "/cadastroFilme", method = RequestMethod.GET)
	public String cadastroFilme() {		
		return "cadastroFilme";
	}

	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String consultaFilme(Model model){
		model.addAttribute("Filmes", filmeDao.consultaFilme());		
		return "consulta";		
	}
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.GET)
	public String cadastrarUsuario() {		
		return "cadastroUsuario";
	}
	
	@RequestMapping(value = "/erro", method = RequestMethod.GET)
	public String erro() {
		return "erro";
	}
}