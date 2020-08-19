package web_study_03;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String inputId = request.getParameter("id");
		String inputPwd = request.getParameter("pwd");
		
		String id = "js25";
		String pwd = "parkg25";
		String name = "박지성";
		
		request.setAttribute("name", name);
		
		if(id.equals(inputId) && pwd.equals(inputPwd)) {
			response.sendRedirect("04_main.jsp?name="+URLEncoder.encode(name, "UTF-8"));
		} else {
			response.sendRedirect("04_loginForm.jsp");
		}
		
		
	}

}
