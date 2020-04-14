package chapter8;
import java.awt.*;
import java.awt.event.*;
public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		框架窗口
		Frame frame = new Frame("计算器");
		frame.setSize(400, 550);
		frame.setLocation(500,50);
		frame.setVisible(true);
		frame.addWindowListener(new MywindowListener());
//		创建布局管理器
		GridBagLayout layout = new GridBagLayout();
		frame.setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		
//		显示框	
		constraints.gridx = 1;
		constraints.gridy = 1;
//		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		TextField tf = new TextField(50);
		layout.setConstraints(tf, constraints);
		frame.add(tf);
		
//		添加按钮
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn21 = new Button("C");
		layout.setConstraints(btn21, constraints);
		frame.add(btn21);
		btn21.addMouseListener(new MymouseListener());
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn22 = new Button("清理");
		layout.setConstraints(btn22, constraints);
		frame.add(btn22);
		
		constraints.gridx = 3;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn23 = new Button("%");
		layout.setConstraints(btn23, constraints);
		frame.add(btn23);
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 4;
		constraints.gridy = 2;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn24 = new Button("/");
		layout.setConstraints(btn24, constraints);
		frame.add(btn24);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn31 = new Button("7");
		layout.setConstraints(btn31, constraints);
		frame.add(btn31);
		
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn32 = new Button("8");
		layout.setConstraints(btn32, constraints);
		frame.add(btn32);
		
		constraints.gridx = 3;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn33 = new Button("9");
		layout.setConstraints(btn33, constraints);
		frame.add(btn33);
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 4;
		constraints.gridy = 3;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn34 = new Button("*");
		layout.setConstraints(btn34, constraints);
		frame.add(btn34);
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn41 = new Button("4");
		layout.setConstraints(btn41, constraints);
		frame.add(btn41);
		
		constraints.gridx = 2;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn42 = new Button("5");
		layout.setConstraints(btn42, constraints);
		frame.add(btn42);
		
		constraints.gridx = 3;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn43 = new Button("6");
		layout.setConstraints(btn43, constraints);
		frame.add(btn43);
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 4;
		constraints.gridy = 4;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn44 = new Button("-");
		layout.setConstraints(btn44, constraints);
		frame.add(btn44);
		
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn51 = new Button("1");
		layout.setConstraints(btn51, constraints);
		frame.add(btn51);
		
		constraints.gridx = 2;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn52 = new Button("2");
		layout.setConstraints(btn52, constraints);
		frame.add(btn52);
		
		constraints.gridx = 3;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn53 = new Button("3");
		layout.setConstraints(btn53, constraints);
		frame.add(btn53);
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 4;
		constraints.gridy = 5;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn54 = new Button("+");
		layout.setConstraints(btn54, constraints);
		frame.add(btn54);
		
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn61 = new Button("0");
		layout.setConstraints(btn61, constraints);
		frame.add(btn61);
		
		constraints.gridx = 2;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn62 = new Button(".");
		layout.setConstraints(btn62, constraints);
		frame.add(btn62);
		
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 3;
		constraints.gridy = 6;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Button btn63 = new Button("=");
		layout.setConstraints(btn63, constraints);
		frame.add(btn63);
		
//		btn21.addMouseListener(new MouseListener() {
//			public void mouseReleased(MouseEvent e) {}
//			public void mousePressed(MouseEvent e) {}
//			public void mouseExited(MouseEvent e) {}
//			public void mouseEntered(MouseEvent e) {}
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("btn21-鼠标完成单击事件事件");
//			}
//		});
	}
}
/**
 * 窗口监听
 * @author Administrator
 *
 */
class MywindowListener extends WindowAdapter{ 
	public void windowClosing(WindowEvent e) {
		Window window = (Window) e.getComponent();
		window.dispose();
	}
}
/**
 * 按钮监听
 * @author Administrator
 *
 */
class MymouseListener extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		System.out.println("btn21-鼠标完成单击事件事件");
	}
}
