package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Roles;
//import model.Room;

public class RolesDaoImpl implements RolesDao{

	@Override
	public List<Roles> listAllRoles() {
		List<Roles> list = new ArrayList<Roles>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `roles`";

			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
	            list.add(new Roles(rs.getInt(1), rs.getString(2)));
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
	public void addRoles(Roles role) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "INSERT INTO `roles` (`name`)"
							+ " VALUES(?)";

			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, role.getName());
			
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
	public void updateRoles(Roles role) {
		Connection con = null;
		PreparedStatement st = null;
		try
		{
			String query = "UPDATE `roles` SET "
					+ "`name` = ? WHERE `id_roles` = ?";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, role.getName());
			st.setInt(2, role.getId_Roles());
			
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
	public void deleteRoles(int id) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM `roles` WHERE `id_roles` = ?";


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
	public Roles findRolesById(int id) {
		Roles role = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `roles` WHERE `id_roles` = "+id;


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				role = new Roles(rs.getInt(1), rs.getString(2));
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
		
		return role;
	}

}
