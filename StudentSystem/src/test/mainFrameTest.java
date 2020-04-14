package test;
import test.mainFrameTest;
import view.mainFrame;

public class mainFrameTest extends mainFrame {
	public static void main(String[] args) {
		
//		设置窗口显隐
		new mainFrameTest().setVisible(true);
	}
//	操作菜单
	public void showAdminDialog() {
		System.out.println("进入管理页面");
	}
}