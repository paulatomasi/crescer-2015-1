package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Filme;
import filmator.model.Usuario;

@Controller
public class UsuarioController {
	@Inject
	UsuarioDao listaUsuarios;

	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public String salvarUsuario(Usuario usuario){
		listaUsuarios.salvarUsuario(usuario);		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/autenticar", method = RequestMethod.POST)
	public String autenticar(String login, String senha){	
		if (listaUsuarios.autenticar(login, senha)){
			if (login.equals("admin")){
				return "redirect:/home";
			}else{
				return "redirect:/homeUsuario";
			}
		}
		return "redirect:/erro";
	}

}
