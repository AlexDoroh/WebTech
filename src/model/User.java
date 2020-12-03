package model;


public class User {

    private int id_User;
    private String login;
    private String password;
    private int role;

    public int getId_User() {
		return id_User;
	}
    
	public void setId_User(int id_User) {
		this.id_User = id_User;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}




	public User(int id_User,  String login, String password, int role) {
		super();
		this.id_User = id_User;
		this.login = login;
		this.password = password;
		this.role = role;
	}


	public User() {
		super();
	}




}