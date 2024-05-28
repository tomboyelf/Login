package jp.co.aforce.main;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;

@WebServlet(urlPatterns = { "/login" })
public class Login extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		String login=request.getParameter("login");
		String pass=request.getParameter("pass");
		
		CustomerDAO dao=new CustomerDAO();
		try {
			Customer customer=dao.search(login, pass);
			if(customer==null) {
				String msg="IDもしくはパスワードが違います";
				session.setAttribute("msg", msg);
				session.setAttribute("login", login);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
//				response.sendRedirect("/Login/jsp/login.jsp");
			}
			session.setAttribute("customer", customer);
			request.getRequestDispatcher("/jsp/login-out.jsp").forward(request, response);
//			response.sendRedirect("/Login/jsp/login-out.jsp");
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
