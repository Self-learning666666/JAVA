package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SelectCourse extends JPanel implements ActionListener {
	
//	private JPanel centerPanel = new JPanel();
	private JScrollPane tablePane = new JScrollPane();
	protected JTable table = new JTable();
	
	public SelectCourse() {
//		��ղ��ֹ���������λ
		this.setLayout(null);
		
//		��������������
		addComponent();
		queryStudentItem();
	}
	/**
	 * ����������
	 */
	private void addComponent() {
//		��ӱ��
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		table.setEnabled(false);
		tablePane.setBounds(50,50,680, 350);
		tablePane.setViewportView(table);
		this.add(tablePane);
	}
	
	
	/**
	 * �����������
	 */
	public void queryStudentItem() {
		String[] thead = new String[] {"�γ̺�", "�γ���", "��ʦID","�γ̼��"};
		String[][] tbody = new String[][] {
			{"1", "JAVA", "123456","aaaaaaaa"},
			{"2", "JAVA", "123456","aaaaaaaa"},
			{"3", "JAVA", "123456","aaaaaaaa"},
			{"4", "JAVA", "123456","aaaaaaaa"},
		};
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}

}

