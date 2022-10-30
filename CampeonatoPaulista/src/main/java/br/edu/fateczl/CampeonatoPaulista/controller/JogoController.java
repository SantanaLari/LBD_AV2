package br.edu.fateczl.CampeonatoPaulista.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fateczl.CampeonatoPaulista.model.Jogos;
import br.edu.fateczl.CampeonatoPaulista.persistence.IJogosDao;
import br.edu.fateczl.CampeonatoPaulista.persistence.JogosDao;

public class JogoController {

	@RequestMapping(name = "jogos", value = "/jogos", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("grupos");
	}

	@RequestMapping(name = "jogos", value = "/jogos", method = RequestMethod.POST)
	public ModelAndView findJogos(ModelMap model, @RequestParam Map<String, String> params ) {
		String erro = "";
		String saida = "";
		
		Jogos jg = new Jogos();
		
		IJogosDao jgDao = new JogosDao();
		List<Jogos> listJG = new ArrayList<Jogos>();
		
		try {
			listJG = jgDao.consultaJogos();
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			model.addAttribute("jogos", jg);
			model.addAttribute("listJG", listJG);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		return new ModelAndView("jogos");
	}
	
}
