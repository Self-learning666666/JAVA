package item;

public class courseItem {
private String Cid;
private String Cname;
private String Tid;
private String Cinfo;

public courseItem() {
	super();
}

public courseItem(String cid, String cname, String tid, String cinfo) {
	super();
	Cid = cid;
	Cname = cname;
	Tid = tid;
	Cinfo = cinfo;
}

public String getCid() {
	return Cid;
}

public void setCid(String cid) {
	Cid = cid;
}

public String getCname() {
	return Cname;
}

public void setCname(String cname) {
	Cname = cname;
}

public String getTid() {
	return Tid;
}

public void setTid(String tid) {
	Tid = tid;
}

public String getCinfo() {
	return Cinfo;
}

public void setCinfo(String cinfo) {
	Cinfo = cinfo;
}


}
