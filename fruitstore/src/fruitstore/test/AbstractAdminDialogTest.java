package fruitstore.test;
import javax.swing.table.*;
import fruitstore.view.AbstractAdminDialog;
public class AbstractAdminDialogTest extends AbstractAdminDialog {
	public AbstractAdminDialogTest() {
		super();
		queryFruitItem();
	}
	
	public void queryFruitItem() {
		String[] thead = new String[] {"ˮ�����", "ˮ������", "ˮ�����ۣ�/Ԫ��", "�Ƽ۵�λ"};
		String[][] tbody = new String[][] {
			{"1", "ƻ��", "5.0", "KG"},
			{"2", "����", "3.2", "��"},
			{"3", "ѩ��", "3.8", "��"},
			{"4", "̩��������", "120", "��"},
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
