package fruitstore.dao;
import java.util.ArrayList;
import fruitstore.data.DataBase;
import fruitstore.demain.FruitItem;
public class AdminDao {
	
	public ArrayList<FruitItem> queryAllData(){
		return DataBase.data;
	}
	
	public void addFruitItem(FruitItem fruitItem) {
		DataBase.data.add(fruitItem);
	}
	
	public void delFruitItem(String delNumber) {
		for(int i = 0; i < DataBase.data.size(); i++) {
			FruitItem thisFruitItem = DataBase.data.get(i);
			if(thisFruitItem.getNumber().equals(delNumber)) {
				DataBase.data.remove(i);
			}
		}
	}

}
