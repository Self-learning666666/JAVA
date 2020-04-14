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
	
//	定义课程号容器
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("学   号 :");
	private JTextField Sid = new JTextField(20);
//	定义课程名容器
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("课程号:");
	private JTextField Cid = new JTextField(20);
//	定义教师ID容器
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("成  绩 :");
	private JTextField grade = new JTextField(20);
//	定义添加按钮
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("添 加");	
	
	public AddGrade() {
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
//		添加学号
		IDPanel.add(IDLabel);
		IDLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		IDPanel.add(Sid);
		centerPanel.add(IDPanel);		
//		添加姓名
		namePanel.add(nameLabel);
		nameLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		namePanel.add(Cid);
		centerPanel.add(namePanel);
//		添加密码
		passwdPanel.add(passwdLabel);
		passwdLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		passwdPanel.add(grade);
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
