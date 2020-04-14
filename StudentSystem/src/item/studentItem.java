package item;

public class studentItem {
 private String Sid;
 private String Sname;
 private String Spasswd;
 private int Sex;
 private String Collage;
 private String City;
 
 public studentItem() {
	 
 }

public studentItem(String sid, String sname, String spasswd, int sex, String collage, String city) {
	super();
	this.Sid = sid;
	this.Sname = sname;
	this.Spasswd = spasswd;
	this.Sex = sex;
	this.Collage = collage;
	this.City = city;
}

public String getSid() {
	return this.Sid;
}

public void setSid(String sid) {
	this.Sid = sid;
}

public String getSname() {
	return this.Sname;
}

public void setSname(String sname) {
	this.Sname = sname;
}

public String getSpasswd() {
	return this.Spasswd;
}

public void setSpasswd(String spasswd) {
	this.Spasswd = spasswd;
}

public int getSex() {
	return this.Sex;
}

public void setSex(int sex) {
	this.Sex = sex;
}

public String getCollage() {
	return this.Collage;
}

public void setCollage(String collage) {
	this.Collage = collage;
}

public String getCity() {
	return this.City;
}

public void setCity(String city) {
	this.City = city;
}

}
