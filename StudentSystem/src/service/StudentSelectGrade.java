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
//	����γ̺�����
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("ѧ �� :");
	private JTextField id = new JTextField(20);
//	������Ӱ�ť
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("�� ѯ");	
	
	public StudentSelectGrade() {
//		��ղ��ֹ���������λ
		this.setLayout(null);
		centerPanel.setBounds(150,0,400, 80);
//		��������������
		addComponent();
		
		queryStudentItem();

	}
	/**
	 * ����������
	 */
	private void addComponent() {
//		���ѧ��
		IDPanel.add(IDLabel);
		IDLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		IDPanel.add(id);
		centerPanel.add(IDPanel);		
//		��Ӱ�ť
		btnPanel.add(Btn);
		Btn.setFont(new Font("���ķ���", Font.BOLD, 20));
		centerPanel.add(btnPanel);
		this.add(centerPanel);
//		��ӱ��
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setEnabled(false);
		tablePane.setBounds(50,80,680, 350);
		tablePane.setViewportView(table);
		this.add(tablePane);
	}
	/**
	 * �����������
	 */
	public void queryStudentItem() {
		String[] thead = new String[] {"�γ̺�", "�ɼ�"};
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
