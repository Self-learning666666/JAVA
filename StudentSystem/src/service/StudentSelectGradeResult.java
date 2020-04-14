package service;
/**
 * 已被合并在StudentSelectGrade中
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentSelectGradeResult extends JPanel implements ActionListener {
	
//	private JPanel centerPanel = new JPanel();
	private JScrollPane tablePane = new JScrollPane();
	protected JTable table = new JTable();
	
	public StudentSelectGradeResult() {
//		清空布局管理器并定位
		this.setLayout(null);
		
//		调用添加组件函数
		addComponent();
		queryStudentItem();
	}
	/**
	 * 添加组件函数
	 */
	private void addComponent() {
//		添加表格
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		table.setEnabled(false);
		tablePane.setBounds(50,50,680, 350);
		tablePane.setViewportView(table);
		this.add(tablePane);
	}
	
	
	/**
	 * 加入测试数据
	 */
	public void queryStudentItem() {
		String[] thead = new String[] {"课程号", "成绩"};
		String[][] tbody = new String[][] {
			{"12", "123"},
			{"21", "123"},
			{"12", "123"},
			{"11", "123"},
		};
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
