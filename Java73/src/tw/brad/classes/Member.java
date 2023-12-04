package tw.brad.classes;

public class Member {
	private int id;
	private String account, cname;
	public Member(int id, String account, String cname) {
		super();
		this.id = id;
		this.account = account;
		this.cname = cname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getId() {
		return id;
	}
	
	
}
