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

import br.edu.fateczl.CampeonatoPaulista.model.ConsultaGrupo;
import br.edu.fateczl.CampeonatoPaulista.persistence.IPlacarDao;
import br.edu.fateczl.CampeonatoPaulista.persistence.PlacarDao;


public class PlacarController {

	@RequestMapping(name = "consultaGrupos", value = "/placar", method = RequestMethod.GET)
	public ModelAndView findConsulta(ModelMap model, @RequestParam Map<String, String> params ) {
		String botao = params.get("button");
		String erro = "";
		String saida = "";
		
		ConsultaGrupo gp = new ConsultaGrupo();

		IPlacarDao pDao = new PlacarDao();
		
		List<ConsultaGrupo> listaGrupoA = new ArrayList<ConsultaGrupo>();
		List<ConsultaGrupo> listaGrupoB = new ArrayList<ConsultaGrupo>();
		List<ConsultaGrupo> listaGrupoC = new ArrayList<ConsultaGrupo>();
		List<ConsultaGrupo> listaGrupoD = new ArrayList<ConsultaGrupo>();
		List<ConsultaGrupo> listaRebaixado = new ArrayList<ConsultaGrupo>();
		
		try {
			if(botao.equals("Consulta Grupos")) {
				listaGrupoA = pDao.consultaGrupo("A");
				listaGrupoB = pDao.consultaGrupo("B");
				listaGrupoC = pDao.consultaGrupo("C");
				listaGrupoD = pDao.consultaGrupo("D");
				listaRebaixado = pDao.grupoRebaixado();
			}
		}catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			model.addAttribute("gp", gp);
			model.addAttribute("listaGrupoA", listaGrupoA);
			model.addAttribute("listaGrupoB", listaGrupoB);
			model.addAttribute("listaGrupoC", listaGrupoC);
			model.addAttribute("listaGrupoD", listaGrupoD);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
			model.addAttribute("listaRebaixado", listaRebaixado);
		}
		return new ModelAndView("consultaGrupos");
	}

	@RequestMapping(name = "classificacao", value = "/placar", method = RequestMethod.POST)
	public ModelAndView findPlacar(ModelMap model, @RequestParam Map<String, String> params ) {
		String botao = params.get("button");
		String erro = "";
		String saida = "";
		
		ConsultaGrupo gp = new ConsultaGrupo();
		
		IPlacarDao pDao = new PlacarDao();
		List<ConsultaGrupo> listaGeral = new ArrayList<ConsultaGrupo>();
		List<ConsultaGrupo> listaRebaixado = new ArrayList<ConsultaGrupo>();
		
		try {
			if(botao.contains("Mostrar Classificacao")) {
				listaGeral = pDao.consultaClassificacao();
				listaRebaixado = pDao.grupoRebaixado();
			}
		}catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			model.addAttribute("gp", gp);
			model.addAttribute("listaGeral", listaGeral);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
			model.addAttribute("listaRebaixado", listaRebaixado);
		}
		return new ModelAndView("classificacao");
	}
	
}
