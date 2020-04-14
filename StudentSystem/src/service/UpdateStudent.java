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
	
//	定义学号容器
	private JPanel IDPanel = new JPanel();
	private Label IDLabel = new Label("学 号:");
	private JTextField id = new JTextField(20);
//	定义学号容器
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("姓 名:");
	private JTextField name = new JTextField(20);
//	定义学号容器
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("密 码:");
	private JTextField passwd = new JTextField(20);
//	定义学号容器
	private JPanel sexPanel = new JPanel();
	private Label sexLabel = new Label("性 别:   ");
	private ButtonGroup sexGroup = new ButtonGroup();
//	定义籍贯容器
	private JPanel cityPanel = new JPanel();
	private Label cityLabel = new Label("籍 贯:");
	private JTextField city = new JTextField(20);
//	定义学号容器
	private JPanel collagePanel = new JPanel();
	private Label collageLabel = new Label("学 院:");
	private JTextField collage = new JTextField(20);
//	定义添加按钮
	private JPanel btnPanel = new JPanel();
	private JButton Btn = new JButton("修 改");	
	
	public UpdateStudent() {
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
		passwdPanel.add(passwd);
		centerPanel.add(passwdPanel);
//		添加性别
		sexPanel.add(sexLabel);
		sexLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		JRadioButton manButton = new JRadioButton("男");
		manButton.setFont(new Font("华文仿宋", Font.BOLD, 20));
		sexGroup.add(manButton);
		sexPanel.add(manButton);
		sexPanel.add(new Label("           "));
		JRadioButton womanButton = new JRadioButton("女");
		womanButton.setFont(new Font("华文仿宋", Font.BOLD, 20));
		sexGroup.add(womanButton);
		sexPanel.add(womanButton);
		sexPanel.add(new Label("     "));
		centerPanel.add(sexPanel);
//		添加学院
		collagePanel.add(collageLabel);
		collageLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		collagePanel.add(collage);
		centerPanel.add(collagePanel);
//		添加籍贯
		cityPanel.add(cityLabel);
		cityLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
		cityPanel.add(city);
		centerPanel.add(cityPanel);
//		添加按钮
		btnPanel.add(Btn);
		Btn.setFont(new Font("华文仿宋", Font.BOLD, 20));
		centerPanel.add(btnPanel);

		this.add(centerPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
