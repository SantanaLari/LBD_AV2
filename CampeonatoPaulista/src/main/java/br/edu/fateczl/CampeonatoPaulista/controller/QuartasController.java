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

import br.edu.fateczl.CampeonatoPaulista.model.Grupos;
import br.edu.fateczl.CampeonatoPaulista.persistence.IQuartasDao;
import br.edu.fateczl.CampeonatoPaulista.persistence.QuartasDao;

public class QuartasController {

	@RequestMapping(name = "quartas", value = "/quartas", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("quartas");
	}
	
	@RequestMapping(name = "quartas", value = "/quartas", method = RequestMethod.POST)
	public ModelAndView findQuartas(ModelMap model, @RequestParam Map<String, String> params ) {
		String botao = params.get("button");
		String erro = "";
		String saida = "";
		
		Grupos gp = new Grupos();
		
		IQuartasDao qDao = new QuartasDao();
		List<Grupos> listGA = new ArrayList<Grupos>();
		List<Grupos> listGB = new ArrayList<Grupos>();
		List<Grupos> listGC = new ArrayList<Grupos>();
		List<Grupos> listGD = new ArrayList<Grupos>();
		
		
		try {
			if(botao.contains("Criar Quartas")) {
				listGA = qDao.consultaGruposA();
				listGB = qDao.consultaGruposB();
				listGC = qDao.consultaGruposC();
				listGD = qDao.consultaGruposD();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			model.addAttribute("Grupos", gp);
			model.addAttribute("listGA", listGA);
			model.addAttribute("listGB", listGB);
			model.addAttribute("listGC", listGC);
			model.addAttribute("listGD", listGD);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		return new ModelAndView("quartas");
	}
	
}
