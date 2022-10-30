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
import br.edu.fateczl.CampeonatoPaulista.persistence.IResultadosDao;
import br.edu.fateczl.CampeonatoPaulista.persistence.ResultadosDao;

public class ResultadosController {

	@RequestMapping(name = "resultados", value = "/resultados", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("resultados");
	}
	
	@RequestMapping(name = "resultados", value = "/resultados", method = RequestMethod.POST)
	public ModelAndView findPlacar(ModelMap model, @RequestParam Map<String, String> params ) throws ClassNotFoundException, SQLException {
		String botao = params.get("button");
		String erro = "";
		String saida = "";
		String nomeTimeA = "";
		String nomeTimeB = "";
		String data = "";
		int golsTimeA = 0;
		int golsTimeB = 0;
		
		Jogos j = new Jogos();

		
		IResultadosDao rDao = new ResultadosDao();
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		try {
			if(botao.contains("Inserir Resultado")) {
				data = params.get("Data");
				nomeTimeA = params.get("TimeA");
				nomeTimeB = params.get("TimeB");
				golsTimeA = Integer.parseInt(params.get("golsA"));
				golsTimeB = Integer.parseInt(params.get("golsB"));
				saida = rDao.insereResultados(nomeTimeA, nomeTimeB, golsTimeA, golsTimeB, data);
			}
			if(botao.contains("Listar Resultados")) {
				jogos = rDao.consultaResultados();
			}
		}finally {
			
			model.addAttribute("jogo", j);
			model.addAttribute("jogos", jogos);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		return new ModelAndView("resultados");
	}
	
}
