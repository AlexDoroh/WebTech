package dao;

import java.util.List;

import model.Trips;


public interface TripsDao {
	
	public List<Trips> listAllTrips();
	public void addTrips(Trips trips);
	public void updateTrips(Trips trips); 
	public void deleteTrips(int id);
	public Trips findTripsById(int id);

}
