package model;

public class Driver {

	private int id_Driver;
    private String name;
    private int car;
    private int user;
    
	public int getId_Driver() {
		return id_Driver;
	}
	public void setId_Driver(int id_Driver) {
		this.id_Driver = id_Driver;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	public Driver(int id_Driver, String name, int car, int user) {
		super();
		this.id_Driver = id_Driver;
		this.name = name;
		this.car = car;
		this.user= user;
	}
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
}
