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
//	��Ƭ����
	private CardLayout cardLayout = new CardLayout();
	
	private JPanel btnPanel = new JPanel();
	private JPanel cardPanel = new JPanel();
	private Button addBtn = new Button("��ӳɼ�");
	private Button updateBtn = new Button("�޸ĳɼ�");
	private Button selectBtn = new Button("�鿴�ɼ�");

	AddGrade addGrade = new AddGrade();
	UpdateGrade updateGrade = new UpdateGrade();
	SelectGrade selectGrade = new SelectGrade();
	
	/**
	 * ���캯��
	 */
	public TeacherFrame() {
		cardPanel.setLayout(cardLayout);
//		��������������
		addComponent();
//		������Ӽ�������
		addlistener();
			
//		���ñ���
		this.setTitle("ѧ������ϵͳ������ʦ");
//		GUITools.center(this);
//		GUITools.setTitleImage(this,  "title.jpg");
//		���ñ߽�λ��
	    this.setBounds(100,60,780, 550);
//	   	���ùرհ�ťĬ��Ϊ�˳�
	    this.addWindowListener(new  WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		TeacherFrame.this.dispose();
	    	}
	    });
//	              ���ô���ɼ�
	    this.setVisible(true);
	}
	
	/**
	 * ������
	 */
	private void addComponent() {

		btnPanel.add(addBtn);
		btnPanel.add(updateBtn);
		btnPanel.add(selectBtn);
		this.add(btnPanel,BorderLayout.CENTER);
		
//		ʵ������ӭ�����ͼ
		JLabel bgLable = new JLabel(new ImageIcon("img/welbg.jpg"));
//		��ӽ��沢����
		cardPanel.add("welcome",bgLable);
		
		cardPanel.add("��ӳɼ�",addGrade);
		cardPanel.add("�޸ĳɼ�",updateGrade);
		cardPanel.add("�鿴�ɼ�",selectGrade);
		

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
		addBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		selectBtn.addActionListener(this);
		
	}
	/**
	 * ����˵���ѡ��ļ���������������Ӧ����
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn) {
			cardLayout.show(cardPanel, "��ӳɼ�");
		}else if(e.getSource() == updateBtn) {
			cardLayout.show(cardPanel, "�޸ĳɼ�");
		}else if(e.getSource() == selectBtn) {
			cardLayout.show(cardPanel, "�鿴�ɼ�");
		}
		
		
		
	}
	
}