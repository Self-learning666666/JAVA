package service;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentSelectGrade extends JPanel implements ActionListener {
	
	private JPanel centerPanel = new JPanel();
	private JScrollPane tablePane = new JScrollPane();
	protected JTable table = new JTable();
//	定义课程号容器
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("学 号 :");
	private JTextField id = new JTextField(20);
//	定义添加按钮
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("查 询");	
	
	public StudentSelectGrade() {
//		清空布局管理器并定位
		this.setLayout(null);
		centerPanel.setBounds(150,0,400, 80);
//		调用添加组件函数
		addComponent();
		
		queryStudentItem();

	}
	/**
	 * 添加组件函数
	 */
	private void addComponent() {
//		添加学号
		IDPanel.add(IDLabel);
		IDLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		IDPanel.add(id);
		centerPanel.add(IDPanel);		
//		添加按钮
		btnPanel.add(Btn);
		Btn.setFont(new Font("华文仿宋", Font.BOLD, 20));
		centerPanel.add(btnPanel);
		this.add(centerPanel);
//		添加表格
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setEnabled(false);
		tablePane.setBounds(50,80,680, 350);
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
