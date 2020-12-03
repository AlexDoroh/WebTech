package model;

public class Trips {
  private int id_Trips;
  private String trip_from;
  private String trip_to;
  private int driver;
  private int order;
  private boolean trip_state;
  
  

public String getTrip_to() {
	return trip_to;
}
public void setTrip_to(String trip_to) {
	this.trip_to = trip_to;
}
public int getDriver() {
	return driver;
}
public void setDriver(int driver) {
	this.driver = driver;
}
public int getOrder() {
	return order;
}
public void setOrder(int order) {
	this.order = order;
}
public boolean isTrip_state() {
	return trip_state;
}
public void setTrip_state(boolean trip_state) {
	this.trip_state = trip_state;
}
public int getId_Trips() {
	return id_Trips;
}
public void setId_Trips(int id_Trips) {
	this.id_Trips = id_Trips;
}
public String getTrip_from() {
	return trip_from;
}
public void setTrip_from(String trip_from) {
	this.trip_from = trip_from;
}


public Trips(int id_Trips, String trip_from, String trip_to, int driver, int order, boolean trip_state) {
	super();
	this.id_Trips = id_Trips;
	this.trip_from = trip_from;
	this.trip_to = trip_to;
	this.driver = driver;
	this.order = order;
	this.trip_state = trip_state;
}

public Trips() {
	super();
	// TODO Auto-generated constructor stub
}
}
