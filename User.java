package in.soft.entity;

public class User {

	private Integer uid;
	private String uname;
	private float usal;
	private String Uadd;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public float getUsal() {
		return usal;
	}
	public void setUsal(float usal) {
		this.usal = usal;
	}
	public String getUadd() {
		return Uadd;
	}
	public void setUadd(String uadd) {
		Uadd = uadd;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", usal=" + usal + ", Uadd=" + Uadd + "]";
	}
	
	
}
