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
	
	//�α��μ����� ���� â
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
	
	//������ ȸ������
	public void addUsers() {
		fxmlloader =new FXMLLoader(getClass().getResource("addAdminUser.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
//			stage.initStyle(StageStyle.UNDECORATED);
			stage.setResizable(false);
			stage.setTitle("ȸ�� ����");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//ȸ������ ���̺�
	public void viewList() {
		fxmlloader =new FXMLLoader(getClass().getResource("join.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("ȸ�� ����");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//���� ���� ����â
	public void updateUser() {
		fxmlloader =new FXMLLoader(getClass().getResource("update.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("ȸ�� ���� ����");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//ȸ�� ���� â
	public void deleteWindow() {
		fxmlloader =new FXMLLoader(getClass().getResource("delete.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("ȸ�� ����");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//���� �α��� �޴�
	public void userLoginMenuWindow() {
		fxmlloader =new FXMLLoader(getClass().getResource("shopMenu.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("å ������ ���Ű��� ȯ���մϴ�.");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//ĳ�� ���� â
	public void cashCharge() {
		fxmlloader =new FXMLLoader(getClass().getResource("cash.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("ĳ�� ����");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//���� ȸ�� ���� â
	public void userjoinWindow() {
		fxmlloader =new FXMLLoader(getClass().getResource("userJoinForm.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("���� ȸ�� ����");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//å���� ������ â
	public void buyBooksWindow() {
		fxmlloader =new FXMLLoader(getClass().getResource("bookmaket.fxml"));
		try {
			root =(Parent)fxmlloader.load();
			stage =new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("���ͳ� ���� [WEB BOOK]");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}