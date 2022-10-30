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

import model.Jogos;
import persistence.GenericDao;
import persistence.IResultadosDao;
import persistence.ResultadosDao;

@WebServlet("/resultados")
public class ResultadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResultadosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		String nomeTimeA = "";
		String nomeTimeB = "";
		String data = "";
		int golsTimeA = 0;
		int golsTimeB = 0;
		
		Jogos j = new Jogos();

		
		GenericDao gDao = new GenericDao();
		IResultadosDao rDao = new ResultadosDao(gDao);
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		try {
			if(botao.contains("Inserir Resultado")) {
				data = request.getParameter("Data");
				nomeTimeA = request.getParameter("TimeA");
				nomeTimeB = request.getParameter("TimeB");
				golsTimeA = Integer.parseInt(request.getParameter("golsA"));
				golsTimeB = Integer.parseInt(request.getParameter("golsB"));
				saida = rDao.insereResultados(nomeTimeA, nomeTimeB, golsTimeA, golsTimeB);
			}
			if(botao.contains("Listar Resultados")) {
				jogos = rDao.consultaResultados();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("resultados.jsp");
			request.setAttribute("jogo", j);
			request.setAttribute("jogos", jogos);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		String nomeTimeA = "";
		String nomeTimeB = "";
	//	String data = "";
		int golsTimeA = 0;
		int golsTimeB = 0;
		
		Jogos j = new Jogos();

		
		GenericDao gDao = new GenericDao();
		IResultadosDao rDao = new ResultadosDao(gDao);
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		try {
			if(botao.contains("Inserir Resultado")) {
	//			data = request.getParameter("data");
				nomeTimeA = request.getParameter("timeA");
				nomeTimeB = request.getParameter("timeB");
				golsTimeA = Integer.parseInt(request.getParameter("golsA"));
				golsTimeB = Integer.parseInt(request.getParameter("golsB"));
				saida = rDao.insereResultados(nomeTimeA, nomeTimeB, golsTimeA, golsTimeB);
			}
			if(botao.contains("Listar Resultados")) {
				jogos = rDao.consultaResultados();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("resultados.jsp");
			request.setAttribute("jogo", j);
			request.setAttribute("jogos", jogos);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
		
	}

}

