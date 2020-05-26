package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.ShopViewController;
import application.Windows;
import db.ConnDB;
import db.dto.Users;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UsersDate {
	public static String login(String id, String pw, int master) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		Alert alert = new Alert(AlertType.INFORMATION);
		try {
			con =db.ConnDB.getCon();
			String sql ="select id, pw from join_users where master=?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, master);
			rs =pstmt.executeQuery();

			while(rs.next()) {
				String db_id =rs.getString(1);
				String db_pw =rs.getString(2);

				
				if(id.equals(db_id) && pw.equals(db_pw) && master == 1) {
					System.out.println("로그인 성공!");
					alert.setHeaderText(db_id + " 관리자 로그인!");
					alert.showAndWait();
					new Windows().loginSuccess();
					return id;
					
				} else if(id.equals(db_id) && pw.equals(db_pw) && master == 0) {
					alert.setHeaderText(db_id + " 유저 로그인!");
					alert.showAndWait();
					new Windows().userLoginMenuWindow();
					return id;
				} 
			}
			System.out.println("로그인 실패!");
			alert.setHeaderText(" 로그인 실패! ");
			alert.showAndWait();
			return null;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			alert.setHeaderText(e.getMessage() + " 로그인 에러!");
			alert.showAndWait();
		} finally {
			try {
				ConnDB.closing(con, pstmt, rs);
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
		return null;
	}
	
	public static void addAdminUser(Users user, int masterNumber) {
		Connection con =null;
		PreparedStatement pstmt =null;
		Alert alert = new Alert(AlertType.WARNING);
		try {
			con =db.ConnDB.getCon();
			String sql ="insert into join_users values(addUser_seq.nextval, ?, ?, ?, ?, ?,null, sysdate, ?)";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getAddr());
			pstmt.setString(5, user.getEmail());
			pstmt.setInt(6, masterNumber);
			
			pstmt.executeUpdate();
			
			
			alert.setHeaderText(user.getId() + " 사용자 등록 완료!");
			alert.showAndWait();

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			alert.setHeaderText(e.getMessage() + "\t사용자 등록 실패!");
			alert.showAndWait();
		} finally {
			try {
				db.ConnDB.closing(con, pstmt, null);
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	public static void addBook(String bookName, String bookPrice, String bookType, String img, int cnt, String auther) {
		Connection con =null;
		PreparedStatement pstmt1 =null;
		PreparedStatement pstmt2 =null;
		PreparedStatement pstmt3 =null;
		Alert alert = new Alert(AlertType.WARNING);
		try {
			con =ConnDB.getCon();
			con.setAutoCommit(false);
			
			String sql1 ="insert into booklist values(booklist_seq.NEXTVAL, ?, ?, ?)";
			pstmt1 =con.prepareStatement(sql1);
			
			pstmt1.setString(1, bookName);
			pstmt1.setString(2, img);
			pstmt1.setString(3, auther);
			
			pstmt1.executeUpdate();
			
			String sql2 ="insert into booktype values(booklist_seq.CURRVAL, ?, ?)";
			pstmt2 =con.prepareStatement(sql2);
			
			pstmt2.setString(1, bookPrice);
			pstmt2.setString(2, bookType);
			
			pstmt2.executeUpdate();
			
			String sql3 ="insert into stocksale values(booklist_seq.CURRVAL, ?, 0)";
			pstmt3 =con.prepareStatement(sql3);
			pstmt3.setInt(1, cnt);
			
			pstmt3.executeUpdate();
			
			con.commit();
			
			System.out.println("커밋 완료!");
			alert.setHeaderText("책 추가 완료!");
			alert.showAndWait();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				con.rollback();
				System.out.println("작업 롤백");
				alert.setHeaderText(e.getMessage() + "\n책 추가 실패!");
				alert.showAndWait();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
	
	public static void updateUserCommit(String id, String pw, String name, String addr, String email) {
		Connection con =null;
		PreparedStatement pstmt =null;
		Alert alert = new Alert(AlertType.INFORMATION);
		
		try {
			con =ConnDB.getCon();
			String sql ="update join_users set pw=?, name=?, addr=?, email=? where id=?";
			pstmt =con.prepareStatement(sql);
			
			//값넣기
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, email);
			pstmt.setString(5, id);
			
			pstmt.executeUpdate();
			
			alert.setHeaderText("수정 완료!");
			alert.showAndWait();
			
			System.out.println("update Complete!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ConnDB.closing(con, pstmt, null);
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	public static void deleteUserCommit(String id) {
		Connection con =null;
		PreparedStatement pstmt =null;
		Alert alert = new Alert(AlertType.INFORMATION);
		
		try {
			con =ConnDB.getCon();
			String sql ="delete from join_users where id =?";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			alert.setHeaderText("삭제 완료!");
			alert.showAndWait();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnDB.closing(con, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void cashChargeUpdate(int cash, String id) {
		Connection con =null;
		PreparedStatement pstmt =null;
		Alert alert = new Alert(AlertType.WARNING);
		
		try {
			con =ConnDB.getCon();
			String sql ="update join_users set cash=? where id=?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, cash);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
			alert.setHeaderText("캐시 충전 완료!");
			alert.showAndWait();
			ShopViewController.CASH_CHK = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			alert.setHeaderText(e.getMessage() + "\n오류가 발생하였습니다.");
			alert.showAndWait();
		} finally {
			try {
				ConnDB.closing(con, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteUser(String id) {
		Connection con =null;
		PreparedStatement pstmt =null;
		Alert alert = new Alert(AlertType.WARNING);
		
		try {
			con =ConnDB.getCon();
			String sql ="delete form join_users where id = ?";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			alert.setHeaderText(id + " 회원 삭제 완료!");
			alert.showAndWait();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			alert.setHeaderText(e.getMessage() + "유저 삭제에 실패!");
			alert.showAndWait();
		} finally {
			try {
				ConnDB.closing(con, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
