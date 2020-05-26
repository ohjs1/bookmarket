package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Windows {
	
	FXMLLoader fxmlloader =null;
	Parent root =null;
	Stage stage =null;
	
	//로그인성공시 띄우는 창
	public void loginSuccess() {
		fxmlloader =new FXMLLoader(getClass().getResource("main.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
//			stage.initStyle(StageStyle.UNDECORATED);
			stage.setResizable(false);
			stage.setTitle("Main");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//관리자 회원가입
	public void addUsers() {
		fxmlloader =new FXMLLoader(getClass().getResource("addAdminUser.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
//			stage.initStyle(StageStyle.UNDECORATED);
			stage.setResizable(false);
			stage.setTitle("회원 가입");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//회원정보 테이블
	public void viewList() {
		fxmlloader =new FXMLLoader(getClass().getResource("join.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("회원 정보");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//유저 정보 수정창
	public void updateUser() {
		fxmlloader =new FXMLLoader(getClass().getResource("update.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("회원 정보 수정");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//회원 삭제 창
	public void deleteWindow() {
		fxmlloader =new FXMLLoader(getClass().getResource("delete.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("회원 삭제");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//유저 로그인 메뉴
	public void userLoginMenuWindow() {
		fxmlloader =new FXMLLoader(getClass().getResource("shopMenu.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("책 상점에 오신것을 환영합니다.");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//캐시 충전 창
	public void cashCharge() {
		fxmlloader =new FXMLLoader(getClass().getResource("cash.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("캐시 충전");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//유저 회원 가입 창
	public void userjoinWindow() {
		fxmlloader =new FXMLLoader(getClass().getResource("userJoinForm.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("유저 회원 가입");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//책구입 가능한 창
	public void buyBooksWindow() {
		fxmlloader =new FXMLLoader(getClass().getResource("bookmaket.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("인터넷 서점 [WEB BOOK]");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
