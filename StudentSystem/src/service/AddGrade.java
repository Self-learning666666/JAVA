package service;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddGrade extends JPanel implements ActionListener {
	
	private JPanel centerPanel = new JPanel();
	
//	����γ̺�����
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("ѧ   �� :");
	private JTextField Sid = new JTextField(20);
//	����γ�������
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("�γ̺�:");
	private JTextField Cid = new JTextField(20);
//	�����ʦID����
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("��  �� :");
	private JTextField grade = new JTextField(20);
//	������Ӱ�ť
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("�� ��");	
	
	public AddGrade() {
//		��ղ��ֹ���������λ
		this.setLayout(null);
		centerPanel.setBounds(240,50,300, 600);
//		��������������
		addComponent();

	}
	/**
	 * ����������
	 */
	private void addComponent() {
//		���ѧ��
		IDPanel.add(IDLabel);
		IDLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		IDPanel.add(Sid);
		centerPanel.add(IDPanel);		
//		�������
		namePanel.add(nameLabel);
		nameLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		namePanel.add(Cid);
		centerPanel.add(namePanel);
//		�������
		passwdPanel.add(passwdLabel);
		passwdLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		passwdPanel.add(grade);
		centerPanel.add(passwdPanel);
//		��Ӱ�ť
		btnPanel.add(Btn);
		Btn.setFont(new Font("���ķ���", Font.BOLD, 20));
		centerPanel.add(btnPanel);

		this.add(centerPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
