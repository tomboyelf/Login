package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Customer;

public class CustomerDAO extends DAO {

	public Customer search(String login, String password) throws Exception {

		Customer customer = null;

		Connection con = getConnection();

		PreparedStatement st;
		//		?はプレースホルダ
		st = con.prepareStatement(
				"select * from login where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		//		List<Customer>型へ変換
		while (rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();

		return customer;
	}

	public int insert(String login, String password) throws Exception {
		if (password.length() < 4) {
			int line = 2;
			return line;
		}

		Connection con = getConnection();
		PreparedStatement st;

		//		st=con.prepareStatement(
		//				"select login from login where login=?");
		//		st.setString(1, login);
		//		ResultSet rs=st.executeQuery();
		//		if(rs.next()) {
		//			int line=2;
		//			return line;
		//		} else {	
		st = con.prepareStatement(
				"insert into login values(null, ?, ?)");
		st.setString(1, login);
		st.setString(2, password);
		int line = st.executeUpdate();
		st.close();
		con.close();
		return line;
	}

	public List<Customer> showAll() throws Exception {
		List<Customer> allList = new ArrayList();
		Connection con = getConnection();
		PreparedStatement st;

		st = con.prepareStatement(
				"select * from login");

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Customer customer = new Customer(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
			allList.add(customer);
		}

		st.close();
		con.close();

		return allList;
	}

	public int deleteAcc(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st;

		st = con.prepareStatement(
				"delete from login where id=?");
		st.setInt(1, id);
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}
