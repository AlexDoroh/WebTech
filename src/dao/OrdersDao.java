package dao;

import java.util.List;

import model.Orders;

public interface OrdersDao {
	public List<Orders> listAllOrders();
	public void addOrders(Orders order);
	public void updateOrders(Orders order); 
	public void deleteOrders(int id);
	public Orders findOrdersById(int id);
}
