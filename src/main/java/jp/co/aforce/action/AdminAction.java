package jp.co.aforce.action;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;


public class AdminAction extends Action{
	public String execute(
				HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		HttpSession session=request.getSession();
		
		CustomerDAO dao=new CustomerDAO();
		List<Customer> allList=new ArrayList();
		allList=dao.showAll();
		session.setAttribute("allList", allList);
		return "admin.jsp";
	}
	
}