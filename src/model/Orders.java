package model;

public class Orders {
	
	private int id_Ordes;
	  private String cargo;
	  private String cargo_weight;
	  private int required_characteristics;
	  
 public int getId_Ordes() {
		return id_Ordes;
	}

	public void setId_Ordes(int id_Ordes) {
		this.id_Ordes = id_Ordes;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargo_weight() {
		return cargo_weight;
	}

	public void setCargo_weight(String cargo_weight) {
		this.cargo_weight = cargo_weight;
	}

	public int getRequired_characteristics() {
		return required_characteristics;
	}

	public void setRequired_characteristics(int required_characteristics) {
		this.required_characteristics = required_characteristics;
	}


  
  public Orders(int id_Ordes, String cargo, String cargo_weight, int required_characteristics) {
		super();
		this.id_Ordes = id_Ordes;
		this.cargo = cargo;
		this.cargo_weight = cargo_weight;
		this.required_characteristics = required_characteristics;
	}
  
  public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
}
