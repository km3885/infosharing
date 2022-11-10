package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.AccountBean;
import model.bean.LoginBean;

public class AccountDAO {
	
	// データベース接続に使用する情報
	private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/sample";
	private final String USER = "root";
	private final String PASS = "";
	

	public AccountBean findByLogin(LoginBean login) {
		AccountBean account = null;

		// データベースへ接続
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			
			// SELECT文を準備
			String sql = "SELECT login_id, password FROM users WHERE login_id = ? AND password = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザが存在した場合
			// そのユーザを表すAccountインスタンスを生成
				if (rs.next()) {
					// 結果票からデータを取得
					String userId = rs.getString("login_id");
					String pass = rs.getString("password");
					account = new AccountBean(userId, pass);
				}
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
			} catch (Exception e) {
				System.out.println("JDBCデータベース接続エラー:" + e);
			}
		// 見つかったユーザまたはnullを返す
		return account;
		}
}
