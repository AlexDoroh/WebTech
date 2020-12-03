package dao;

import java.util.List;
import model.Characteristic;

public interface CharacteristicDao {
	public List<Characteristic> listAllCharacteristics();
	public void addCharacteristic(Characteristic characteristic);
	public void updateCharacteristic(Characteristic characteristic); 
	public void deleteCharacteristic(int id);
	public Characteristic findCharacteristicById(int id);
}
