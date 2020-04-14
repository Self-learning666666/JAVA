package service;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class SelectStudent extends JPanel implements ActionListener {
	
//	private JPanel centerPanel = new JPanel();
	private JScrollPane tablePane = new JScrollPane();
	protected JTable table = new JTable();
	
	public SelectStudent() {
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
		String[] thead = new String[] {"学号", "姓名", "密码", "性别","学院","籍贯"};
		String[][] tbody = new String[][] {
			{"1", "tom", "123456", "男","记院","中国"},
			{"2", "tom", "123456", "男","记院","中国"},
			{"3", "tom", "123456", "男","记院","中国"},
			{"4", "tom", "123456", "男","记院","中国"},
			{"1", "tom", "123456", "男","记院","中国"},
			{"2", "tom", "123456", "男","记院","中国"},
			{"3", "tom", "123456", "男","记院","中国"},
			{"4", "tom", "123456", "男","记院","中国"},
			{"1", "tom", "123456", "男","记院","中国"},
			{"2", "tom", "123456", "男","记院","中国"},
			{"3", "tom", "123456", "男","记院","中国"},
			{"4", "tom", "123456", "男","记院","中国"},
			{"1", "tom", "123456", "男","记院","中国"},
			{"2", "tom", "123456", "男","记院","中国"},
			{"3", "tom", "123456", "男","记院","中国"},
			{"4", "tom", "123456", "男","记院","中国"},
			{"1", "tom", "123456", "男","记院","中国"},
			{"2", "tom", "123456", "男","记院","中国"},
			{"3", "tom", "123456", "男","记院","中国"},
			{"4", "tom", "123456", "男","记院","中国"},
			{"1", "tom", "123456", "男","记院","中国"},
			{"2", "tom", "123456", "男","记院","中国"},
			{"3", "tom", "123456", "男","记院","中国"},
			{"4", "tom", "123456", "男","记院","中国"},
			{"1", "tom", "123456", "男","记院","中国"},
			{"2", "tom", "123456", "男","记院","中国"},
			{"3", "tom", "123456", "男","记院","中国"},
			{"4", "tom", "123456", "男","记院","中国"},
			{"1", "tom", "123456", "男","记院","中国"},
			{"2", "tom", "123456", "男","记院","中国"},
			{"3", "tom", "123456", "男","记院","中国"},
			{"4", "tom", "123456", "男","记院","中国"},
		};
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
