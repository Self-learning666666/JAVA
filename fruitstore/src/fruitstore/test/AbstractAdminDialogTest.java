package fruitstore.test;
import javax.swing.table.*;
import fruitstore.view.AbstractAdminDialog;
public class AbstractAdminDialogTest extends AbstractAdminDialog {
	public AbstractAdminDialogTest() {
		super();
		queryFruitItem();
	}
	
	public void queryFruitItem() {
		String[] thead = new String[] {"水果编号", "水果名称", "水果单价（/元）", "计价单位"};
		String[][] tbody = new String[][] {
			{"1", "苹果", "5.0", "KG"},
			{"2", "葡萄", "3.2", "斤"},
			{"3", "雪梨", "3.8", "斤"},
			{"4", "泰国大榴莲", "120", "个"},
		};
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}
	public void queryFrultItem() {};
	public void addFrultItem() {};
	public void updateFrultItem() {};
	public void delFrultItem() {};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AbstractAdminDialogTest().setVisible(true);
	}

}
