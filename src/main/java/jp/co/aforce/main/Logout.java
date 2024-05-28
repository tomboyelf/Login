package jp.co.aforce.main;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/logout" })
public class Logout extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();

		session.removeAttribute("customer");
//		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		response.sendRedirect("/Login/jsp/login.jsp");
	}
}
