package item;

public class managerItem {
private String Mid;
private String Mpasswd;

public managerItem() {
	super();
}

public managerItem(String mid, String mpasswd) {
	super();
	Mid = mid;
	Mpasswd = mpasswd;
}

public String getMid() {
	return Mid;
}

public void setMid(String mid) {
	Mid = mid;
}

public String getMpasswd() {
	return Mpasswd;
}

public void setMpasswd(String mpasswd) {
	Mpasswd = mpasswd;
}

}
