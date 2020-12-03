package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Dispathcer;
import model.User;

public class DispathcerDaoImpl implements DispathcerDao {

	@Override
	public List<Dispathcer> listAllDispathcers() {
		List<Dispathcer> list = new ArrayList<Dispathcer>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `dispathcer`";

			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
	            list.add(new Dispathcer(rs.getInt(1), rs.getString(2), rs.getInt(3)));
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
	public void addDispathcer(Dispathcer dispathcer) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "INSERT INTO `dispathcer` (`name`, `user`)"
							+ " VALUES(?, "
							+ "?)";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, dispathcer.getName());
			st.setInt(2, dispathcer.getUser());
			
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
	public void updateDispathcer(Dispathcer dispathcer) {
		Connection con = null;
		PreparedStatement st = null;
		try
		{
			String query = "UPDATE `dispathcer` SET "
					+ "`name` = ?, "
					+ "`user` = ? WHERE `id_dispathcer` = ?";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, dispathcer.getName());
			st.setInt(2, dispathcer.getUser());
			st.setInt(3, dispathcer.getId_Dispathcer());
			
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
	public void deleteDispathcer(int id) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM `dispathcer` WHERE `id_dispathcer` = ?";


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
	public Dispathcer findDispathcerById(int id) {
		Dispathcer dispathcer = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `dispathcer` WHERE `id_dispathcer` = "+id;


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				dispathcer = new Dispathcer(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
		
		return dispathcer;
	}

}
