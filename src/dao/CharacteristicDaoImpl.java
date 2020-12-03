package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Characteristic;
import model.User;

public class CharacteristicDaoImpl implements  CharacteristicDao {
	
	@Override
	public List<Characteristic> listAllCharacteristics() {
		List<Characteristic> list = new ArrayList<Characteristic>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `characteristics`";

			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
	            list.add(new Characteristic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7), rs.getString(8)));
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
	public void addCharacteristic(Characteristic characteristics) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "INSERT INTO `characteristics` (`mark`, `model`, `length`, `width`, `height`, `fuel_consumption`, `engine`)"
							+ " VALUES(?, "
							+ "?, "
							+ "?, "
							+ "?, "
							+ "?, "
							+ "?, "
							+ "?)";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, characteristics.getMark());
			st.setString(2, characteristics.getModel());
			st.setFloat(3, characteristics.getLegth());
			st.setFloat(4, characteristics.getWidth());
			st.setFloat(5, characteristics.getHeight());
			st.setInt(6, characteristics.getFuel_consumption());
			st.setString(7, characteristics.getEngine());
			
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
	public void updateCharacteristic(Characteristic characteristics) {
		Connection con = null;
		PreparedStatement st = null;
		try
		{
			String query = "UPDATE `characteristics` SET "
					+ "`mark` = ?, "
					+ "`model` = ?, "
					+ "`length` = ?, "
					+ "`width` = ?, "
					+ "`height` = ?, "
					+ "`fuel_consumption` = ?, "
					+ "`engine` = ? WHERE `id_characteristic` = ?";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, characteristics.getMark());
			st.setString(2, characteristics.getModel());
			st.setFloat(3, characteristics.getLegth());
			st.setFloat(4, characteristics.getWidth());
			st.setFloat(5, characteristics.getHeight());
			st.setInt(6, characteristics.getFuel_consumption());
			st.setString(7, characteristics.getEngine());
			st.setInt(8, characteristics.getId_Characteristic());
			
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
	public void deleteCharacteristic(int id) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM `characteristics` WHERE `id_characteristic` = ?";


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
	public Characteristic findCharacteristicById(int id) {
		Characteristic characteristic = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `characteristics` WHERE `id_characteristic` = "+id;


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				characteristic = new Characteristic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7), rs.getString(8));
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
		
		return characteristic;
	}


}
