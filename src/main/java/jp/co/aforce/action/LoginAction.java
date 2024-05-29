package jp.co.aforce.action;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;

public class LoginAction extends Action{
	public String execute(
				HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		
		String login=request.getParameter("login");
		String pass=request.getParameter("pass");
		
		CustomerDAO dao=new CustomerDAO();
			Customer customer=dao.search(login, pass);
			if(customer==null) {
				String msg="IDもしくはパスワードが違います。";
				session.setAttribute("msg", msg);
				session.setAttribute("login", login);
				return "index.jsp";
			}
			session.setAttribute("customer", customer);
			return "login-out.jsp";
	}
	
}
