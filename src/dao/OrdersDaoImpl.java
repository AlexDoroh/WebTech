package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Orders;
//import model.Room;

public class OrdersDaoImpl implements OrdersDao{

	@Override
	public List<Orders> listAllOrders() {
		List<Orders> list = new ArrayList<Orders>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `orders`";

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
	            list.add(new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
	        }
			
		} catch (Exception e) {
			System.out.println(e);
		}	
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
			try {
				if(st != null)
					st.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
			try {
				if(rs != null)
					rs.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
		
		return list;
	}

	@Override
	public void addOrders(Orders order) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "INSERT INTO `orders` (`cargo`, `cargo_weight`, `required_characteristics`)"
							+ " VALUES(?, "
							+ "?, "
							+ "?)";

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, order.getCargo());
			st.setString(2, order.getCargo_weight());
			st.setInt(3, order.getRequired_characteristics());
		
			st.executeUpdate();
						
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
			try {
				if(st != null)
					st.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
		
	}

	@Override
	public void updateOrders(Orders order) {
		Connection con = null;
		PreparedStatement st = null;
		try
		{
			String query = "UPDATE `orders` SET "
					+ "`cargo` = ?, "
					+ "`cargo_weight` = ?, "
					+ "`required_characteristics` = ? WHERE `id_orders` = ?";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, order.getCargo());
			st.setString(2, order.getCargo_weight());
			st.setInt(3, order.getRequired_characteristics());
			st.setInt(4, order.getId_Ordes());
			
			st.executeUpdate();
					
		} catch (Exception e) {
		System.out.println(e);
		}
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
			try {
				if(st != null)
					st.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
		
	}

	@Override
	public void deleteOrders(int id) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM `orders` WHERE `id_orders` = ?";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setInt(1, id);
			
			st.executeUpdate();
						
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
			try {
				if(st != null)
					st.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
		
	}

	@Override
	public Orders findOrdersById(int id) {
		Orders order = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `orders` WHERE `id_orders` = "+id;


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				order = new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
			try {
				if(st != null)
					st.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
			try {
				if(rs != null)
					rs.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
		
		return order;
	}

}
