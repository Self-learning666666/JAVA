package service;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentSelectCourse extends JPanel implements ActionListener {
	
	private JPanel centerPanel = new JPanel();
	
//	����γ̺�����
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("�γ̺� :");
	private JTextField id = new JTextField(20);
//	������Ӱ�ť
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("ȷ ��");	
	
	public StudentSelectCourse() {
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
//		��Ӱ�ť
		btnPanel.add(Btn);
		Btn.setFont(new Font("���ķ���", Font.BOLD, 20));
		centerPanel.add(btnPanel);

		this.add(centerPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
