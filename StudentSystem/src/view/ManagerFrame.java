package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import service.AddCourse;
import service.AddStudent;
import service.AddTeacher;
import service.DelCourse;
import service.DelStudent;
import service.DelTeacher;
import service.SelectCourse;
import service.SelectStudent;
import service.SelectTeacher;
import service.UpdateCourse;
import service.UpdateStudent;
import service.UpdateTeacher;

public class ManagerFrame extends JFrame implements ActionListener {
	private JPanel cardPanel = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
//	卡片布局
	private CardLayout cardLayout = new CardLayout();

//	学生信息
	private JMenu studentMenu = new JMenu("学生信息");
	private JMenuItem addStudent = new JMenuItem("增加学生");
	private JMenuItem delStudent = new JMenuItem("开除学生");
	private JMenuItem updateStudent = new JMenuItem("修改学生");
	private JMenuItem selectStudent = new JMenuItem("查看学生");
	
//	教师信息
	private JMenu teacherMenu = new JMenu("教师信息");
	private JMenuItem addTeacher = new JMenuItem("增加教师");
	private JMenuItem delTeacher = new JMenuItem("教师离职");
	private JMenuItem updateTeacher = new JMenuItem("修改教师");
	private JMenuItem selectTeacher = new JMenuItem("查看教师");
	
//	课程信息
	private JMenu courseMenu = new JMenu("课程信息");
	private JMenuItem addCourse = new JMenuItem("增加课程");
	private JMenuItem delCourse = new JMenuItem("结束课程");
	private JMenuItem updateCourse = new JMenuItem("修改课程");
	private JMenuItem selectCourse = new JMenuItem("查看课程");
	
	AddStudent addstudent = new AddStudent();
	DelStudent delstudent = new DelStudent();
	UpdateStudent updatestudent = new UpdateStudent();
	SelectStudent selectstudent = new SelectStudent();
	AddTeacher addteacher = new AddTeacher();
	DelTeacher delteacher = new DelTeacher();
	UpdateTeacher updateteacher = new UpdateTeacher();
	SelectTeacher selectteacher = new SelectTeacher();
	AddCourse addcourse = new AddCourse();
	DelCourse delcourse = new DelCourse();
	UpdateCourse updatecourse = new UpdateCourse();
	SelectCourse selectcourse = new SelectCourse();
	
	/**
	 * 构造函数
	 */
	public ManagerFrame() {
//		将菜单添加到菜单栏上
		this.setJMenuBar(menuBar);
//		调用添加组件函数
		addComponent();
//		调用添加监听函数
		addlistener();
			
//		设置标题
		this.setTitle("学生管理系统——管理员");
//		GUITools.center(this);
//		GUITools.setTitleImage(this,  "title.jpg");
//		窗口位置设置
//		this.setResizable(false);
//		设置边界位置
	    this.setBounds(100,60,780, 550);
//	   	设置关闭按钮默认为退出
	    this.addWindowListener(new  WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		ManagerFrame.this.dispose();
	    	}
	    });
//	              设置窗体可见
	    this.setVisible(true);
	}
	
	/**
	 * 添加组件
	 */
	private void addComponent() {
//		添加学生下拉菜单
		menuBar.add(studentMenu);
		studentMenu.add(addStudent);
		studentMenu.addSeparator();
		studentMenu.add(delStudent);
		studentMenu.addSeparator();
		studentMenu.add(updateStudent);
		studentMenu.addSeparator();
		studentMenu.add(selectStudent);
		studentMenu.setFont(new Font("华文仿宋", Font.BOLD, 15));
		
//		添加教师下拉菜单
		menuBar.add(teacherMenu);
		teacherMenu.add(addTeacher);
		teacherMenu.addSeparator();
		teacherMenu.add(delTeacher);
		teacherMenu.addSeparator();
		teacherMenu.add(updateTeacher);
		teacherMenu.addSeparator();
		teacherMenu.add(selectTeacher);
		teacherMenu.setFont(new Font("华文仿宋", Font.BOLD, 15));
		
//		添加课程下拉菜单
		menuBar.add(courseMenu);
		courseMenu.add(addCourse);
		courseMenu.addSeparator();
		courseMenu.add(delCourse);
		courseMenu.addSeparator();
		courseMenu.add(updateCourse);
		courseMenu.addSeparator();
		courseMenu.add(selectCourse);
		courseMenu.setFont(new Font("华文仿宋", Font.BOLD, 15));
		
//		实例化欢迎界面的图
		JLabel bgLable = new JLabel(new ImageIcon("img/welbg.jpg"));
//		设置cardLayout容器的布局方式
		cardPanel.setLayout(cardLayout);
		
		
//		添加界面并命名
		cardPanel.add("welcome",bgLable);
		
		cardPanel.add("添加学生",addstudent);
		cardPanel.add("删除学生",delstudent);
		cardPanel.add("修改学生",updatestudent);
		cardPanel.add("查看学生",selectstudent);
		
		cardPanel.add("添加老师",addteacher);
		cardPanel.add("删除老师",delteacher);
		cardPanel.add("修改老师",updateteacher);
		cardPanel.add("查看老师",selectteacher);

		cardPanel.add("添加课程",addcourse);
		cardPanel.add("删除课程",delcourse);
		cardPanel.add("修改课程",updatecourse);
		cardPanel.add("查看课程",selectcourse);
		

//		测试
//		Label welcomeLabel22 = new Label("欢迎！", Label.CENTER);
//		cardPanel.add("ceshi",welcomeLabel22);	
	
		
//		将卡片容器放到边界布局器的中部
		this.add(cardPanel,BorderLayout.CENTER);
	}
	/**
	 *添加菜单栏的监听
	 */
	public void addlistener() {
//		添加学生监听
		addStudent.addActionListener(this);
		delStudent.addActionListener(this);
		updateStudent.addActionListener(this);
		selectStudent.addActionListener(this);
		
//		添加老师监听
		addTeacher.addActionListener(this);
		delTeacher.addActionListener(this);
		updateTeacher.addActionListener(this);
		selectTeacher.addActionListener(this);
		
//		添加老师监听
		addCourse.addActionListener(this);
		delCourse.addActionListener(this);
		updateCourse.addActionListener(this);
		selectCourse.addActionListener(this);
	}
	/**
	 * 定义菜单栏选项的监听触发并做出相应处理
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addStudent) {
			cardLayout.show(cardPanel, "添加学生");
		}else if(e.getSource() == delStudent) {
			cardLayout.show(cardPanel, "删除学生");
		}else if(e.getSource() == updateStudent) {
			cardLayout.show(cardPanel, "修改学生");
		}else if(e.getSource() == selectStudent) {
			cardLayout.show(cardPanel, "查看学生");
		}else if(e.getSource() == addTeacher) {
			cardLayout.show(cardPanel, "添加老师");
		}else if(e.getSource() == delTeacher) {
			cardLayout.show(cardPanel, "删除老师");
		}else if(e.getSource() == updateTeacher) {
			cardLayout.show(cardPanel, "修改老师");
		}else if(e.getSource() == selectTeacher) {
			cardLayout.show(cardPanel, "查看老师");
		}else if(e.getSource() == addCourse) {
			cardLayout.show(cardPanel, "添加课程");
		}else if(e.getSource() == delCourse) {
			cardLayout.show(cardPanel, "删除课程");
		}else if(e.getSource() == updateCourse) {
			cardLayout.show(cardPanel, "修改课程");
		}else if(e.getSource() == selectCourse) {
			cardLayout.show(cardPanel, "查看课程");
		}
		
		
		
	}
	
}
