package item;

public class teacherItem {
private String Tid;
private String Tname;
private String Tpasswd;

public teacherItem() {
	super();
}

public teacherItem(String tid, String tname, String tpasswd) {
	super();
	Tid = tid;
	Tname = tname;
	Tpasswd = tpasswd;
}

public String getTid() {
	return Tid;
}

public void setTid(String tid) {
	Tid = tid;
}

public String getTname() {
	return Tname;
}

public void setTname(String tname) {
	Tname = tname;
}

public String getTpasswd() {
	return Tpasswd;
}

public void setTpasswd(String tpasswd) {
	Tpasswd = tpasswd;
}

}
