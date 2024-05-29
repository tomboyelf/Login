package jp.co.aforce.action;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.aforce.beans.Product;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;


public class ProductAction extends Action{
	public String execute(
				HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		ProductDAO dao=new ProductDAO();
		List<Product> list = new ArrayList<>();
		String keyword=request.getParameter("keyword");
		if(keyword==null) {
			list=dao.showAll();
			request.setAttribute("list", list);
			return "product/product.jsp";
		}
		list=dao.search(keyword);
		request.setAttribute("list", list);
		return "product/product.jsp";
	}
	
}