package dao;

import java.util.List;

import model.Car;

public interface CarDao {
	public List<Car> listAllCar();
	public void addCar(Car car);
	public void updateCar(Car car); 
	public void deleteCar(int id);
	public Car findCarById(int id);

}
