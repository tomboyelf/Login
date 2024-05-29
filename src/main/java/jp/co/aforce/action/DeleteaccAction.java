package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;


public class DeleteaccAction extends Action{
	public String execute(
				HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("delete_button"));
		
		CustomerDAO dao=new CustomerDAO();
		int line=dao.deleteAcc(id);
		if(line==1) {
			String msg="削除に成功";
			session.setAttribute("deleteMsg", msg);
			return "admin.jsp";
		}
		String msg="削除に失敗";
		session.setAttribute("deleteMsg", msg);
		return "admin.jsp";
	}
	
}