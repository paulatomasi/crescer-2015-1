package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
	public String homeLogin() {
		return "homelogin";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		Boolean administrador = (Boolean) session.getAttribute("administrador");
		String usuarioLogado = (String) session.getAttribute("usuarioLogado");
		if (usuarioLogado != null){
			model.addAttribute("usuarioLogado", true);
			if(administrador != null && administrador) {
				model.addAttribute("menuAdministrador", true);
			}else{
				model.addAttribute("menuAdministrador", false);
			}
			return "home";
		}else{
			return "erro";
		}
	}

	@RequestMapping(value = "/cadastroFilme", method = RequestMethod.GET)
	public String cadastroFilme(HttpSession session, Model model) {
		Boolean administrador = (Boolean) session.getAttribute("administrador");
		String usuarioLogado = (String) session.getAttribute("usuarioLogado");
		if (usuarioLogado != null){
			model.addAttribute("usuarioLogado", true);
			if(administrador != null && administrador) {
				model.addAttribute("menuAdministrador", true);
				return "cadastroFilme";
			}else{
				model.addAttribute("menuAdministrador", false);
				return "erro";
			}
			
		}else{
			return "erro";
		}
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
	
	
		
	@RequestMapping(value = "/avaliacao", method = RequestMethod.GET)
	public String avaliacao(HttpSession session, Model model) {
		String usuarioLogado = (String) session.getAttribute("usuarioLogado");
		if (usuarioLogado != null){
			model.addAttribute("usuarioLogado", true);
			model.addAttribute("Filmes", filmeDao.consultaFilme());		
			return "avaliacao";
		}else{
			return "erro";
		}
	}
	
	@RequestMapping(value = "/erro", method = RequestMethod.GET)
	public String erro() {
		return "erro";
	}
}