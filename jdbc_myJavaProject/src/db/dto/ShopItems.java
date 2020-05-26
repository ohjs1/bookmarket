package db.dto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ShopItems {
	SimpleStringProperty bookName;
	SimpleStringProperty bookAuthor;
	SimpleIntegerProperty bookPrice;
	SimpleIntegerProperty bookCnt;
	
	public ShopItems() {
		this.bookName =new SimpleStringProperty();
		this.bookAuthor =new SimpleStringProperty();
		this.bookPrice =new SimpleIntegerProperty();
		this.bookCnt =new SimpleIntegerProperty();
	}
	
	public ShopItems(String bookName, String bookAuthor, int bookPrice, int bookCnt) {
		this.bookName =new SimpleStringProperty(bookName);
		this.bookAuthor =new SimpleStringProperty(bookAuthor);
		this.bookPrice =new SimpleIntegerProperty(bookPrice);
		this.bookCnt =new SimpleIntegerProperty(bookCnt);
	}
	
	public void setBookCnt(int bookCnt) {
		this.bookCnt.set(bookCnt);
	}
	
	public int getBookCnt() {
		return bookCnt.get();
	}
	
	public void setBookName(String bookName) {
		this.bookName.set(bookName);
	}
	
	public String getBookName() {
		return bookName.get();
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor.set(bookAuthor);
	}
	
	public String getBookAuthor() {
		return bookAuthor.get();
	}
	
	public void setBookPrice(int bookPrice) {
		this.bookPrice.set(bookPrice);
	}
	
	public int getBookPrice() {
		return bookPrice.get();
	}
}
