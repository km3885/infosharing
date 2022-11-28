package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.AccountBean;

public class AccountDAO {

	// データベース接続に使用する情報
	private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/sample";
	private final String USER = "root";
	private final String PASS = "";

	// ログインした情報が一致するアカウントがあるか確認
	public AccountBean findByLogin(AccountBean login) {
			AccountBean account = null;
			Connection con = null;
			

			// データベースへ接続
			try {
				// Class.forName()メソッドにJDBCドライバ名を与えJDBCドライバをロード
				Class.forName(RDB_DRIVE);
				
				// 接続先の情報。引数:「JDMC接続先情報」,「ユーザー名」,「パスワード」
				con = DriverManager.getConnection(URL, USER, PASS);
				
				// SELECT文を準備
				String sql = "SELECT login_id, password FROM users WHERE login_id = ? AND password = ?";
				PreparedStatement pStmt = con.prepareStatement(sql);

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

	// ログインしたアカウント情報を取得
	public AccountBean getAccount(AccountBean login) {
		AccountBean account = null;
		Connection con = null;
		

		// データベースへ接続
		try {
			// Class.forName()メソッドにJDBCドライバ名を与えJDBCドライバをロード
			Class.forName(RDB_DRIVE);
			
			// 接続先の情報。引数:「JDMC接続先情報」,「ユーザー名」,「パスワード」
			con = DriverManager.getConnection(URL, USER, PASS);
			
			// SELECT文を準備
			String sql = "SELECT * FROM users ";
			PreparedStatement pStmt = con.prepareStatement(sql);

			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			// そのユーザを表すAccountインスタンスを生成
			if (rs.next()) {
				// 結果票からデータを取得
				String loginId = rs.getString("login_id");
				String pass = rs.getString("password");
				String userName = rs.getString("user_name");
				boolean role = rs.getBoolean("role");
				account = new AccountBean(loginId, pass, userName, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println("JDBCデータベース接続エラー:" + e);
		}
		//
		return account;
	}
}
