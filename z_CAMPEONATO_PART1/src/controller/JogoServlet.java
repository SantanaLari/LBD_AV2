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
import persistence.IJogosDao;
import persistence.JogosDao;

@WebServlet("/jogosFormados")
public class JogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public JogoServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Jogos jg = new Jogos();
		
		GenericDao gDao = new GenericDao();
		IJogosDao jgDao = new JogosDao(gDao);
		List<Jogos> listJG = new ArrayList<Jogos>();
		
		try {
			if(botao.equals("Buscar")) {
				listJG = jgDao.consultaDatas();
			}if(botao.equals("Listar")) {
				listJG = jgDao.consultaJogos();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("jogos.jsp");
			request.setAttribute("jg", jg);
			request.setAttribute("listJG", listJG);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String saida = "";
		
		Jogos jg = new Jogos();
		
		GenericDao gDao = new GenericDao();
		IJogosDao jgDao = new JogosDao(gDao);
		List<Jogos> listJG = new ArrayList<Jogos>();
		
		try {
			listJG = jgDao.consultaJogos();
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("jogos.jsp");
			request.setAttribute("jg", jg);
			request.setAttribute("listJG", listJG);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
		
	}

}