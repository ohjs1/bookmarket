package db.dto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Memberlist {
	private SimpleIntegerProperty memberNum;
	private SimpleStringProperty memberId;
	private SimpleStringProperty memberName;
	private SimpleStringProperty memberAddr;
	private SimpleStringProperty memberEmail;
	private SimpleStringProperty memberJoinDate;
	
	public Memberlist() {
		this.memberNum =new SimpleIntegerProperty();
		this.memberId =new SimpleStringProperty();
		this.memberName =new SimpleStringProperty();
		this.memberAddr =new SimpleStringProperty();
		this.memberEmail =new SimpleStringProperty();
		this.memberJoinDate =new SimpleStringProperty();
	}
	
	public Memberlist(int memberNum, String memberId, String memberName, String memberAddr, 
			String memberEmail, String memberJoinDate) {
		
		this.memberNum =new SimpleIntegerProperty(memberNum);
		this.memberId =new SimpleStringProperty(memberId);
		this.memberName =new SimpleStringProperty(memberName);
		this.memberAddr =new SimpleStringProperty(memberAddr);
		this.memberEmail =new SimpleStringProperty(memberEmail);
		this.memberJoinDate =new SimpleStringProperty(memberJoinDate);
	}
	
	public int getMemberNum() {
		return memberNum.get();
	}
	
	public void setMemberNum(int memberNum) {
		this.memberNum.set(memberNum);
	}
	
	public String getMemberId() {
		return memberId.get();
	}
	
	public void setMemberId(String memberId) {
		this.memberId.set(memberId);
	}
	
	public String getMemberName() {
		return memberName.get();
	}
	
	public void setMemberName(String memberName) {
		this.memberName.set(memberName);
	}
	
	public String getMemberAddr() {
		return memberAddr.get();
	}
	
	public void setMemberAddr(String memberAddr) {
		this.memberAddr.set(memberAddr);
	}
	
	public String getMemberEmail() {
		return memberEmail.get();
	}
	
	public void setMemberEmail(String memberEmail) {
		this.memberEmail.set(memberEmail);
	}
	
	public String getMemberJoinDate() {
		return memberJoinDate.get();
	}
	
	public void setMemberJoinDate(String memberJoinDate) {
		this.memberJoinDate.set(memberJoinDate);
	}
	
}
