package item;

public class gradeItem {
private String Sid;
private String Cid;
private int Grade;

public gradeItem() {
	super();
}

public gradeItem(String sid, String cid, int grade) {
	super();
	Sid = sid;
	Cid = cid;
	Grade = grade;
}

public String getSid() {
	return Sid;
}

public void setSid(String sid) {
	Sid = sid;
}

public String getCid() {
	return Cid;
}

public void setCid(String cid) {
	Cid = cid;
}

public int getGrade() {
	return Grade;
}

public void setGrade(int grade) {
	Grade = grade;
}

}
