package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.StudentBean;

public class StudentDAO {
	
	// データベース接続に使用する情報
	private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/sample";
	private final String USER = "root";
	private final String PASS = "";
	

	public StudentBean findStudent( StudentBean stu) {
		StudentBean stu1 = null;

		// データベースへ接続
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			
			// SELECT文を準備
			String sql = "SELECT * FROM students WHERE name = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, stu.getName());

			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したstudentが存在した場合
			// そのユーザを表すStudentBeanインスタンスを生成
			// 結果票からデータを取得
					int id = rs.getInt("id");
					int no = rs.getInt("no");
					String name  = rs.getString("name");
					String statu  = rs.getString("statu");
					stu1 = new StudentBean(id, no, name, statu);
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
			} catch (Exception e) {
				System.out.println("JDBCデータベース接続エラー:" + e);
			}
		// 見つかったユーザまたはnullを返す
		return stu1;
		}
}
