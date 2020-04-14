package fruitstore.data;
import java.util.ArrayList;
import fruitstore.demain.*;
public class DataBase {
	public static ArrayList<FruitItem> data = new ArrayList<FruitItem>();
	static {
		data.add(new FruitItem("1", "Æ»¹û", 5.0, "kg"));
	}
}
