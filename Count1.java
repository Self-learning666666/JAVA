package chapter8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Count1 extends JFrame {
//	按下的键组成的字符串
	StringBuffer str = new StringBuffer();
	StringBuffer listStr = new StringBuffer();
	ArrayList list = new ArrayList();
	int flag;
	public Count1() {

//		框架窗口
		this.setTitle("计算器");
		this.setSize(400, 550);
		this.setLocation(500, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
//		创建布局管理器
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		
//		显示框	
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
//		文本域
//		JTextArea show = new JTextArea(50, 2);
//		layout.setConstraints(show, constraints);

//		文本框
		JTextField show = new JTextField("0");
		show.setFont(new Font("宋体", Font.PLAIN, 30));
		layout.setConstraints(show, constraints);
		show.setHorizontalAlignment(JTextField.RIGHT);
		show.setEditable(false);
		this.add(show);
		
//		添加按钮
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn21 = new JButton("C");
		layout.setConstraints(btn21, constraints);
		this.add(btn21);
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn21.getText());
				if(listStr.length() == 0) {
					show.setText("0");
				}else {
					str.deleteCharAt(str.length()-1);
					listStr.deleteCharAt(listStr.length()-1);
					show.setText(listStr.toString());
//					System.out.print(str.toString());
				}
			}
		});
		
//		public StringBuffer addStr(JButton btn) {
//			btn.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					System.out.print(btn21.getText());
//				}
//			});
//		}
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn22 = new JButton("clear");
		layout.setConstraints(btn22, constraints);
		this.add(btn22);
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn22.getText());
				str.delete(0, str.length());
				listStr.delete(0, listStr.length());
				show.setText("0");
//				System.out.print(str.toString());
			}
		});
		
		constraints.gridx = 3;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn23 = new JButton("%");
		layout.setConstraints(btn23, constraints);
		this.add(btn23);
		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn23.getText());
				list.add(str.toString());
				str.delete(0, str.length());
				listStr.append(btn23.getText());
				show.setText(listStr.toString());
				flag = 5;
			}
		});
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 4;
		constraints.gridy = 2;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn24 = new JButton("/");
		layout.setConstraints(btn24, constraints);
		this.add(btn24);
		btn24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn24.getText());
				list.add(str.toString());
				str.delete(0, str.length());
				listStr.append(btn24.getText());
				show.setText(listStr.toString());
				flag = 4;
			}
		});
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn31 = new JButton("7");
		layout.setConstraints(btn31, constraints);
		this.add(btn31);
		btn31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn31.getText());
				str.append(btn31.getText());
//				System.out.print(str);
				listStr.append(btn31.getText());
				show.setText(listStr.toString());
				
				
			}
		});
		
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn32 = new JButton("8");
		layout.setConstraints(btn32, constraints);
		this.add(btn32);
		btn32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn32.getText());
				str.append(btn32.getText());
//				System.out.print(str);
				listStr.append(btn32.getText());
				show.setText(listStr.toString());
			}
		});
		
		constraints.gridx = 3;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn33 = new JButton("9");
		layout.setConstraints(btn33, constraints);
		this.add(btn33);
		btn33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn33.getText());
				str.append(btn33.getText());
//				System.out.print(str);
				listStr.append(btn33.getText());
				show.setText(listStr.toString());
				
			}
		});
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 4;
		constraints.gridy = 3;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn34 = new JButton("*");
		layout.setConstraints(btn34, constraints);
		this.add(btn34);
		btn34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn34.getText());
				list.add(str.toString());
				str.delete(0, str.length());
				listStr.append(btn34.getText());
				show.setText(listStr.toString());
				flag = 3;
			}
		});
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn41 = new JButton("4");
		layout.setConstraints(btn41, constraints);
		this.add(btn41);
		btn41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn41.getText());
				str.append(btn41.getText());
//				System.out.print(str);
				listStr.append(btn41.getText());
				show.setText(listStr.toString());
			}
		});
		
		constraints.gridx = 2;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn42 = new JButton("5");
		layout.setConstraints(btn42, constraints);
		this.add(btn42);
		btn42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn42.getText());
				str.append(btn42.getText());
