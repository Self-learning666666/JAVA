package service;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpdateStudent extends JPanel implements ActionListener {
	
	private JPanel centerPanel = new JPanel();
	
//	����ѧ������
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("ѧ ��:");
	private JTextField id = new JTextField(20);
//	����ѧ������
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("�� ��:");
	private JTextField name = new JTextField(20);
//	����ѧ������
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("�� ��:");
	private JTextField passwd = new JTextField(20);
//	����ѧ������
	private JPanel sexPanel = new JPanel();
	private Label sexLabel = new Label("�� ��:   ");
	private ButtonGroup sexGroup = new ButtonGroup();
//	���弮������
	private JPanel cityPanel = new JPanel();
	private Label cityLabel = new Label("�� ��:");
	private JTextField city = new JTextField(20);
//	����ѧ������
	private JPanel collagePanel = new JPanel();
	private Label collageLabel = new Label("ѧ Ժ:");
	private JTextField collage = new JTextField(20);
//	������Ӱ�ť
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("�� ��");	
	
	public UpdateStudent() {
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
		passwdPanel.add(passwd);
		centerPanel.add(passwdPanel);
//		����Ա�
		sexPanel.add(sexLabel);
		sexLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		JRadioButton manButton = new JRadioButton("��");
		manButton.setFont(new Font("���ķ���", Font.BOLD, 20));
		sexGroup.add(manButton);
		sexPanel.add(manButton);
		sexPanel.add(new Label("           "));
		JRadioButton womanButton = new JRadioButton("Ů");
		womanButton.setFont(new Font("���ķ���", Font.BOLD, 20));
		sexGroup.add(womanButton);
		sexPanel.add(womanButton);
		sexPanel.add(new Label("     "));
		centerPanel.add(sexPanel);
//		���ѧԺ
		collagePanel.add(collageLabel);
		collageLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		collagePanel.add(collage);
		centerPanel.add(collagePanel);
//		��Ӽ���
		cityPanel.add(cityLabel);
		cityLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
		cityPanel.add(city);
		centerPanel.add(cityPanel);
//		��Ӱ�ť
		btnPanel.add(Btn);
		Btn.setFont(new Font("���ķ���", Font.BOLD, 20));
		centerPanel.add(btnPanel);

		this.add(centerPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
