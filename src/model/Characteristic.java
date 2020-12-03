package model;


public class Characteristic {

	private int id_Characteristic;
	private String mark;
	private String model;
	private float legth;
	private float width;
	private float height;
	private int fuel_consumption;
	private String engine;
	
	public int getId_Characteristic() {
		return id_Characteristic;
	}
	public void setId_Characteristic(int id_Characteristic) {
		this.id_Characteristic = id_Characteristic;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public float getLegth() {
		return legth;
	}
	public void setLegth(float legth) {
		this.legth = legth;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public int getFuel_consumption() {
		return fuel_consumption;
	}
	public void setFuel_consumption(int fuel_consumption) {
		this.fuel_consumption = fuel_consumption;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	public Characteristic(int id_Characteristic, String mark, String model, float legth, float width, float height, int fuel_consumption, String engine) {
		super();
		this.id_Characteristic = id_Characteristic;
		this.mark = mark;
		this.model = model;
		this.legth = legth;
		this.width = width;
		this.height = height;
		this.fuel_consumption = fuel_consumption;
		this.engine = engine;

	}
	
	public Characteristic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
