package dao;

import java.util.List;

import model.Dispathcer;

public interface DispathcerDao {
	public List<Dispathcer> listAllDispathcers();
	public void addDispathcer(Dispathcer dispathcer);
	public void updateDispathcer(Dispathcer dispathcer); 
	public void deleteDispathcer(int id);
	public Dispathcer findDispathcerById(int id);
}
