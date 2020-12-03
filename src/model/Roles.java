package model;

public class Roles {

	private int id_Roles;
    private String name;
    
    
	public int getId_Roles() {
		return id_Roles;
	}
	public void setId_Roles(int id_Roles) {
		this.id_Roles = id_Roles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(int id_Roles, String name) {
		super();
		this.id_Roles = id_Roles;
		this.name = name;
	}
    
    
	
}
