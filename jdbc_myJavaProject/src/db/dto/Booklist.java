package db.dto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Booklist {
	private SimpleIntegerProperty bookNum;
    private SimpleStringProperty bookName;
    private SimpleStringProperty bookPrice;
    private SimpleStringProperty bookType;
    
    public Booklist() {
    	this.bookNum =new SimpleIntegerProperty();
    	this.bookName =new SimpleStringProperty();
    	this.bookPrice =new SimpleStringProperty();
    	this.bookType =new SimpleStringProperty();
    }
	
	public Booklist(int bookNum, String bookName, String bookPrice, String bookType) {
		this.bookNum =new SimpleIntegerProperty(bookNum);
		this.bookName =new SimpleStringProperty(bookName);
		this.bookPrice =new SimpleStringProperty(bookPrice);
		this.bookType =new SimpleStringProperty(bookType);
	}
	
	
	public int getBookNum() {
		return bookNum.get();
	}
	
	public void setBookNum(int bookNum) {
		this.bookNum.set(bookNum);
	}
	
	public String getBookType() {
		return bookType.get();
	}
	
	public void setBookType(String bookName) {
		this.bookType.set(bookName);
	}
	
	public String getBookPrice() {
		return bookPrice.get();
	}
	
	public void setBookPrice(String bookPrice) {
		this.bookPrice.set(bookPrice);
	}
	
	public String getBookName() {
		return bookName.get();
	}
	
	public void setBookName(String bookName) {
		this.bookName.set(bookName);
	}
}
