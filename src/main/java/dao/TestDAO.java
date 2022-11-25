package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAO {

	// データベース接続に使用する情報
	private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost/sample";
	private final static String USER = "root";
	private final static String PASS = "";

	public static void main(String[] args) {

		Connection con = null;

		try {
			// データベースに接続する準備。
			// Class.forName()メソッドにJDBCドライバ名を与えJDBCドライバをロード
			Class.forName(RDB_DRIVE);

			// 接続先の情報。引数:「JDMC接続先情報」,「ユーザー名」,「パスワード」
			con = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("接続成功");

			// SELECT文を準備
			String sql = "SELECT * FROM users";
			PreparedStatement pStmt = con.prepareStatement(sql);

			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				// 結果票からデータを取得
				String userId = rs.getString("login_id");
				String pass = rs.getString("password");
				System.out.println(userId + pass);
			}

			// forName()で例外発生
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("no1");

			// getConnection()で例外発生
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("no2");

		} finally {
			try {
				if (con != null) {
					// データベースを切断
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
