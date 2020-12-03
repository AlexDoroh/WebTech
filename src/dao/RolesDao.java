package dao;

import java.util.List;

import model.Roles;

public interface RolesDao {
	public List<Roles> listAllRoles();
	public void addRoles(Roles role);
	public void updateRoles(Roles role); 
	public void deleteRoles(int id);
	public Roles findRolesById(int id);
}
