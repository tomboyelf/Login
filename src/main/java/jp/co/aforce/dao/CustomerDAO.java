package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Customer;

public class CustomerDAO extends DAO {

	
	public Customer search(String login, String password) throws Exception{
		
		Customer customer=null;
		
		Connection con=getConnection();
		
		PreparedStatement st;
//		?はプレースホルダ
		st=con.prepareStatement(
				"select * from login where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
//		List<Product>型へ変換
		while(rs.next()) {
			customer=new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		
		return customer;
	}
	
	public int insert(String login, String password) throws Exception{
		if(password.length()<4) {
			int line=0;
			return line;
		}
		
		Connection con=getConnection();
		PreparedStatement st;
		
		st=con.prepareStatement(
				"insert into login values(null, ?, ?)");
		st.setString(1, login);
		st.setString(2, password);
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
				
	}
}
