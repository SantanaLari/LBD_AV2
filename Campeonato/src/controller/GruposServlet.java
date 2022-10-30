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

import model.Grupos;
import model.Times;
import persistence.GenericDao;
import persistence.GrupoDao;
import persistence.IGrupoDao;

@WebServlet("/grupos")
public class GruposServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GruposServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Grupos gp = new Grupos();
		Times tm = new Times();
		
		GenericDao gDao = new GenericDao();
		IGrupoDao gpDao = new GrupoDao(gDao);
		List<Grupos> listGPA = new ArrayList<Grupos>();
		List<Grupos> listGPB = new ArrayList<Grupos>();
		List<Grupos> listGPC = new ArrayList<Grupos>();
		List<Grupos> listGPD = new ArrayList<Grupos>();
		
		
		try {
			if(botao.contains("Criar Grupo")) {
				saida = gpDao.criarGrupos();
				gp = new Grupos();
			}if(botao.contains("Exibir Grupo")) {
				listGPA = gpDao.consultaGruposA();
				listGPB = gpDao.consultaGruposB();
				listGPC = gpDao.consultaGruposC();
				listGPD = gpDao.consultaGruposD();
				saida = gpDao.criarGrupos();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("Grupos", gp);
			request.setAttribute("listGPA", listGPA);
			request.setAttribute("listGPB", listGPB);
			request.setAttribute("listGPC", listGPC);
			request.setAttribute("listGPD", listGPD);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	
	}

}

