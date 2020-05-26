package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import db.ConnDB;
import db.dao.UsersDate;
import db.dto.Booklist;
import db.dto.Memberlist;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;





public class JoinController implements Initializable {
	@FXML private TableView<Booklist> BookListTableView;
	@FXML private TableView<Memberlist> MemberListTableView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TableColumn tcBookNum =BookListTableView.getColumns().get(0);
		tcBookNum.setCellValueFactory(new PropertyValueFactory("bookNum"));
		tcBookNum.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcBookName =BookListTableView.getColumns().get(1);
		tcBookName.setCellValueFactory(new PropertyValueFactory("bookName"));
		tcBookName.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcBookPrice =BookListTableView.getColumns().get(2);
		tcBookPrice.setCellValueFactory(new PropertyValueFactory("bookPrice"));
		tcBookPrice.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcBookType =BookListTableView.getColumns().get(3);
		tcBookType.setCellValueFactory(new PropertyValueFactory("bookType"));
		tcBookType.setStyle("-fx-alignment: CENTER;");
		//Table1
		
		
		TableColumn tcMemberNum =MemberListTableView.getColumns().get(0);
		tcMemberNum.setCellValueFactory(new PropertyValueFactory("memberNum"));
		tcMemberNum.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcMemberId =MemberListTableView.getColumns().get(1);
		tcMemberId.setCellValueFactory(new PropertyValueFactory("memberId"));
		tcMemberId.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcMemberName =MemberListTableView.getColumns().get(2);
		tcMemberName.setCellValueFactory(new PropertyValueFactory("memberName"));
		tcMemberName.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcMemberAddr =MemberListTableView.getColumns().get(3);
		tcMemberAddr.setCellValueFactory(new PropertyValueFactory("memberAddr"));
		tcMemberAddr.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcMemberEmail =MemberListTableView.getColumns().get(4);
		tcMemberEmail.setCellValueFactory(new PropertyValueFactory("memberEmail"));
		tcMemberEmail.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcMemberJoinDate =MemberListTableView.getColumns().get(5);
		tcMemberJoinDate.setCellValueFactory(new PropertyValueFactory("memberJoinDate"));
		tcMemberJoinDate.setStyle("-fx-alignment: CENTER;");
		//Table2
		
		booklistBuildData();
		memberlistBuildDate();
	}
	
	private ObservableList<Booklist> booklistDate;
	private ObservableList<Memberlist> memberlistDate;
	
	private Connection con1 =null;	
	private ResultSet rs1 =null;
	
	private Connection con2 =null;	
	private ResultSet rs2 =null;
	
	public void booklistBuildData() {
		try {
			booklistDate = FXCollections.observableArrayList();
			
			con1 =db.ConnDB.getCon();
			String sql ="select ty.num, book_name, book_price, book_type from booktype ty, booklist li where ty.num = li.num";
			rs1 =con1.createStatement().executeQuery(sql);
			
			while(rs1.next()) {
				Booklist booklist =new Booklist();
				
				booklist.setBookNum(rs1.getInt("num"));
				booklist.setBookName(rs1.getString("book_name"));
				booklist.setBookPrice(rs1.getString("book_price"));
				booklist.setBookType(rs1.getString("book_type"));
				
				booklistDate.add(booklist);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ConnDB.closing(con1, null, rs1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		BookListTableView.setItems(booklistDate);
	}
	
	public void memberlistBuildDate() {
		try {
			memberlistDate = FXCollections.observableArrayList();
			
			con2 =db.ConnDB.getCon();
			String sql ="select jnum, id, name, addr, email, join_date from join_users";
			rs2 =con2.createStatement().executeQuery(sql);
			
			while(rs2.next()) {
				Memberlist memberlist =new Memberlist();
				
				memberlist.setMemberNum(rs2.getInt("jnum"));
				memberlist.setMemberId(rs2.getString("id"));
				memberlist.setMemberName(rs2.getString("name"));
				memberlist.setMemberAddr(rs2.getString("addr"));
				memberlist.setMemberEmail(rs2.getString("email"));
				memberlist.setMemberJoinDate(rs2.getString("join_date"));
				
				memberlistDate.add(memberlist);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ConnDB.closing(con2, null, rs2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		MemberListTableView.setItems(memberlistDate);
	}
	
	@FXML TextField bookName;
	@FXML TextField bookPrice;
	@FXML TextField bookType;
	@FXML TextField bookImg;
	@FXML TextField bookCnt;
	@FXML TextField bookAuther;
	
	@FXML
	private void createNewBook() {
		UsersDate.addBook(bookName.getText(), bookPrice.getText(),
				bookType.getText(), bookImg.getText(), Integer.parseInt(bookCnt.getText()), bookAuther.getText());
	}
	
}
