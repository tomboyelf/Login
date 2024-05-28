package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.tool.Action;

//@WebServlet(urlPatterns = { "/logout" })
//public class LogoutAction extends HttpServlet {
//	public void doGet(
//			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		PrintWriter out=response.getWriter();
//		HttpSession session=request.getSession();
//
//		session.removeAttribute("customer");
////		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
//		response.sendRedirect("/Login/jsp/login.jsp");
//	}
//}

public class LogoutAction extends Action{
	public String execute(
				HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		HttpSession session=request.getSession();

		session.removeAttribute("customer");
//		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		return "login.jsp";
//		response.sendRedirect("/Login/jsp/login.jsp");
	}
	
}