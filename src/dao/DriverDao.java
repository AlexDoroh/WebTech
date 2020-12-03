package dao;

import java.util.List;

import model.Driver;

public interface DriverDao {
	public List<Driver> listAllDrivers();
	public void addDriver(Driver driver);
	public void updateDriver(Driver driver); 
	public void deleteDriver(int id);
	public Driver findDriverById(int id);
}
