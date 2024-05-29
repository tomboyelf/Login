package jp.co.aforce.action;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;

public class SignupAction extends Action {
	public String execute(
				HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		
		String login=request.getParameter("login");
		String pass=request.getParameter("pass");
		
		CustomerDAO dao=new CustomerDAO();
		try {
			int line=dao.insert(login, pass);
			if(line==1) {
				return "signup-ok.jsp";
			} 
			String msg="登録に失敗しました。パスワードは4文字以上で入力してください。";
			request.setAttribute("msg", msg);
			return "signup.jsp";
		} catch(Exception e) {
//			request.getRequestDispatcher("/jsp/signup-ok.jsp").forward(request, response);
			String msg="登録に失敗しました。すでに同じユーザー名が存在します。";
			request.setAttribute("msg", msg);
			return "signup.jsp";
		}
	}

}
