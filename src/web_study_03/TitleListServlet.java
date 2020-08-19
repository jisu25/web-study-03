package web_study_03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc_programming.dao.TitleDao;
import jdbc_programming.dao.impl.TitleDaoImpl;
import jdbc_programming.dto.Title;


@WebServlet("/TitleListServlet")
public class TitleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleDao dao;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao = TitleDaoImpl.getInstance();
		
		for(Title t : dao.selectTitleByAll()) {
			System.out.println(t);
		}
	}

}
