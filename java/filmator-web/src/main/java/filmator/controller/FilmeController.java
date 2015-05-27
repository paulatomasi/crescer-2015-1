package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class FilmeController {
	@Inject
	FilmeDao listaFilmes;

	@RequestMapping(value = "/salvarFilme", method = RequestMethod.POST)
	public String salvarFilme(Filme filme){
		listaFilmes.salvarFilme(filme);		
		return "redirect:/home";
	}

}