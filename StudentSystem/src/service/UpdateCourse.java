package service;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateCourse extends JPanel implements ActionListener {
	
	private JPanel centerPanel = new JPanel();
	
//	����γ̺�����
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("�γ̺� :");
	private JTextField id = new JTextField(20);
//	����γ�������
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("�γ��� :");
	private JTextField name = new JTextField(20);
//	�����ʦID����
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("��ʦID :");
	private JTextField Tid = new JTextField(20);
///	����γ̼������
	private JPanel collagePanel = new JPanel();
	private Label collageLabel = new Label("��  ��  :");
	private JTextField info = new JTextField(20);
//	������Ӱ�ť
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("�� ��");	
	
	public UpdateCourse() {
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
		IDPanel.add(id);
		centerPanel.add(IDPanel);		
//		�������
		namePanel.add(nameLabel);
		nameLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		namePanel.add(name);
		centerPanel.add(namePanel);
//		�������
		passwdPanel.add(passwdLabel);
		passwdLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		passwdPanel.add(Tid);
		centerPanel.add(passwdPanel);
//		���ѧԺ
		collagePanel.add(collageLabel);
		collageLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		collagePanel.add(info);
		centerPanel.add(collagePanel);
//		��Ӱ�ť
		btnPanel.add(Btn);
		Btn.setFont(new Font("���ķ���", Font.BOLD, 20));
		centerPanel.add(btnPanel);

		this.add(centerPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
