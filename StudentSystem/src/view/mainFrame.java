package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class mainFrame extends JFrame {
//	设置分层网格布局
	private JLayeredPane pane = new JLayeredPane(); 
//	设置背景标签
	private JLabel bglabel;
//	设置背景容器
	private JPanel bgpanel = new JPanel();
//	设置IMageIcon类
	private ImageIcon image;

//	设置主容器
	private JPanel mainPanel = new JPanel();
	
//	设置账号容器
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("账号:");
	private JTextField name = new JTextField(20);
	
//	设置密码容器
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("密码:");
	private JTextField passwd = new JTextField(20);
		
//	设置单选容器
	private ButtonGroup btnGroup;
	private JPanel btnPanel;
	
//	添加登录按钮
	private JButton loginBtn = new JButton("登 录");	


	public mainFrame() {
//		添加组件
		addComponent();
//		初始化操作
		init();
//		实例化监听
		addlistener();
		

	}
	
	/**
	 * 定义窗口设置
	 */
	private void init() {
//      设置根窗格使用的分层窗格
        this.setLayeredPane(pane);
//		设置标题
		this.setTitle("学生管理系统——登录");
		
//		GUITools.center(this);
//		GUITools.setTitleImage(this,  "title.jpg");
//		窗口位置设置
//		this.setResizable(false);
//		设置边界位置
	    this.setBounds(100,100,image.getIconWidth(), image.getIconHeight());
//	   	设置关闭按钮默认为退出
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	              设置窗体可见
	    this.setVisible(true);
	}
	
	/**
	 * 添加组件
	 */
	private void addComponent() {
//		实例化ImageIcon类
		image = new ImageIcon("img/welbg.jpg");
//		把背景图片添加到标签里
        bglabel = new JLabel(image);
//      把窗口设置为和图片等高等宽
        bgpanel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
//   	把窗口设置为背景窗口
        bgpanel = (JPanel)this.getContentPane(); 
//      给窗口添加背景标签
        bgpanel.add(bglabel);
//      添加按钮至DEFAULT_LAYER层
        pane.add(bgpanel,JLayeredPane.DEFAULT_LAYER);
        
//      设置字体样式、形式、大小
        nameLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
//      设置字体颜色
        nameLabel.setForeground(Color.red);
//      设置账号容器透明
        namePanel.setOpaque(false);
//      添加账号标签至账号区域
        namePanel.add(nameLabel);
//      添加账号区域至账号区域
        namePanel.add(name);
//      添加账号区域于主区域
        mainPanel.add(namePanel);
        
//      设置字体样式、形式、大小
        passwdLabel.setFont(new Font("华文仿宋", Font.BOLD, 20));
//      设置字体颜色
        passwdLabel.setForeground(Color.red);
//      设置密码容器透明
        passwdPanel.setOpaque(false);
//      添加密码标签至账号区域
        passwdPanel.add(passwdLabel);
//      添加密码区域至账号区域
        passwdPanel.add(passwd);
//      添加密码区域于主区域
        mainPanel.add(passwdPanel);

//      设置按钮容器
        btnPanel = new JPanel();
//      设置按钮组
        btnGroup = new ButtonGroup();
      
//		实例化单选按钮
		JRadioButton managerButton = new JRadioButton("管理员");
//		添加单选按钮于按钮组
		btnGroup.add(managerButton);
//		添加单选按钮至按钮容器
		btnPanel.add(managerButton);
		//	    设置按钮容器透明
		managerButton.setOpaque(false);
//		设置按钮字体
		managerButton.setFont(new Font("华文仿宋", Font.BOLD, 25));
      
//		实例化单选按钮
		JRadioButton teacherButton = new JRadioButton("教师");
//		添加单选按钮于按钮组
		btnGroup.add(teacherButton);
//		添加单选按钮至按钮容器
		btnPanel.add(teacherButton);
		//	    设置按钮容器透明
		teacherButton.setOpaque(false);
//		设置按钮字体
		teacherButton.setFont(new Font("华文仿宋", Font.BOLD, 25));
		
//		实例化单选按钮
		JRadioButton studentButton = new JRadioButton("学生");
//		添加单选按钮于按钮组
		btnGroup.add(studentButton);
//		添加单选按钮至按钮容器
		btnPanel.add(studentButton);
		//	    设置按钮容器透明
		studentButton.setOpaque(false);
//		设置按钮字体
		studentButton.setFont(new Font("华文仿宋", Font.BOLD, 25));

//      设置按钮容器透明
        btnPanel.setOpaque(false);
//      添加密码区域于主区域
        mainPanel.add(btnPanel);
      
//      设置登录按钮透明
        loginBtn.setOpaque(false);
//      设置按钮大小及位置
//        loginBtn.setBounds(100, 100, 200, 200);
//      添加按钮
        mainPanel.add(loginBtn);
//        设置主容器的的大小及位置
        mainPanel.setBounds(100, 100, 300, 200);
//        设置主容器透明
        mainPanel.setOpaque(false);
//        添加主容器至分层布局
        pane.add(mainPanel, JLayeredPane.MODAL_LAYER);
	}
	/**
	 * 添加监听
	 */
	private void addlistener() {
		
	}
}