//				System.out.print(str);
				listStr.append(btn42.getText());
				show.setText(listStr.toString());
				
			}
		});
		
		constraints.gridx = 3;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn43 = new JButton("6");
		layout.setConstraints(btn43, constraints);
		this.add(btn43);
		btn43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn43.getText());
				str.append(btn43.getText());
//				System.out.print(str);
				listStr.append(btn43.getText());
				show.setText(listStr.toString());
			}
		});
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 4;
		constraints.gridy = 4;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn44 = new JButton("-");
		layout.setConstraints(btn44, constraints);
		this.add(btn44);
		btn44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn44.getText());
				list.add(str.toString());
				str.delete(0, str.length());
				listStr.append(btn44.getText());
				show.setText(listStr.toString());
				flag = 2;
			}
		});
		
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn51 = new JButton("1");
		layout.setConstraints(btn51, constraints);
		this.add(btn51);
		btn51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn51.getText());
				str.append(btn51.getText());
//				System.out.print(str);
				listStr.append(btn51.getText());
				show.setText(listStr.toString());
			}
		});
		
		constraints.gridx = 2;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn52 = new JButton("2");
		layout.setConstraints(btn52, constraints);
		this.add(btn52);
		btn52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn52.getText());
				str.append(btn52.getText());
//				System.out.print(str);
				listStr.append(btn52.getText());
				show.setText(listStr.toString());
			}
		});
		
		constraints.gridx = 3;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn53 = new JButton("3");
		layout.setConstraints(btn53, constraints);
		this.add(btn53);
		btn53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn53.getText());
				str.append(btn53.getText());
				System.out.print(str);
				listStr.append(btn53.getText());
				show.setText(listStr.toString());
			}
		});
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 4;
		constraints.gridy = 5;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn54 = new JButton("+");
		layout.setConstraints(btn54, constraints);
		this.add(btn54);
		btn54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn54.getText());
				list.add(str.toString());
				str.delete(0, str.length());
				listStr.append(btn54.getText());
				show.setText(listStr.toString());
				flag = 1;
			}
		});
		
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn61 = new JButton("0");
		layout.setConstraints(btn61, constraints);
		this.add(btn61);
		btn61.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn61.getText());
				str.append(btn61.getText());
//				System.out.print(str);
				listStr.append(btn61.getText());
				show.setText(listStr.toString());
			}
		});
		
		constraints.gridx = 2;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn62 = new JButton(".");
		layout.setConstraints(btn62, constraints);
		this.add(btn62);
		btn62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn62.getText());
				str.append(btn62.getText());
//				System.out.print(str);
				listStr.append(btn62.getText());
				show.setText(listStr.toString());
			}
		});
		
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = 3;
		constraints.gridy = 6;
		constraints.weightx = 1;
		constraints.weighty = 1;
		JButton btn63 = new JButton("=");
		layout.setConstraints(btn63, constraints);
		this.add(btn63);
		btn63.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(btn63.getText());
				list.add(str.toString());
				float yin2 = Float.parseFloat(list.get(1).toString());
				float yin1 = Float.parseFloat(list.get(0).toString());
//				Integer chu = Integer.parseInt(list.get(1).toString());
//				Integer bei = Integer.parseInt(list.get(0).toString());
				Integer chu = Math.round(Float.parseFloat(list.get(1).toString()));
				Integer bei = Math.round(Float.parseFloat(list.get(0).toString()));
				list.clear();
//				System.out.print(yin1 + "\t" + yin2);
				str.delete(0, str.length());
				listStr.delete(0, listStr.length());
				switch(flag) {
				case 1:
					show.setText("" + (yin1+yin2));
					break;
				case 2:

					show.setText("" + (yin1-yin2));
					break;
				case 3:
					show.setText("" + (yin1*yin2));
					break;
				case 4:
					show.setText("" + (yin1/yin2));
					break;
				case 5:
					show.setText("" + (bei%chu));
					break;
				}			
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Count1();
	}

}
