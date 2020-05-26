package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import db.ConnDB;
import db.dto.ShopItems;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ShopViewController implements Initializable {

	@FXML private ListView<String> listView;
	@FXML private Text cashText;
	@FXML private TableView<ShopItems> tableViewItem;
	@FXML private ImageView imageView;
	
	static int CASH =0;
	public static boolean CASH_CHK =true;
	
	private ObservableList<ShopItems> shopItemsDate;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(FXCollections.observableArrayList(
				"판타지","무협","교육"
		));
		
		TableColumn tcItemName =tableViewItem.getColumns().get(0);
		tcItemName.setCellValueFactory(new PropertyValueFactory("bookName"));
		tcItemName.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcItemAuthor =tableViewItem.getColumns().get(1);
		tcItemAuthor.setCellValueFactory(new PropertyValueFactory("bookAuthor"));
		tcItemAuthor.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcItemPrice =tableViewItem.getColumns().get(2);
		tcItemPrice.setCellValueFactory(new PropertyValueFactory("bookPrice"));
		tcItemPrice.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcCntPrice =tableViewItem.getColumns().get(3);
		tcCntPrice.setCellValueFactory(new PropertyValueFactory("bookCnt"));
		tcCntPrice.setStyle("-fx-alignment: CENTER;");
		
		itemlistBuildDataDate();
		setCashText();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		//테이블뷰 상태변화 감지하는 셀렉션모델객체
		tableViewItem.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				ShopItems model = tableViewItem.getSelectionModel().getSelectedItem();
				System.out.println("선택한 책 가격:"+model.getBookPrice());
				CASH =model.getBookPrice();
			}
		});
	}
	
	
	private Connection conc =null;
	private PreparedStatement pstmtc =null;
	private ResultSet rsc =null;	
	
	public void setCashText() {
		try {
			conc =ConnDB.getCon();
			String sql ="select cash from join_users where id=?";
			pstmtc =conc.prepareStatement(sql);
			pstmtc.setString(1, ShopController.ID);
			rsc =pstmtc.executeQuery();
			rsc.next();
			cashText.setText("현재 잔액 : "+(Integer.parseInt(rsc.getString("cash"))) + "원");
			System.out.println("현재 잔액 :"+Integer.parseInt(rsc.getString(1)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnDB.closing(con, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	private Connection con =null;
	private ResultSet rs =null;
	private PreparedStatement pstmt =null;
	
	public void itemlistBuildDataDate() {
		
		shopItemsDate =FXCollections.observableArrayList();
		
		try {
			con =ConnDB.getCon();
			String sql ="select book_name, author, book_price, stock_cnt from booklist bl, booktype bt, stocksale st where (bl.num = bt.num) and (bt.num = st.num)";
			pstmt =con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				ShopItems items =new ShopItems();
				items.setBookAuthor(rs.getString("author"));
				items.setBookName(rs.getString("book_name"));
				items.setBookPrice(rs.getInt("book_price"));
				items.setBookCnt(rs.getInt("stock_cnt"));
				
				shopItemsDate.add(items);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnDB.closing(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		tableViewItem.setItems(shopItemsDate);

	}
	
	
	private Connection conb =null;
	private PreparedStatement pstmtb =null;
	private PreparedStatement pstmtb2 =null;
	private ResultSet rsb =null;
	Alert alert = new Alert(AlertType.INFORMATION);
	
	@FXML
	public void bookBuyCommit() {
		try {
			conb =ConnDB.getCon();
			conb.setAutoCommit(false);
			
			//트랜젝션 시작
			String sql ="select cash from join_users where id=?";
			pstmtb =conb.prepareStatement(sql);
			pstmtb.setString(1, ShopController.ID);
			rsb =pstmtb.executeQuery();
			
			rsb.next();
			
			int cashp =rsb.getInt("cash");
			System.out.println("내캐시 : " + cashp);
			
			
			
			if(cashp >= CASH && CASH_CHK == true) {
				if(cashp == CASH) {
					CASH_CHK = false;
				}
				CASH =cashp - CASH;
				String sql2 ="update join_users set cash=? where id=?";
				pstmtb2 =conb.prepareStatement(sql2);
				
				pstmtb2.setInt(1, CASH);
				pstmtb2.setString(2, ShopController.ID);
				pstmtb2.executeUpdate();
				
				conb.commit(); //작업완료!
				alert.setHeaderText("작업 완료됨!");
				alert.showAndWait();
				System.out.println("작업완료됨");
				setCashText();
			} else {
				System.out.println("돈이 부족합니다.");
				alert.setHeaderText("돈이 부족합니다.");
				alert.showAndWait();
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				conb.rollback();
				System.out.println("작업롤백됨");
				//작업 롤백됨
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		} finally {
			try {
				ConnDB.closing(conb, pstmtb, rsb);
				ConnDB.closing(pstmtb2);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
