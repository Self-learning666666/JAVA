package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SelectGrade extends JPanel implements ActionListener {
	
//	private JPanel centerPanel = new JPanel();
	private JScrollPane tablePane = new JScrollPane();
	protected JTable table = new JTable();
	
	public SelectGrade() {
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
		String[] thead = new String[] {"ѧ��", "�γ̺�", "�ɼ�"};
		String[][] tbody = new String[][] {
			{"1", "12", "123"},
			{"2", "21", "123"},
			{"3", "12", "123"},
			{"4", "11", "123"},
		};
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
