package web_study_03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/researchServlet")
public class researchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	private void requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender").equals("male") ? "남자" : "여자";
		
		String seasonArr[] = request.getParameterValues("season");
		String seasonName[] = new String[] {"봄", "여름", "가을", "겨울"};
		
		String seasonRes = "당신이 좋아하는 계절은 ";
		
		if (seasonArr == null) {
			seasonRes = "없습니다.";
		} else {
			seasonRes += "<b>";
			for(int i = 0; i < seasonArr.length; i++) {
				int res = Integer.parseInt(seasonArr[i]);
				seasonRes += seasonName[res-1];
				if(i != seasonArr.length-1 ) {
					seasonRes += ", ";
				}
			}
			seasonRes += "</b>입니다.";
		}
				
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("seasonRes", seasonRes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("researchResult.jsp");
		dispatcher.forward(request, response);
	}

}
