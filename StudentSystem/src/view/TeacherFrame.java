package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.AddGrade;
import service.SelectGrade;
import service.UpdateGrade;



public class TeacherFrame extends JFrame implements ActionListener {
//	卡片布局
	private CardLayout cardLayout = new CardLayout();
	
	private JPanel btnPanel = new JPanel();
	private JPanel cardPanel = new JPanel();
	private Button addBtn = new Button("添加成绩");
	private Button updateBtn = new Button("修改成绩");
	private Button selectBtn = new Button("查看成绩");

	AddGrade addGrade = new AddGrade();
	UpdateGrade updateGrade = new UpdateGrade();
	SelectGrade selectGrade = new SelectGrade();
	
	/**
	 * 构造函数
	 */
	public TeacherFrame() {
		cardPanel.setLayout(cardLayout);
//		调用添加组件函数
		addComponent();
//		调用添加监听函数
		addlistener();
			
//		设置标题
		this.setTitle("学生管理系统——教师");
//		GUITools.center(this);
//		GUITools.setTitleImage(this,  "title.jpg");
//		设置边界位置
	    this.setBounds(100,60,780, 550);
//	   	设置关闭按钮默认为退出
	    this.addWindowListener(new  WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		TeacherFrame.this.dispose();
	    	}
	    });
//	              设置窗体可见
	    this.setVisible(true);
	}
	
	/**
	 * 添加组件
	 */
	private void addComponent() {

		btnPanel.add(addBtn);
		btnPanel.add(updateBtn);
		btnPanel.add(selectBtn);
		this.add(btnPanel,BorderLayout.CENTER);
		
//		实例化欢迎界面的图
		JLabel bgLable = new JLabel(new ImageIcon("img/welbg.jpg"));
//		添加界面并命名
		cardPanel.add("welcome",bgLable);
		
		cardPanel.add("添加成绩",addGrade);
		cardPanel.add("修改成绩",updateGrade);
		cardPanel.add("查看成绩",selectGrade);
		

//		测试
		Label welcomeLabel22 = new Label("欢迎！", Label.CENTER);
		cardPanel.add("ceshi",welcomeLabel22);	
		
		
//		将卡片容器放到边界布局器的中部
		this.add(cardPanel,BorderLayout.SOUTH);
	}
	/**
	 *添加按钮的监听
	 */
	public void addlistener() {
		addBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		selectBtn.addActionListener(this);
		
	}
	/**
	 * 定义菜单栏选项的监听触发并做出相应处理
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn) {
			cardLayout.show(cardPanel, "添加成绩");
		}else if(e.getSource() == updateBtn) {
			cardLayout.show(cardPanel, "修改成绩");
		}else if(e.getSource() == selectBtn) {
			cardLayout.show(cardPanel, "查看成绩");
		}
		
		
		
	}
	
}