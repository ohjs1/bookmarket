package db.dto;

import java.util.Date;

public class Users {
	private int jnum;
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String email;
	private int cash;
	private Date join_date;
	
	
	public Users() {}
	
	public Users(int jnum, String id, String pw, String name, String addr, String email, int cash, Date join_date) {
		this.jnum = jnum;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.email = email;
		this.cash = cash;
		this.join_date = join_date;
	}
	
	public int getJnum() {
		return jnum;
	}
	public void setJnum(int jnum) {
		this.jnum = jnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
}
