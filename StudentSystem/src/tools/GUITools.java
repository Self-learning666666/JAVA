package tools;
import java.awt.*;
import javax.swing.*;
public class GUITools {
//	JAVA提供的GUITools默认工具类对象
	static Toolkit kit = Toolkit.getDefaultToolkit();
	/**
	 * 将指定组件屏幕剧中
	 * @param c
	 */
	public static void center(Component c) {
		int x = (kit.getScreenSize().width - c.getWidth())/2;
		int y = (kit.getScreenSize().height - c.getHeight())/2;
		c.setLocation(x, y);
	}
	/**
	 * 为指定窗口设置图标标题
	 * @param frame
	 * @param titleIconPath
	 */
	public static void setTitleImage(JFrame frame, String titleIconPath) {
		frame.setIconImage(kit.createImage(titleIconPath));
	}
}
