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
import br.edu.fateczl.CampeonatoPaulista.persistence.GrupoDao;
import br.edu.fateczl.CampeonatoPaulista.persistence.IGrupoDao;

public class GruposFormadosController {

	@RequestMapping(name = "gruposFormados", value = "/gruposFormados", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("gruposFormados");
	}

	@RequestMapping(name = "gruposFormados", value = "/gruposFormados", method = RequestMethod.POST)
	public ModelAndView findGruposFormados(ModelMap model, @RequestParam Map<String, String> params ) {
		String erro = "";
		String saida = "";
		
		Grupos gp = new Grupos();
		
		IGrupoDao gpDao = new GrupoDao();
		List<Grupos> listGPA = new ArrayList<Grupos>();
		List<Grupos> listGPB = new ArrayList<Grupos>();
		List<Grupos> listGPC = new ArrayList<Grupos>();
		List<Grupos> listGPD = new ArrayList<Grupos>();
		
		
		try {
			listGPA = gpDao.consultaGruposA();
			listGPB = gpDao.consultaGruposB();
			listGPC = gpDao.consultaGruposC();
			listGPD = gpDao.consultaGruposD();	
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			model.addAttribute("Grupos", gp);
			model.addAttribute("listGPA", listGPA);
			model.addAttribute("listGPB", listGPB);
			model.addAttribute("listGPC", listGPC);
			model.addAttribute("listGPD", listGPD);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		return new ModelAndView("gruposFormados");
	}
	
}
