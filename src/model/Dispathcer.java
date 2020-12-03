package model;

public class Dispathcer {

	private int id_Dispathcer;
    private String name;
    private int user;
    
    
	public int getId_Dispathcer() {
		return id_Dispathcer;
	}
	public void setId_Dispathcer(int id_Dispathcer) {
		this.id_Dispathcer = id_Dispathcer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	public Dispathcer(int id_Dispathcer, String name, int user) {
		super();
		this.id_Dispathcer = id_Dispathcer;
		this.name = name;
		this.user = user;
	}
	
	public Dispathcer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
}
