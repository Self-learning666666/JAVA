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
	
//	定义课程号容器
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("课程号 :");
	private JTextField id = new JTextField(20);
//	定义添加按钮
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("确 定");	
	
	public StudentSelectCourse() {
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
//		添加按钮
		btnPanel.add(Btn);
		Btn.setFont(new Font("华文仿宋", Font.BOLD, 20));
		centerPanel.add(btnPanel);

		this.add(centerPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
