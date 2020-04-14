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
//	���÷ֲ����񲼾�
	private JLayeredPane pane = new JLayeredPane(); 
//	���ñ�����ǩ
	private JLabel bglabel;
//	���ñ�������
	private JPanel bgpanel = new JPanel();
//	����IMageIcon��
	private ImageIcon image;

//	����������
	private JPanel mainPanel = new JPanel();
	
//	�����˺�����
	private JPanel namePanel = new JPanel();
	private Label nameLabel = new Label("�˺�:");
	private JTextField name = new JTextField(20);
	
//	������������
	private JPanel passwdPanel = new JPanel();
	private Label passwdLabel = new Label("����:");
	private JTextField passwd = new JTextField(20);
		
//	���õ�ѡ����
	private ButtonGroup btnGroup;
	private JPanel btnPanel;
	
//	��ӵ�¼��ť
	private JButton loginBtn = new JButton("�� ¼");	


	public mainFrame() {
//		������
		addComponent();
//		��ʼ������
		init();
//		ʵ��������
		addlistener();
		

	}
	
	/**
	 * ���崰������
	 */
	private void init() {
//      ���ø�����ʹ�õķֲ㴰��
        this.setLayeredPane(pane);
//		���ñ���
		this.setTitle("ѧ������ϵͳ������¼");
		
//		GUITools.center(this);
//		GUITools.setTitleImage(this,  "title.jpg");
//		����λ������
//		this.setResizable(false);
//		���ñ߽�λ��
	    this.setBounds(100,100,image.getIconWidth(), image.getIconHeight());
//	   	���ùرհ�ťĬ��Ϊ�˳�
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	              ���ô���ɼ�
	    this.setVisible(true);
	}
	
	/**
	 * ������
	 */
	private void addComponent() {
//		ʵ����ImageIcon��
		image = new ImageIcon("img/welbg.jpg");
//		�ѱ���ͼƬ��ӵ���ǩ��
        bglabel = new JLabel(image);
//      �Ѵ�������Ϊ��ͼƬ�ȸߵȿ�
        bgpanel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
//   	�Ѵ�������Ϊ��������
        bgpanel = (JPanel)this.getContentPane(); 
//      ��������ӱ�����ǩ
        bgpanel.add(bglabel);
//      ��Ӱ�ť��DEFAULT_LAYER��
        pane.add(bgpanel,JLayeredPane.DEFAULT_LAYER);
        
//      ����������ʽ����ʽ����С
        nameLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
//      ����������ɫ
        nameLabel.setForeground(Color.red);
//      �����˺�����͸��
        namePanel.setOpaque(false);
//      ����˺ű�ǩ���˺�����
        namePanel.add(nameLabel);
//      ����˺��������˺�����
        namePanel.add(name);
//      ����˺�������������
        mainPanel.add(namePanel);
        
//      ����������ʽ����ʽ����С
        passwdLabel.setFont(new Font("���ķ���", Font.BOLD, 20));
//      ����������ɫ
        passwdLabel.setForeground(Color.red);
//      ������������͸��
        passwdPanel.setOpaque(false);
//      ��������ǩ���˺�����
        passwdPanel.add(passwdLabel);
//      ��������������˺�����
        passwdPanel.add(passwd);
//      �������������������
        mainPanel.add(passwdPanel);

//      ���ð�ť����
        btnPanel = new JPanel();
//      ���ð�ť��
        btnGroup = new ButtonGroup();
      
//		ʵ������ѡ��ť
		JRadioButton managerButton = new JRadioButton("����Ա");
//		��ӵ�ѡ��ť�ڰ�ť��
		btnGroup.add(managerButton);
//		��ӵ�ѡ��ť����ť����
		btnPanel.add(managerButton);
		//	    ���ð�ť����͸��
		managerButton.setOpaque(false);
//		���ð�ť����
		managerButton.setFont(new Font("���ķ���", Font.BOLD, 25));
      
//		ʵ������ѡ��ť
		JRadioButton teacherButton = new JRadioButton("��ʦ");
//		��ӵ�ѡ��ť�ڰ�ť��
		btnGroup.add(teacherButton);
//		��ӵ�ѡ��ť����ť����
		btnPanel.add(teacherButton);
		//	    ���ð�ť����͸��
		teacherButton.setOpaque(false);
//		���ð�ť����
		teacherButton.setFont(new Font("���ķ���", Font.BOLD, 25));
		
//		ʵ������ѡ��ť
		JRadioButton studentButton = new JRadioButton("ѧ��");
//		��ӵ�ѡ��ť�ڰ�ť��
		btnGroup.add(studentButton);
//		��ӵ�ѡ��ť����ť����
		btnPanel.add(studentButton);
		//	    ���ð�ť����͸��
		studentButton.setOpaque(false);
//		���ð�ť����
		studentButton.setFont(new Font("���ķ���", Font.BOLD, 25));

//      ���ð�ť����͸��
        btnPanel.setOpaque(false);
//      �������������������
        mainPanel.add(btnPanel);
      
//      ���õ�¼��ť͸��
        loginBtn.setOpaque(false);
//      ���ð�ť��С��λ��
//        loginBtn.setBounds(100, 100, 200, 200);
//      ��Ӱ�ť
        mainPanel.add(loginBtn);
//        �����������ĵĴ�С��λ��
        mainPanel.setBounds(100, 100, 300, 200);
//        ����������͸��
        mainPanel.setOpaque(false);
//        ������������ֲ㲼��
        pane.add(mainPanel, JLayeredPane.MODAL_LAYER);
	}
	/**
	 * ��Ӽ���
	 */
	private void addlistener() {
		
	}
}

