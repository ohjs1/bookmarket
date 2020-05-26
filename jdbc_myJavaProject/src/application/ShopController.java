package application;

import db.dao.UsersDate;
import db.dto.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ShopController {
	@FXML private TextField shopUserId;
	@FXML private TextField showUserPw;
	@FXML private TextField cashChargeField;
	
	@FXML private TextField shopId;
	@FXML private TextField shopPw;
	@FXML private TextField shopName;
	@FXML private TextField shopAddr;
	@FXML private TextField shopEmail;
	
	static String ID ="";
	
	@FXML
	private void showLogin(ActionEvent event) {
		ID =UsersDate.login(shopUserId.getText(), showUserPw.getText(), 0);
	}
	
	Users user =new Users();
	
	@FXML
	public void shopAddUser() {
		new Windows().userjoinWindow();
	}
	
	@FXML
	public void shopAddUserCommit() {
		user.setId(shopId.getText());
		user.setPw(shopPw.getText());
		user.setName(shopName.getText());
		user.setAddr(shopAddr.getText());
		user.setEmail(shopEmail.getText());
		
		//유저 회원 가입
		UsersDate.addAdminUser(user, 0);
	}
	
	
	@FXML
	public void cashCharge() {
		new Windows().cashCharge();
	}
	
	@FXML
	public void cashChargeSummit() {
		//캐쉬충전
		UsersDate.cashChargeUpdate(Integer.parseInt(cashChargeField.getText()), ID);
	}
	
	@FXML
	public void deleteUser() {
		//유저 삭제
		UsersDate.deleteUserCommit(ID);
	}
	
	@FXML
	public void onShopWindow() {
		new Windows().buyBooksWindow();
	}
}
