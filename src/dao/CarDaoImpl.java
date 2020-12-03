package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Car;
//import model.Room;

public class CarDaoImpl implements CarDao {

	@Override
	public List<Car> listAllCar() {
		List<Car> list = new ArrayList<Car>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `car`";
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
	            list.add(new Car(rs.getInt(1), rs.getString(2), rs.getInt(3)));
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
	public void addCar(Car car) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "INSERT INTO `car` (`readiness`, `characteristics`)"
							+ " VALUES(?, ?)";
			
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			 st = con.prepareStatement(query);
			 
			 st.setString(1, car.getReadiness());
			 st.setInt(2, car.getCharacteristics());
			 
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
	public void updateCar(Car car) {
		Connection con = null;
		PreparedStatement st = null;
		try
		{
			String query = "UPDATE `car` SET "
					+ "`readiness` = ?, "
					+ "`characteristics` = ? WHERE `id_car` = ?";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, car.getReadiness());
			st.setInt(2, car.getCharacteristics());
			st.setInt(3, car.getIdCar());
			
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
	public void deleteCar(int id) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM `car` WHERE `id_car` = ?";


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
	public Car findCarById(int id) {
		Car car = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `car` WHERE `id_car` = "+id;


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				car = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
		
		return car;
	}

}
