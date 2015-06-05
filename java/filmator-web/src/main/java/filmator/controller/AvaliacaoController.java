package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AvaliacaoDao;
import filmator.model.Avaliacao;

@Controller
public class AvaliacaoController {
	@Inject
	AvaliacaoDao avaliacoes;

	@RequestMapping(value = "/salvaravaliacao", method = RequestMethod.POST)
	public String salvarAvaliacao(Avaliacao avaliacao, Model model, HttpSession session){
		String login = (String) session.getAttribute("usuarioLogado");
		if(login!=null){
			int idFilme = avaliacao.getIdFilme();
			int nota = avaliacao.getNota();
			if (avaliacoes.getNota(idFilme, login).isEmpty()){
				avaliacoes.salvarAvaliacao(login, idFilme, nota);
			}else{
				avaliacoes.alterarAvalicao(login, idFilme, nota);
			}
		}
		return "redirect:/home";
	}

}