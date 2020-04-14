package service;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddTeacher extends JPanel implements ActionListener {
	
	private JPanel centerPanel = new JPanel();
	
//	定义教师工号容器
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("工 号:");
	private JTextField id = new JTextField(20);
//	定义姓名容器
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("姓 名:");
	private JTextField name = new JTextField(20);
//	定义密码容器
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("密 码:");
	private JTextField passwd = new JTextField(20);
//	定义添加按钮
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("添 加");	
	
	public AddTeacher() {
//		清空布局管理器并定位
		this.setLayout(null);
		centerPanel.setBounds(240,50,300, 600);
//		调用添加组件函数
		addComponent();

	}
	/**
	 * 添加组件函数
	 */
	private void addComponent() {
//		添加
		IDPanel.add(IDLabel);
		IDLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		IDPanel.add(id);
		centerPanel.add(IDPanel);		
//		添加姓名
		namePanel.add(nameLabel);
		nameLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		namePanel.add(name);
		centerPanel.add(namePanel);
//		添加密码
		passwdPanel.add(passwdLabel);
		passwdLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		passwdPanel.add(passwd);
		centerPanel.add(passwdPanel);
//		添加按钮
		btnPanel.add(Btn);
		Btn.setFont(new Font("华文仿宋", Font.BOLD, 20));
		centerPanel.add(btnPanel);

		this.add(centerPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
