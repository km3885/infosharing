package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.bean.StudentBean;

public class StudentDAO {

	// データベース接続に使用する情報
	private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/sample";
	private final String USER = "root";
	private final String PASS = "";

	// 訓練生情報取得
	public StudentBean findStudent(StudentBean stu) {
		StudentBean stu1 = null;
		// SELECT文を準備
		String sql = "SELECT * FROM students WHERE no = ?";

		// データベースへ接続
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = con.prepareStatement(sql);
			) {
			Class.forName(RDB_DRIVE);
			System.out.println("success");
			pStmt.setString(1, stu.getNo());

			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したstudentが存在した場合
			// そのユーザを表すStudentBeanインスタンスを生成
			if (rs.next()) {
				// 結果票からデータを取得
				int id = rs.getInt("id");
				String no = rs.getString("no");
				String name = rs.getString("name");
				String state = rs.getString("state");
				stu1 = new StudentBean(id, no, name, state);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println("JDBCデータベース接続エラー:" + e);
		}
		// 見つかったユーザまたはnullを返す
		return stu1;
	}
	
	
	// 訓練生情報取得（全員）
	
	public List<StudentBean> findStudent() {
		List<StudentBean> stuList = null;
		
		// SELECT文を準備
		String sql = "SELECT * FROM students";
		
		// データベースへ接続
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = con.prepareStatement(sql);
			) {
			Class.forName(RDB_DRIVE);
			System.out.println("success");

			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したstudentが存在した場合
			// そのユーザを表すStudentBeanインスタンスを生成
			if (rs.next()) {
				// 結果票からデータを取得
				int id = rs.getInt("id");
				String no = rs.getString("no");
				String name = rs.getString("name");
				String state = rs.getString("state");
				StudentBean stu1 = new StudentBean(id, no, name, state);
				stuList.add(stu1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println("JDBCデータベース接続エラー:" + e);
		}
		return stuList;
	}
}
