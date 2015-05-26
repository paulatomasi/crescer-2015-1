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
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme){
		System.out.println(filme.getNome());
		listaFilmes.salvar(filme);		
		return "redirect:/";
	}
	
}