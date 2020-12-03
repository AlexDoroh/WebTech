package dao;

import java.util.List;

import java.util.ArrayList;
import java.sql.*;
import model.Trips;
import model.User;


public class TripsDaoImpl implements TripsDao {

	@Override
	public List<Trips> listAllTrips() {
		List<Trips> list = new ArrayList<Trips>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `trips`";
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
	            list.add(new Trips(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6)));
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
	public void addTrips(Trips trips) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "INSERT INTO `trips` (`trip_from`, `trip_to`, `driver`, `order`, `trip_state`)"
							+ " VALUES(?, "
							+ "?, "
							+ "?, "
							+ "?, "
							+ "?)";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, trips.getTrip_from());
			st.setString(2, trips.getTrip_to());
			st.setInt(3, trips.getDriver());
			st.setInt(4, trips.getOrder());
			st.setBoolean(5, trips.isTrip_state());
			
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
	public void updateTrips(Trips trips) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "UPDATE `trips` SET "						
							+ "`trip_from` = ?, "
							+ "`trip_to` = ?, "
							+ "`driver` = ?, "
							+ "`order` = ?, "
							+ "`trip_state` = ? WHERE `id_trips` = ?";


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.prepareStatement(query);
			 
			st.setString(1, trips.getTrip_from());
			st.setString(2, trips.getTrip_to());
			st.setInt(3, trips.getDriver());
			st.setInt(4, trips.getOrder());
			st.setBoolean(5, trips.isTrip_state());
			st.setInt(6, trips.getId_Trips());
			
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
	public void deleteTrips(int id) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM `trips` WHERE `id_trips` = ?";


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
	public Trips findTripsById(int id) {
		Trips trips = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `trips` WHERE `id_trips` = "+id;


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autobase?serverTimezone=UTC","root","root");
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				trips = new Trips(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
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
		
		return trips;
	}

}
