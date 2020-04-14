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
//	��Ƭ����
	private CardLayout cardLayout = new CardLayout();
	
	private JPanel btnPanel = new JPanel();
	private JPanel cardPanel = new JPanel();
	private Button selectCourseBtn = new Button("ѡ��");
	private Button selectGradeBtn = new Button("�鿴�ɼ�");

	StudentSelectCourse selectCourse = new StudentSelectCourse();
	StudentSelectGrade selectGrade = new StudentSelectGrade();
//	StudentSelectGradeResult result = new StudentSelectGradeResult();
	
	/**
	 * ���캯��
	 */
	public StudentFrame() {
		cardPanel.setLayout(cardLayout);
//		��������������
		addComponent();
//		������Ӽ�������
		addlistener();
			
//		���ñ���
		this.setTitle("ѧ������ϵͳ����ѧ��");
//		GUITools.center(this);
//		GUITools.setTitleImage(this,  "title.jpg");
//		���ñ߽�λ��
	    this.setBounds(100,60,780, 550);
//	   	���ùرհ�ťĬ��Ϊ�˳�
	    this.addWindowListener(new  WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		StudentFrame.this.dispose();
	    	}
	    });
//	              ���ô���ɼ�
	    this.setVisible(true);
	}
	
	/**
	 * ������
	 */
	private void addComponent() {

		btnPanel.add(selectCourseBtn);
		btnPanel.add(selectGradeBtn);
		this.add(btnPanel,BorderLayout.CENTER);
		
//		ʵ������ӭ�����ͼ
		JLabel bgLable = new JLabel(new ImageIcon("img/welbg.jpg"));
//		��ӽ��沢����
		cardPanel.add("welcome",bgLable);
		
		cardPanel.add("ѡ��",selectCourse);
		cardPanel.add("�鿴�ɼ�",selectGrade);
//		cardPanel.add("�ɼ�",result);
		

//		����
		Label welcomeLabel22 = new Label("��ӭ��", Label.CENTER);
		cardPanel.add("ceshi",welcomeLabel22);	
		
		
//		����Ƭ�����ŵ��߽粼�������в�
		this.add(cardPanel,BorderLayout.SOUTH);
	}
	/**
	 *��Ӱ�ť�ļ���
	 */
	public void addlistener() {
		selectCourseBtn.addActionListener(this);
		selectGradeBtn.addActionListener(this);
		
	}
	/**
	 * ����˵���ѡ��ļ���������������Ӧ����
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == selectCourseBtn) {
			cardLayout.show(cardPanel, "ѡ��");
		}else if(e.getSource() == selectGradeBtn) {
			cardLayout.show(cardPanel, "�鿴�ɼ�");
		}
	}
		
}
