package fruitstore.test;
import fruitstore.view.AbstractMainFrame;
@SuppressWarnings("serial")
public class AbstractMainFrameTest extends AbstractMainFrame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AbstractMainFrameTest().setVisible(true);
	}
	public void showAdminDialog() {
		System.out.println("进入管理页面");
	}
}
