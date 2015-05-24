package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class FilmeController {
	FilmeDao filmesalvos = new FilmeDao();
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme){
		filmesalvos.salvar(filme);		
		return "cadastro";
	}
	
	
}