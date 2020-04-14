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
//	��Ƭ����
	private CardLayout cardLayout = new CardLayout();

//	ѧ����Ϣ
	private JMenu studentMenu = new JMenu("ѧ����Ϣ");
	private JMenuItem addStudent = new JMenuItem("����ѧ��");
	private JMenuItem delStudent = new JMenuItem("����ѧ��");
	private JMenuItem updateStudent = new JMenuItem("�޸�ѧ��");
	private JMenuItem selectStudent = new JMenuItem("�鿴ѧ��");
	
//	��ʦ��Ϣ
	private JMenu teacherMenu = new JMenu("��ʦ��Ϣ");
	private JMenuItem addTeacher = new JMenuItem("���ӽ�ʦ");
	private JMenuItem delTeacher = new JMenuItem("��ʦ��ְ");
	private JMenuItem updateTeacher = new JMenuItem("�޸Ľ�ʦ");
	private JMenuItem selectTeacher = new JMenuItem("�鿴��ʦ");
	
//	�γ���Ϣ
	private JMenu courseMenu = new JMenu("�γ���Ϣ");
	private JMenuItem addCourse = new JMenuItem("���ӿγ�");
	private JMenuItem delCourse = new JMenuItem("�����γ�");
	private JMenuItem updateCourse = new JMenuItem("�޸Ŀγ�");
	private JMenuItem selectCourse = new JMenuItem("�鿴�γ�");
	
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
	 * ���캯��
	 */
	public ManagerFrame() {
//		���˵���ӵ��˵�����
		this.setJMenuBar(menuBar);
//		��������������
		addComponent();
//		������Ӽ�������
		addlistener();
			
//		���ñ���
		this.setTitle("ѧ������ϵͳ��������Ա");
//		GUITools.center(this);
//		GUITools.setTitleImage(this,  "title.jpg");
//		����λ������
//		this.setResizable(false);
//		���ñ߽�λ��
	    this.setBounds(100,60,780, 550);
//	   	���ùرհ�ťĬ��Ϊ�˳�
	    this.addWindowListener(new  WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		ManagerFrame.this.dispose();
	    	}
	    });
//	              ���ô���ɼ�
	    this.setVisible(true);
	}
	
	/**
	 * ������
	 */
	private void addComponent() {
//		���ѧ�������˵�
		menuBar.add(studentMenu);
		studentMenu.add(addStudent);
		studentMenu.addSeparator();
		studentMenu.add(delStudent);
		studentMenu.addSeparator();
		studentMenu.add(updateStudent);
		studentMenu.addSeparator();
		studentMenu.add(selectStudent);
		studentMenu.setFont(new Font("���ķ���", Font.BOLD, 15));
		
//		��ӽ�ʦ�����˵�
		menuBar.add(teacherMenu);
		teacherMenu.add(addTeacher);
		teacherMenu.addSeparator();
		teacherMenu.add(delTeacher);
		teacherMenu.addSeparator();
		teacherMenu.add(updateTeacher);
		teacherMenu.addSeparator();
		teacherMenu.add(selectTeacher);
		teacherMenu.setFont(new Font("���ķ���", Font.BOLD, 15));
		
//		��ӿγ������˵�
		menuBar.add(courseMenu);
		courseMenu.add(addCourse);
		courseMenu.addSeparator();
		courseMenu.add(delCourse);
		courseMenu.addSeparator();
		courseMenu.add(updateCourse);
		courseMenu.addSeparator();
		courseMenu.add(selectCourse);
		courseMenu.setFont(new Font("���ķ���", Font.BOLD, 15));
		
//		ʵ������ӭ�����ͼ
		JLabel bgLable = new JLabel(new ImageIcon("img/welbg.jpg"));
//		����cardLayout�����Ĳ��ַ�ʽ
		cardPanel.setLayout(cardLayout);
		
		
//		��ӽ��沢����
		cardPanel.add("welcome",bgLable);
		
		cardPanel.add("���ѧ��",addstudent);
		cardPanel.add("ɾ��ѧ��",delstudent);
		cardPanel.add("�޸�ѧ��",updatestudent);
		cardPanel.add("�鿴ѧ��",selectstudent);
		
		cardPanel.add("�����ʦ",addteacher);
		cardPanel.add("ɾ����ʦ",delteacher);
		cardPanel.add("�޸���ʦ",updateteacher);
		cardPanel.add("�鿴��ʦ",selectteacher);

		cardPanel.add("��ӿγ�",addcourse);
		cardPanel.add("ɾ���γ�",delcourse);
		cardPanel.add("�޸Ŀγ�",updatecourse);
		cardPanel.add("�鿴�γ�",selectcourse);
		

//		����
//		Label welcomeLabel22 = new Label("��ӭ��", Label.CENTER);
//		cardPanel.add("ceshi",welcomeLabel22);	
	
		
//		����Ƭ�����ŵ��߽粼�������в�
		this.add(cardPanel,BorderLayout.CENTER);
	}
	/**
	 *��Ӳ˵����ļ���
	 */
	public void addlistener() {
//		���ѧ������
		addStudent.addActionListener(this);
		delStudent.addActionListener(this);
		updateStudent.addActionListener(this);
		selectStudent.addActionListener(this);
		
//		�����ʦ����
		addTeacher.addActionListener(this);
		delTeacher.addActionListener(this);
		updateTeacher.addActionListener(this);
		selectTeacher.addActionListener(this);
		
//		�����ʦ����
		addCourse.addActionListener(this);
		delCourse.addActionListener(this);
		updateCourse.addActionListener(this);
		selectCourse.addActionListener(this);
	}
	/**
	 * ����˵���ѡ��ļ���������������Ӧ����
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addStudent) {
			cardLayout.show(cardPanel, "���ѧ��");
		}else if(e.getSource() == delStudent) {
			cardLayout.show(cardPanel, "ɾ��ѧ��");
		}else if(e.getSource() == updateStudent) {
			cardLayout.show(cardPanel, "�޸�ѧ��");
		}else if(e.getSource() == selectStudent) {
			cardLayout.show(cardPanel, "�鿴ѧ��");
		}else if(e.getSource() == addTeacher) {
			cardLayout.show(cardPanel, "�����ʦ");
		}else if(e.getSource() == delTeacher) {
			cardLayout.show(cardPanel, "ɾ����ʦ");
		}else if(e.getSource() == updateTeacher) {
			cardLayout.show(cardPanel, "�޸���ʦ");
		}else if(e.getSource() == selectTeacher) {
			cardLayout.show(cardPanel, "�鿴��ʦ");
		}else if(e.getSource() == addCourse) {
			cardLayout.show(cardPanel, "��ӿγ�");
		}else if(e.getSource() == delCourse) {
			cardLayout.show(cardPanel, "ɾ���γ�");
		}else if(e.getSource() == updateCourse) {
			cardLayout.show(cardPanel, "�޸Ŀγ�");
		}else if(e.getSource() == selectCourse) {
			cardLayout.show(cardPanel, "�鿴�γ�");
		}
		
		
		
	}
	
}
