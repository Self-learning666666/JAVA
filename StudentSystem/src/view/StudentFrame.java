package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.StudentSelectCourse;
import service.StudentSelectGrade;
import service.StudentSelectGradeResult;

public class StudentFrame extends JFrame implements ActionListener {
//	卡片布局
	private CardLayout cardLayout = new CardLayout();
	
	private JPanel btnPanel = new JPanel();
	private JPanel cardPanel = new JPanel();
	private Button selectCourseBtn = new Button("选课");
	private Button selectGradeBtn = new Button("查看成绩");

	StudentSelectCourse selectCourse = new StudentSelectCourse();
	StudentSelectGrade selectGrade = new StudentSelectGrade();
//	StudentSelectGradeResult result = new StudentSelectGradeResult();
	
	/**
	 * 构造函数
	 */
	public StudentFrame() {
		cardPanel.setLayout(cardLayout);
//		调用添加组件函数
		addComponent();
//		调用添加监听函数
		addlistener();
			
//		设置标题
		this.setTitle("学生管理系统——学生");
//		GUITools.center(this);
//		GUITools.setTitleImage(this,  "title.jpg");
//		设置边界位置
	    this.setBounds(100,60,780, 550);
//	   	设置关闭按钮默认为退出
	    this.addWindowListener(new  WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		StudentFrame.this.dispose();
	    	}
	    });
//	              设置窗体可见
	    this.setVisible(true);
	}
	
	/**
	 * 添加组件
	 */
	private void addComponent() {

		btnPanel.add(selectCourseBtn);
		btnPanel.add(selectGradeBtn);
		this.add(btnPanel,BorderLayout.CENTER);
		
//		实例化欢迎界面的图
		JLabel bgLable = new JLabel(new ImageIcon("img/welbg.jpg"));
//		添加界面并命名
		cardPanel.add("welcome",bgLable);
		
		cardPanel.add("选课",selectCourse);
		cardPanel.add("查看成绩",selectGrade);
//		cardPanel.add("成绩",result);
		

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
		selectCourseBtn.addActionListener(this);
		selectGradeBtn.addActionListener(this);
		
	}
	/**
	 * 定义菜单栏选项的监听触发并做出相应处理
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == selectCourseBtn) {
			cardLayout.show(cardPanel, "选课");
		}else if(e.getSource() == selectGradeBtn) {
			cardLayout.show(cardPanel, "查看成绩");
		}
	}
		
}
