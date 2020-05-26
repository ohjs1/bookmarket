package application;

import db.dao.UsersDate;
import db.dto.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RootController {
	@FXML private TextField textId;
	
	@FXML private TextField textPw;
	@FXML private TextField id;
	@FXML private TextField address;
	@FXML private TextField name;
	@FXML private TextField email;
	@FXML private TextField password;
	
	@FXML private TextField updateId;
	@FXML private TextField updatePw;
	@FXML private TextField updateName;
	@FXML private TextField updateAddr;
	@FXML private TextField updateEmail;
	
	@FXML private TextField deleteField;
	
	@FXML
	private void login(ActionEvent event) {	//로그인
		UsersDate.login(textId.getText(), textPw.getText(), 1);
	}
	
	@FXML
	private void newManager(ActionEvent event) {	//관리자 등록창
		new Windows().addUsers();
	}
	
	@FXML
	private void submitUser() {	//관리자 계정 추가
		UsersDate.addAdminUser(new Users(0, id.getText(), password.getText(),
				name.getText(), address.getText(), email.getText(), 0, null), 1);
	}
	
	@FXML
	public void viewList() {
		new Windows().viewList();
	}
	
	@FXML
	public void updateUserView() {
		new Windows().updateUser();
	}
	
	@FXML
	public void updateUser() {
		UsersDate.updateUserCommit(updateId.getText(), updatePw.getText(), updateName.getText(),
				updateAddr.getText(), updateEmail.getText());
	}
	
	@FXML
	public void deleteUser() {
		new Windows().deleteWindow();
	}
	
	@FXML
	public void deleteUserSucess() {
		UsersDate.deleteUserCommit(deleteField.getText());
	}
	
}
