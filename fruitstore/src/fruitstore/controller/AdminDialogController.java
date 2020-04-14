package fruitstore.controller;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import fruitstore.demain.*;
import fruitstore.service.*;
import fruitstore.view.*;
public class AdminDialogController extends AbstractAdminDialog {
	private AdminService adminService = new AdminService();
	public AdminDialogController() {
		super();
	}
	
	public AdminDialogController(Frame owner, boolean modal) {
		super(owner, modal);
		queryFrultItem();
	}
	
	@Override
	public void queryFrultItem() {
		// TODO Auto-generated method stub
		String[] thead = new String[] {"水果编号", "水果名称", "水果单价（/元）", "计价单位"};
		ArrayList<FruitItem> dataList = adminService.queryFruitItem();
		String[][] tbody = list2Array(dataList);
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}
	public String[][] list2Array(ArrayList<FruitItem> list){
		String[][] tbody = new String[list.size()][4];
		for(int i = 0; i < list.size(); i++) {
			FruitItem fruitItem = list.get(i);
			tbody[i][0] = fruitItem.getNumber();
			tbody[i][1] = fruitItem.getName();
			tbody[i][2] = fruitItem.getPrice() + "";
			tbody[i][3] = fruitItem.getUnit();
		}
		return tbody;
	}
	@Override
	public void addFrultItem() {
		// TODO Auto-generated method stub
		String addNumber = addNumberText.getText();
		String addName = addNameText.getText();
		String addPrice = addPriceText.getText();
		String addUnit = addUnitText.getText();
		Boolean addSuccess = adminService.addFruitItem(addNumber, addName, addPrice, addUnit);
		if(addSuccess) {
			queryFrultItem();
		}else {
			JOptionPane.showMessageDialog(this, "水果编号不能重复，请检查数据！");
		}
	}

	@Override
	public void updateFrultItem() {
		// TODO Auto-generated method stub
		String updateNumber = updateNumberText.getText();
		String updateName = updateNameText.getText();
		String updatePrice = updatePriceText.getText();
		String updateUnit = updateUnitText.getText();
		Boolean updateSuccess = adminService.updateFruitItem(updateNumber, updateName, updatePrice, updateUnit);
		if(updateSuccess) {
			queryFrultItem();
		}else {
			JOptionPane.showMessageDialog(this, "没有该编号的水果，请检查数据！");
		}
	}

	@Override
	public void delFrultItem() {
		// TODO Auto-generated method stub
		String delNumber = delNumberText.getText();
		Boolean delSuccess = adminService.delFruitItem(delNumber);
		if(delSuccess) {
			queryFrultItem();
		}else {
			JOptionPane.showMessageDialog(this, "没有该编号的水果，请检查数据！");
		}
	}
	
}
