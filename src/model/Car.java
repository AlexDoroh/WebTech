package model;

public class Car {


	private int idCar;
	private String readiness;
	private int characteristics;
	
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int id_Car) {
		this.idCar = id_Car;
	}
	public String getReadiness() {
		return readiness;
	}
	public void setReadiness(String readiness) {
		this.readiness = readiness;
	}
	public int getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(int characteristics) {
		this.characteristics = characteristics;
	}
	
	public Car(int id_Car, String readiness, int characteristics) {
		super();
		this.idCar = id_Car;
		this.readiness = readiness;
		this.characteristics = characteristics;
	}
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
