package fruitstore.controller;
import fruitstore.view.*;
public class MainFrameController extends AbstractMainFrame {

	@Override
	public void showAdminDialog() {
		// TODO Auto-generated method stub
		new AdminDialogController(this, true).setVisible(true);
	}
	
}
