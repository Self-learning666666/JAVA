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
		String[] thead = new String[] {"ѧ��", "����", "����", "�Ա�","ѧԺ","����"};
		String[][] tbody = new String[][] {
			{"1", "tom", "123456", "��","��Ժ","�й�"},
			{"2", "tom", "123456", "��","��Ժ","�й�"},
			{"3", "tom", "123456", "��","��Ժ","�й�"},
			{"4", "tom", "123456", "��","��Ժ","�й�"},
			{"1", "tom", "123456", "��","��Ժ","�й�"},
			{"2", "tom", "123456", "��","��Ժ","�й�"},
			{"3", "tom", "123456", "��","��Ժ","�й�"},
			{"4", "tom", "123456", "��","��Ժ","�й�"},
			{"1", "tom", "123456", "��","��Ժ","�й�"},
			{"2", "tom", "123456", "��","��Ժ","�й�"},
			{"3", "tom", "123456", "��","��Ժ","�й�"},
			{"4", "tom", "123456", "��","��Ժ","�й�"},
			{"1", "tom", "123456", "��","��Ժ","�й�"},
			{"2", "tom", "123456", "��","��Ժ","�й�"},
			{"3", "tom", "123456", "��","��Ժ","�й�"},
			{"4", "tom", "123456", "��","��Ժ","�й�"},
			{"1", "tom", "123456", "��","��Ժ","�й�"},
			{"2", "tom", "123456", "��","��Ժ","�й�"},
			{"3", "tom", "123456", "��","��Ժ","�й�"},
			{"4", "tom", "123456", "��","��Ժ","�й�"},
			{"1", "tom", "123456", "��","��Ժ","�й�"},
			{"2", "tom", "123456", "��","��Ժ","�й�"},
			{"3", "tom", "123456", "��","��Ժ","�й�"},
			{"4", "tom", "123456", "��","��Ժ","�й�"},
			{"1", "tom", "123456", "��","��Ժ","�й�"},
			{"2", "tom", "123456", "��","��Ժ","�й�"},
			{"3", "tom", "123456", "��","��Ժ","�й�"},
			{"4", "tom", "123456", "��","��Ժ","�й�"},
			{"1", "tom", "123456", "��","��Ժ","�й�"},
			{"2", "tom", "123456", "��","��Ժ","�й�"},
			{"3", "tom", "123456", "��","��Ժ","�й�"},
			{"4", "tom", "123456", "��","��Ժ","�й�"},
		};
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
