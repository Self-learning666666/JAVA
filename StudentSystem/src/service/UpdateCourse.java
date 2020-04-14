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
	
//	定义课程号容器
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("课程号 :");
	private JTextField id = new JTextField(20);
//	定义课程名容器
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("课程名 :");
	private JTextField name = new JTextField(20);
//	定义教师ID容器
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("教师ID :");
	private JTextField Tid = new JTextField(20);
///	定义课程简介容器
	private JPanel collagePanel = new JPanel();
	private Label collageLabel = new Label("简  介  :");
	private JTextField info = new JTextField(20);
//	定义添加按钮
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("修 改");	
	
	public UpdateCourse() {
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
		passwdPanel.add(Tid);
		centerPanel.add(passwdPanel);
//		添加学院
		collagePanel.add(collageLabel);
		collageLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		collagePanel.add(info);
		centerPanel.add(collagePanel);
//		添加按钮
		btnPanel.add(Btn);
		Btn.setFont(new Font("华文仿宋", Font.BOLD, 20));
		centerPanel.add(btnPanel);

		this.add(centerPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
