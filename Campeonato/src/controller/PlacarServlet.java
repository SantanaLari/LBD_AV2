package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ConsultaGrupo;
import persistence.GenericDao;
import persistence.IPlacarDao;
import persistence.PlacarDao;

@WebServlet("/placar")
public class PlacarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlacarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String saida = "";
		String botao = request.getParameter("botao");
		
		ConsultaGrupo gp = new ConsultaGrupo();
		GenericDao gDao = new GenericDao();

		IPlacarDao pDao = new PlacarDao(gDao);
		
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
			RequestDispatcher rd = request.getRequestDispatcher("consultaGrupos.jsp");
			request.setAttribute("gp", gp);
			request.setAttribute("listaGrupoA", listaGrupoA);
			request.setAttribute("listaGrupoB", listaGrupoB);
			request.setAttribute("listaGrupoC", listaGrupoC);
			request.setAttribute("listaGrupoD", listaGrupoD);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			request.setAttribute("listaRebaixado", listaRebaixado);
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String saida = "";
		String botao = request.getParameter("botao");
		
		ConsultaGrupo gp = new ConsultaGrupo();
		
		GenericDao gDao = new GenericDao();

		IPlacarDao pDao = new PlacarDao(gDao);
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
			RequestDispatcher rd = request.getRequestDispatcher("classificacao.jsp");
			request.setAttribute("gp", gp);
			request.setAttribute("listaGeral", listaGeral);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			request.setAttribute("listaRebaixado", listaRebaixado);
			rd.forward(request, response);
		}
		
	}

}
