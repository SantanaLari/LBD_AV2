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
import persistence.GenericDao;
import persistence.IQuartasDao;
import persistence.QuartasDao;

@WebServlet("/quartas")
public class QuartasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuartasServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Grupos gp = new Grupos();
		
		GenericDao gDao = new GenericDao();
		IQuartasDao qDao = new QuartasDao(gDao);
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
			RequestDispatcher rd = request.getRequestDispatcher("quartas.jsp");
			request.setAttribute("Grupos", gp);
			request.setAttribute("listGA", listGA);
			request.setAttribute("listGB", listGB);
			request.setAttribute("listGC", listGC);
			request.setAttribute("listGD", listGD);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

}
